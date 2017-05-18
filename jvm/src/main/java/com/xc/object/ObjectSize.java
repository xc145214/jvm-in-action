/*************************************************************************
 *                  HONGLING CAPITAL CONFIDENTIAL AND PROPRIETARY
 *
 *                COPYRIGHT (C) HONGLING CAPITAL CORPORATION 2012
 *    ALL RIGHTS RESERVED BY HONGLING CAPITAL CORPORATION. THIS PROGRAM
 * MUST BE USED  SOLELY FOR THE PURPOSE FOR WHICH IT WAS FURNISHED BY
 * HONGLING CAPITAL CORPORATION. NO PART OF THIS PROGRAM MAY BE REPRODUCED
 * OR DISCLOSED TO OTHERS,IN ANY FORM, WITHOUT THE PRIOR WRITTEN
 * PERMISSION OF HONGLING CAPITAL CORPORATION. USE OF COPYRIGHT NOTICE
 * DOES NOT EVIDENCE PUBLICATION OF THE PROGRAM.
 *                  HONGLING CAPITAL CONFIDENTIAL AND PROPRIETARY
 *************************************************************************/
package com.xc.object;

import org.omg.CORBA.Object;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 通过sun.misc.Unsafe对象的objectFieldOffset(field)等方法结合反射来计算对象的大小;
 *
 * @author xiachuan at 2017/5/18 14:57。
 */

public class ObjectSize {

    class Person  {
        String str1;        //4
        int int1;           //4
        byte byte1;         //1
        boolean aBoolean;   //1
        int int2;           //4
        Object object;      //4
        byte byte2;         //1
        long long1;         //8
    }

    class ObjectA{
        ObjectB[] array = new ObjectB[2];
    }

    private class ObjectB{
        int value;
    }

    private static Unsafe unsafe;

    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }


    public static void showOffset(Field[] fields) {
        for (Field field : fields) {
            System.out.println(field.getName() + " offset: " + unsafe.objectFieldOffset(field));
        }
    }

    public static void main(String[] args) {
        Field[] fields = Person.class.getDeclaredFields();
        showOffset(fields);
    }
}

