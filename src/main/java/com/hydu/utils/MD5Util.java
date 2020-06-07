package com.hydu.utils;

import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;

/**
 * @Author heyong
 * @Date: 2020/6/7  10:20
 */
@Component
public class MD5Util {
    private static final String SALT = "coolhy";

    public static String encode(String password) {
        password = password + SALT;
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        char[] charArray = password.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++)
            byteArray[i] = (byte) charArray[i];
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }

            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }

    public static void main(String[] args) {
        System.out.println(MD5Util.encode("mayikt"));

    }
}
