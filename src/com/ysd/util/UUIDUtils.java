package com.ysd.util;

import java.util.UUID;

public class UUIDUtils {

    public static String getUUID(){
         return UUID.randomUUID().toString().replace("-", "");
    }

    public static void main(String[] args) {
        System.out.println("��ʽǰ��UUID �� " + UUID.randomUUID().toString());
        System.out.println("��ʽ�����UUID ��" + getUUID());
    }
}