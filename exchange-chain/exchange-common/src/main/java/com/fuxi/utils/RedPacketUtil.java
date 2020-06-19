package com.fuxi.utils;

import com.alibaba.fastjson.JSONObject;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.jar.JarEntry;

/**
 * @Auther: chenghaiming
 * @Date: 2018/10/15 16:59
 * @Description:
 */
public class RedPacketUtil {

    //最小红包额度
//    private   int MINMONEY = 1;
    //最大红包额度
//    private   int MAXMONEY = 200 * 100;
    //每个红包最大是平均值的倍数
    private static final double TIMES = 5;

    /**
     * 拆分红包
     * @param money
     * @param count
     * @return
     */
    public static List<Integer> splitRedPackets(int money, int count,int MAXMONEY,int MINMONEY) {

        if (!isRight(money, count,MAXMONEY,MINMONEY)) {
            return null;
        }
        List<Integer> list = new ArrayList<Integer>();
        //红包最大金额为平均金额的TIMES倍
        int max = (int) (money * TIMES / count);
        max = max > MAXMONEY ? MAXMONEY : max;
        for (int i = 0; i < count; i++) {
            int one = random(money, MINMONEY, max, count - i,MAXMONEY,MINMONEY);
            list.add(one);
            money -= one;
        }
        return list;
    }


    /**
     *  随机红包额度
     * @param money
     * @param minS
     * @param maxS
     * @param count
     * @return
     */
    private static int random(int money, int minS, int maxS, int count,int MAXMONEY,int MINMONEY) {
        //红包数量为1，直接返回金额
        if (count == 1) {
            return money;
        }
        //如果最大金额和最小金额相等，直接返回金额
        if (minS == maxS) {
            return minS;
        }
        int max = maxS > money ? money : maxS;
        //随机产生一个红包
        int one = ((int)Math.rint(Math.random() * (max - minS) + minS)) % max + 1;
        int money1 = money - one;
        //判断该种分配方案是否正确
        if (isRight(money1, count -1,MAXMONEY,MINMONEY)) {
            return one;
        } else {
            double avg = money1 / (count - 1);
            if (avg < MINMONEY) {
                //递归调用，修改红包最大金额
                return random(money, minS, one, count,MAXMONEY,MINMONEY);
            }else if (avg > MAXMONEY) {
                //递归调用，修改红包最小金额
                return random(money, one, maxS, count,MAXMONEY,MINMONEY);
            }
        }
        return one;
    }


    /**
     * 判断红包是否合法
     * @param money
     * @param count
     * @return
     */
    private static boolean isRight(int money, int count,int MAXMONEY,int MINMONEY) {
        double avg = money / count;
        if (avg < MINMONEY) {
            return false;
        }
        if (avg > MAXMONEY) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        RedPacketUtil util = new RedPacketUtil();
        List<Integer> integers = util.splitRedPackets(20000, 100,250,160);

        System.out.println("前--->"+JSONObject.toJSONString(integers));
        Collections.shuffle(integers);
        System.out.println("后--->"+JSONObject.toJSONString(integers));
    }
}
