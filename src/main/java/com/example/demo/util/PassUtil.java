package com.example.demo.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import java.net.URLEncoder;

public class PassUtil {
	public static final String PASS="java@helloworld"; // 加密  解密  口令
    /**
     * @param sourceString
     * @param password
     * @return 密文
     * @throws UnsupportedEncodingException 
     */
    public static String encrypt(String sourceString, String password) throws UnsupportedEncodingException {
        char[] p = password.toCharArray(); // 字符串转字符数组
        int n = p.length; // 密码长度
        char[] c = sourceString.toCharArray();
        int m = c.length; // 字符串长度
        for (int k = 0; k < m; k++) {
            int mima = c[k] + p[k / n]; // 加密
            c[k] = (char) mima;
        }
        
        return URLEncoder.encode(new String(c),"utf-8");
    }

    /**
     *
     * @param sourceString
     * @param password
     * @return 明文
     * @throws UnsupportedEncodingException 
     */
    public static String decrypt(String sourceString, String password) throws UnsupportedEncodingException {
    	sourceString=URLDecoder.decode(sourceString, "utf-8");
        char[] p = password.toCharArray(); // 字符串转字符数组
        int n = p.length; // 密码长度
        char[] c = sourceString.toCharArray();
        int m = c.length; // 字符串长度
        for (int k = 0; k < m; k++) {
            int mima = c[k] - p[k / n]; // 解密
            c[k] = (char) mima;
        }
        return new String(c);
    }

    /*
     * 使用例子
     */
    public static void main(String arg[]) throws UnsupportedEncodingException {
        String wen = "abcdefghijklmn你好";
        String pass = "123456789";
        System.out.println(encrypt(wen, pass));
        
        System.out.println(decrypt(encrypt(wen, pass), pass));
    }
}
