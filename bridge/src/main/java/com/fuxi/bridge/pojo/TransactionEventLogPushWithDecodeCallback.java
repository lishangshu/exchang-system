package com.fuxi.bridge.pojo;

import com.alibaba.fastjson.JSONObject;
import com.fuxi.bridge.constants.ContractInfo;
import com.fuxi.bridge.utils.RedisUtil;
import com.fuxi.bridge.constants.ContractInfo;
import com.fuxi.bridge.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.fisco.bcos.channel.event.filter.EventLogPushWithDecodeCallback;
import org.fisco.bcos.web3j.tx.txdecode.LogResult;

import java.util.List;

/**
 * @Auther: Laker
 * @Date: 2020/5/27 15:03
 * @Description:
 */
@Slf4j
public class TransactionEventLogPushWithDecodeCallback extends EventLogPushWithDecodeCallback {

    private RedisUtil redisUtil;

    public TransactionEventLogPushWithDecodeCallback(RedisUtil redisUtil) {
        this.redisUtil = redisUtil;
    }

    /**
     * cache message to redis queue for processing.
     * @param status
     * @param logs
     */
    public void onPushEventLog(int status, List<LogResult> logs) {
        log.info(
                " onPushEventLog, params: {}, status: {}, logs: {}",
                getFilter().getParams(),
                status,
                logs);

        if (status == 0 || status == 1) {
            if (logs != null && logs.size() > 0) {
                logs.stream().forEach(logResult -> {
                    String json = JSONObject.toJSONString(logResult);
                    System.out.println(json);
                    redisUtil.lQSet(ContractInfo.TRANFER_EVENT_LOG_QUEUE, json);
                });

            }
        }
    }
}
