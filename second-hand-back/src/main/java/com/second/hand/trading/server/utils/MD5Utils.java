package com.second.hand.trading.server.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Title: MD5Utils
 * @Description:
 * @Author: localUser
 * @Version: 1.0
 * @create: 2024/3/28 16:47
 */
public class MD5Utils {
    private static final String salt = "(*%213&)()fdskfj2136";

    public static void main(String[] args) {
        System.out.println(encode("123"));
    }

    /**
     * 可以把一段文字转换为MD
     * Can convert a file to MD5
     * @param text
     * @return md5
     */
    public static String encode(String text){
        try {
            MessageDigest digest = MessageDigest.getInstance("md5");
            text=text+salt;
            byte[] buffer = digest.digest(text.getBytes());
            StringBuffer sb = new StringBuffer();
            for (byte b : buffer) {
                int a = b & 0xff;
                String hex = Integer.toHexString(a);
                if (hex.length() == 1) {
                    hex = 0 + hex;
                }
                sb.append(hex);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
