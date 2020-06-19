package com.fuxi.bridge.handler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fuxi.bridge.constants.CommonConst;
import com.fuxi.bridge.constants.ContractInfo;
import com.fuxi.bridge.entity.TransactionLog;
import com.fuxi.bridge.service.TransactionService;
import com.fuxi.bridge.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Date;

/**
 * @Auther: Laker
 * @Date: 2020/5/27 17:12
 * @Description:
 */
@Component
@Slf4j
public class EventLogAnalysisHandler {


    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private TransactionService transactionService;


    /**
     *   handler transcation eventlogs
     */
    public void startAnalysisEventLog(){
        log.info("启动分析....");
        while (true) {
            long qSize = redisUtil.getQSize(ContractInfo.TRANFER_EVENT_LOG_QUEUE);
            if (qSize > 0) {
                log.info("check:{}",qSize);
                boolean b = analysisEventLog((String) redisUtil.rPop(ContractInfo.TRANFER_EVENT_LOG_QUEUE));
                if (b) {
                    log.info("startAnalysisEventLog:收录一条交易信息^");
                } else {
                    log.info("startAnalysisEventLog:收录失败或为重复信息！");
                }
            } else {
                log.info("check:{}","nothing,go to sleep...");
                try {
                    Thread.sleep(20*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private boolean analysisEventLog(String json) {
        JSONObject jsonObject = JSONObject.parseObject(json);
        if (jsonObject!=null) {
            TransactionLog transactionLog = new TransactionLog();
            JSONObject logs = jsonObject.getJSONObject("log");
            transactionLog.setAddress(logs.getString("address"));
            transactionLog.setBlockHash(logs.getString("blockHash"));
            transactionLog.setBlockNumber(logs.getInteger("blockNumber"));
            transactionLog.setData(logs.getString("data"));
            transactionLog.setLogIndex(logs.getLong("logIndex"));
            transactionLog.setRemoved(logs.getBoolean("removed"));
            transactionLog.setTransactionHash(logs.getString("transactionHash"));
            transactionLog.setTransactionIndex(logs.getInteger("transactionIndex"));
           if (transactionService.isRepetRecord(transactionLog)){
               log.info("startAnalysisEventLog:回调数据重复...");
               return false;
           }

//           analysis eventlogs
            JSONArray logParams = jsonObject.getJSONArray("logParams");
            transactionLog.setCreateTime(new Date());
            if (logParams != null && logParams.size() > 0) {
                    logParams.stream().forEach(o -> {
                        JSONObject jsonObject1 = JSONObject.parseObject(JSON.toJSONString(o));
                        if ("inAdder".equals(jsonObject1.getString(CommonConst.NAME))) {
                            transactionLog.setEventInAddress(jsonObject1.getString(CommonConst.DATA));
                        }
                        if ("outAdder".equals(jsonObject1.getString(CommonConst.NAME))) {
                            transactionLog.setEventOutAddress(jsonObject1.getString(CommonConst.DATA));
                        }
                        if ("amount".equals(jsonObject1.getString(CommonConst.NAME))) {
                            transactionLog.setEventAmount(jsonObject1.getBigDecimal(CommonConst.DATA));
                        }
                        if ("message".equals(jsonObject1.getString(CommonConst.NAME))) {
                            transactionLog.setEventMessage(jsonObject1.getString(CommonConst.DATA));
                        }
                        if ("timestamp".equals(jsonObject1.getString(CommonConst.NAME))) {
                            transactionLog.setEventTimestamp(jsonObject1.getTimestamp("timestamp"));
                            transactionLog.setEventTimestampv(jsonObject1.getLong("timestamp"));
                        }
                    });
            }
            log.info("analysisEventLog->:{}",transactionLog.toString());
            int i = transactionService.insertSelective(transactionLog);
            if (i > 0) {
                return true;
            }
            return false;
        } else {
            return false;
        }
    }

}
