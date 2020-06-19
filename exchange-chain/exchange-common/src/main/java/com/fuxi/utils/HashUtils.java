package com.fuxi.utils;

import org.apache.commons.lang3.StringUtils;
import java.lang.reflect.Field;
import java.util.*;

/**
 * @Auther: Laker
 * @Date: 2020/5/25 17:32
 * @Description:
 */
public class HashUtils {


    /**
     *object to map.
     * @param obj
     * @return
     */
    public static Map<String, String> objectToMap(Object obj,Map<String,String> map) {
        if (obj == null) {
            return null;
        }
        try {
            Field[] declaredFields = obj.getClass().getDeclaredFields();
            for (Field field : declaredFields) {
                field.setAccessible(true);
                if (field.get(obj) instanceof String) {
                    map.put(field.getName(), field.get(obj).toString());
                }
            }
        } catch (Exception e) {

        }
        return map;
    }


    /**
     *  Sort by field
     * @param params
     * @return
     */
    public static String createLinkString(Map<String, String> params) {
        List<String> keys = new ArrayList<String>(params.keySet());
        Collections.sort(keys);
        StringBuilder prestrSB = new StringBuilder();
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = params.get(key).trim();
            if (i == keys.size() - 1) {// When splicing, the last & character is not included
                prestrSB.append(key).append("=").append(value);
            } else {
                prestrSB.append(key).append("=").append(value).append("&");
            }
        }
        return prestrSB.toString();
    }

    /**
     *  Digest string hex
     * @return
     */
    public static String digestToHexStr(String digestStr) {
        if (StringUtils.isNotBlank(digestStr)) {
          return   Sha256Util.getSHA256Str(digestStr);
        }
        return null;
    }

}
