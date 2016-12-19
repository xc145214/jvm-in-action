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
package com.xc.gc;


/**
 *
 *
 * @author xiachuan at 2016/12/19 9:52。
 */

public class ReferenceCountingGC {

    public Object instance = null;

    private static final  int _1MB = 1024 * 1024;

    /**
     * 此成员变量的意义在于占用内存，方便能在gc日志中查看是否被回收。
     */
    private byte[] bigSize = new byte[2* _1MB];

    public static void testGC(){
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();

        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;

        //调用GC
        System.gc();


    }


    public static void main(String[] args) {
        testGC();
    }


}

