package com.fuxi.constant;

public interface CommonConst {

    /**
     * sec
     */
    public static final Integer SECOND_UNIT = 1;


    /**
     *  min
     */
    public static final Integer MINUTE_UNIT = SECOND_UNIT * 60;

    /**
     *  token deadline
     */
    public static final Integer CUSTOMER_TOKEN_DEADLINE = 30 * MINUTE_UNIT;


    /**
     *  Logic to delete，0:normal，1：delete
     */
    public static final Byte LOGIC_NORMAL = 0;

    public static final Byte LOGIC_DELETE = 1;
}
