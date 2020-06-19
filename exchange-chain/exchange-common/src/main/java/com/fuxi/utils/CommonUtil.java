package com.fuxi.utils;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.interfaces.RSAPrivateKey;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 常用工具类
 */
public class CommonUtil {

    private static int id = 1;

    //生成随机数字和字母,
    public static String getStringRandom(int length) {
        String val = "";
        Random random = new Random();
        //参数length，表示生成几位随机数
        for (int i = 0; i < length; i++) {
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            //输出字母还是数字
            if ("char".equalsIgnoreCase(charOrNum)) {
                //输出是大写字母还是小写字母
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char) (random.nextInt(26) + temp);
            } else if ("num".equalsIgnoreCase(charOrNum)) {
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }

    /**
     * 生成不重复的随机数
     *
     * 随机指定范围内N个不重复的数
     * 在初始化的无重复待选数组中随机产生一个数放入结果中，
     * 将待选数组被随机到的数，用待选数组(len-1)下标对应的数替换
     * 然后从len-2里随机产生下一个随机数，如此类推
     * @param min  指定范围最小值
     * @param max  指定范围最大值
     * @param n  随机数个数
     * @return int[] 随机数结果集
     */
    public static int[] getUniqueRandomInt(int min,int max,int n) {
        int len = max-min+1;

        if(max < min || n > len){
            return null;
        }

        //初始化给定范围的待选数组
        int[] source = new int[len];
        for (int i = min; i < min+len; i++){
            source[i-min] = i;
        }

        int[] result = new int[n];
        Random rd = new Random();
        int index = 0;
        for (int i = 0; i < result.length; i++) {
            //待选数组0到(len-2)随机一个下标
            index = Math.abs(rd.nextInt() % len--);
            //将随机到的数放入结果集
            result[i] = source[index];
            //将待选数组中被随机到的数，用待选数组(len-1)下标对应的数替换
            source[index] = source[len];
        }
        return result;
    }

    /**
     * 生成不重复的随机数
     *
     * 随机指定范围内N个不重复的数
     * 在初始化的无重复待选数组中随机产生一个数放入结果中，
     * 将待选数组被随机到的数，用待选数组(len-1)下标对应的数替换
     * 然后从len-2里随机产生下一个随机数，如此类推
     * @param number
     */
    public static String getUniqueRandomInt(int number) {
        int[] a =  getUniqueRandomInt(0,9,number);
        int iMax = a.length - 1;

        StringBuilder b = new StringBuilder();
        for (int i = 0; ; i++) {
            b.append(a[i]);
            if (i == iMax)
                return b.toString();
        }
    }

    public static String generateCode(String codeType) {
        String typeStr = codeType.substring(codeType.lastIndexOf(".") + 1).toUpperCase();
        String dateString = "";
        String code = typeStr + UUID.randomUUID().toString() + "UUID";
            try {
                SimpleDateFormat e = new SimpleDateFormat("yyyyMMddHHmmssSSSS");
                dateString = e.format(new Date());
                code = typeStr + dateString + getSeq();
                return code;
            } catch (Exception var11) {
                return code;
            } finally {
                ;
            }
    }

    public static String generateUUIDCode(String codeType) {
        String typeStr = codeType.substring(codeType.lastIndexOf(".") + 1).toUpperCase();
        typeStr = typeStr + UUID.randomUUID().toString().replace("-", "");
        return typeStr.length() < 50 ? typeStr : typeStr.substring(0, 49);
    }

    private static int getSeq() {
        return id > 99999 ? (id = 1) : ++id;
    }

    public static String[] shortUrl(String url) {
        // 可以自定义生成 MD5 加密字符传前的混合 KEY
        String key = "";
        // 要使用生成 URL 的字符
        String[] chars = new String[]{"a", "b", "c", "d", "e", "f", "g", "h",
                "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
                "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
                "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H",
                "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
                "U", "V", "W", "X", "Y", "Z"};

        // 对传入网址进行 MD5 加密
        String sMD5EncryptResult = DigestUtils.md5Hex(key + url);
        String hex = sMD5EncryptResult;
        String[] resUrl = new String[4];
        for (int i = 0; i < 4; i++) {
            // 把加密字符按照 8 位一组 16 进制与 0x3FFFFFFF 进行位与运算
            String sTempSubString = hex.substring(i * 8, i * 8 + 8);
            // 这里需要使用 long 型来转换，因为 Inteper .parseInt() 只能处理 31 位 , 首位为符号位 , 如果不用
            // long ，则会越界
            long lHexLong = 0x3FFFFFFF & Long.parseLong(sTempSubString, 16);
            String outChars = "";
            for (int j = 0; j < 6; j++) {
                // 把得到的值与 0x0000003D 进行位与运算，取得字符数组 chars 索引
                long index = 0x0000003D & lHexLong;
                // 把取得的字符相加
                outChars += chars[(int) index];
                // 每次循环按位右移 5 位
                lHexLong = lHexLong >> 5;
            }

            // 把字符串存入对应索引的输出数组
            resUrl[i] = outChars;
        }
        return resUrl;
    }

    /**
     *生成默认用户登录名 规则user_【3个字母】+【6个数字】
     * @return
     */
    public static String generateDefaultUserName() {
        StringBuffer sb = new StringBuffer("es_");
        return sb.append(getItemName(3)).append(getUniqueRandomInt(6)).toString();
    }

    /**
     *  md5加密
     * @param s
     * @return
     */
    public static String MD5(String s) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String UUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 生产ItemName随机函数
     * @param length
     * @return
     */
    private static String getItemName( int length ){
        String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for ( int i = 0; i < length; i++ )
        {
            int number = random.nextInt( base.length() );
            sb.append( base.charAt( number ) );
        }
        return sb.toString();
    }

    /**
     * 产生不随机小数
     * @param min 最小范围
     * @param max 最大范围
     * @param n 小数点后几位
     * @return
     */
    public static BigDecimal generateRandomDecimals(double min,double max ,int n) {
        BigDecimal db = new BigDecimal(Math.random() * (max - min) + min).setScale(n,BigDecimal.ROUND_HALF_UP);
        return db;
    }

    /**
     *  通过AES128和RSA解密密文
     * @param ciphertext
     * @param keyCiphertext
     * @param privateKey
     * @return
     */
    public  static String decryptPasswordThroughAesAndRsa(String ciphertext, String keyCiphertext, String privateKey) throws Exception {
        byte[] decode = Base64.decode(keyCiphertext);
        RSAPrivateKey privateKey1 = RSAUtil.loadPrivateKeyByStr(privateKey);
        byte[] decrypt = RSAUtil.decrypt(privateKey1, decode);
        String key = new String(decrypt);
        String str = AESUtil.decryptCompatibilityIOS(ciphertext, key);
        return str;
    }

    /**
     *  使用正则表达式提取中括号中的内容
     * @param msg
     * @return
     */
    public static List<String> extractMessageByRegular(String msg){

        List<String> list=new ArrayList<String>();
        Pattern p = Pattern.compile("(\\[[^\\]]*\\])");
        Matcher m = p.matcher(msg);
        while(m.find()){
            list.add(m.group().substring(1, m.group().length()-1));
        }
        return list;
    }

}
