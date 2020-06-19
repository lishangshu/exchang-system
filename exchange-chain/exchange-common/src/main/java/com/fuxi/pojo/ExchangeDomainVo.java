package com.fuxi.pojo;

import com.fuxi.entity.Customer;
import com.fuxi.entity.ExchangeDomain;

/**
 * @Auther: Laker
 * @Date: 2020/6/1 11:33
 * @Description:
 */
public class ExchangeDomainVo extends ExchangeDomain {
    private Customer publisher;

    public Customer getPublisher() {
        return publisher;
    }

    public void setPublisher(Customer publisher) {
        this.publisher = publisher;
    }
}
