package com.fuxi.utils;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Auther: chenghaiming
 * @Date: 2018/12/24 17:59
 * @Description:
 */
public class Sha256Util {

    public static String getSHA256Str(String str) {
        MessageDigest messageDigest;
        String encodeStr = null;
        try {
            encodeStr = "";
            messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes("UTF-8"));
            encodeStr = SecurityUtil.bytes2HexString(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encodeStr;
    }
}
