package com.fuxi.bridge.event;

import com.fuxi.bridge.contracts.ScoreDB;
import com.fuxi.bridge.dao.AccountAddressMapper;
import com.fuxi.bridge.entity.AccountAddress;
import com.fuxi.bridge.pojo.TransactionEventLogPushWithDecodeCallback;
import com.fuxi.bridge.utils.RedisUtil;
import com.fuxi.bridge.constants.GasConstants;
import com.fuxi.bridge.handler.EventLogAnalysisHandler;
import lombok.extern.slf4j.Slf4j;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.crypto.gm.GenCredential;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Auther: Laker
 * @Date: 2020/5/27 09:39
 * @Description: on application start event.
 */
@Component
@Slf4j
public class ApplicationStartedEventListener implements ApplicationListener<ApplicationStartedEvent>,Ordered {


    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private Web3j web3j;

    @Value("${event-log.tranferEvent.fromBlock}")
    private String fromBlock;

    @Autowired
    private EventLogAnalysisHandler eventLogAnalysisHandler;

    @Value("${contracts.ScoreDB.address}")
    private String scoreDbAddr;

    @Value("${admin.keypairs.id}")
    private Long adminId;

    @Autowired
    private AccountAddressMapper accountAddressMapper;

    /**
     *  open listener register
     * @param applicationStartedEvent
     */
    @Override
    public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {
        log.info("启动监听器注册->->->->->->->->->->->->->->->->->->->->");
//        1、subscribe transcation evenlog and open listener .
        subscribeTransferEventLog(redisUtil);
        log.info("启动监听器成功<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-");
//        2、open transcation evenlog handler.
        log.info("开启【EventLog】解析器......");
        startTranscationAnalysisHandler();
        log.info("【EventLog】解析器开启。");
    }

    /**
     *  transcation evenlog handler.
     */
    private void startTranscationAnalysisHandler() {
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        singleThreadExecutor.execute(new Runnable() {
            @Override
            public void run() {
                eventLogAnalysisHandler.startAnalysisEventLog();
            }
        });
        singleThreadExecutor.shutdown();
    }

    /**
     * transcation eventlog  subscibe.
     * @param redisUtil
     */
    private void subscribeTransferEventLog(RedisUtil redisUtil) {
        log.info("开启【tranferEvent】订阅......");
        AccountAddress adminAccount = accountAddressMapper.selectByPrimaryKey(adminId);
        Credentials credentials = GenCredential.create(adminAccount.getPrivateKey());
        ScoreDB scoreDB = ScoreDB.load(scoreDbAddr, web3j, credentials, GasConstants.SGP);
        String toBlock = "latest";
        ArrayList<String> otherTopic = new ArrayList<>();
        TransactionEventLogPushWithDecodeCallback callback = new TransactionEventLogPushWithDecodeCallback(redisUtil);
        scoreDB.register_TranferEventLogFilter(fromBlock, toBlock, otherTopic, callback);
        log.info("开启【tranferEvent】成功!!!!!");
    }

    @Override
    public int getOrder() {
        return 1;
    }




}
