package com.itcast.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 * @Author: Lvlingyun
 * @Date: 2024/1/14 15:25
 * @Version: 1.0
 * @Description:
 */
public class MD5Util {
    private static final String MD5_ALGORITHM = "MD5";

    public static String getMD5String(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance(MD5_ALGORITHM);
            byte[] digest = md.digest(password.getBytes());
            return bytesToHex(digest);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 algorithm not available.", e);
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
