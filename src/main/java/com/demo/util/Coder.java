package com.demo.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.util.UUID;


/*加密解密类*/
public class Coder {
    /*解密*/
    public static String decryptBASE64(String key) throws Exception {
        byte[] bytes = new BASE64Decoder().decodeBuffer(key);
        key = new String(bytes);
        key = key.substring(0, key.length() - 6);
        return key;
    }
    /*加密*/
    public static String encryptBASE64(String key) throws Exception {
        key = key + "fzgsxy";
        String encode = new BASE64Encoder().encode(key.getBytes());
        return encode;
    }

    /*测试用*/
    public static void main(String[] args) throws Exception {
        //加密
        String key = "123456";
        String e = encryptBASE64(key);
        System.out.println(e);
        //解密
        String d= decryptBASE64("YTExMTExMTExMTFmemdzeHk=");
        System.out.println(d);
        //uuid
        String name = UUID.randomUUID().toString().replace("-", "");
        System.out.println(name);
    }

}
