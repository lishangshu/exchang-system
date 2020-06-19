package com.fuxi.bridge.event;

import com.fuxi.bridge.BaseTest;
import com.fuxi.bridge.BaseTest;
import org.checkerframework.checker.units.qual.A;
import org.fisco.bcos.channel.client.Service;
import org.fisco.bcos.channel.event.filter.EventLogPushCallback;
import org.fisco.bcos.channel.event.filter.EventLogUserParams;
import org.fisco.bcos.channel.event.filter.ServiceEventLogPushCallback;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

/**
 * @Auther: Laker
 * @Date: 2020/5/26 10:40
 * @Description:
 */
public class EventLog extends BaseTest {

    @Autowired
    private Service service;

    @Test
    public void getAllEventLog(){
        EventLogUserParams params = new EventLogUserParams();

        params.setFromBlock("1");
        params.setToBlock("latest");
        params.setAddresses(new ArrayList<String>());

        params.setTopics(new ArrayList<Object>());

        ServiceEventLogPushCallback callback = new ServiceEventLogPushCallback();

        service.registerEventLogFilter(params, callback);
        EventLogPushCallback callback1 = callback.getFilter().getCallback();
        System.out.println("结束");
    }
}
