package com.study.rpc.serialize;

import java.nio.charset.StandardCharsets;

/**
 * @author zhaopc
 * @date 2021/7/19 21:14
 */
public class Test {
    public static void main(String[] args) {
        String a = "haha";
        byte[] bytes = a.getBytes(StandardCharsets.UTF_8);

        for (byte b : bytes) {
            System.out.print(Integer.toHexString(b & 0xff) + " ");
        }
        System.out.println();

        System.out.println((2 << 3) | 0);

        System.out.println(System.currentTimeMillis());
    }
}
