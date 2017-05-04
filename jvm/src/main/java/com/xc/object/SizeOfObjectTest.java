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

import java.io.File;

import static com.xc.object.SizeOfObject.fullSizeOf;
import static com.xc.object.SizeOfObject.sizeOf;

/**
 *
 * @author xiachuan at 2017/4/26 9:49。
 */

public class SizeOfObjectTest {
    /**
     * -XX:+UseCompressedOops: mark/4 + metedata/8 + 4 = 16
     * -XX:-UseCompressedOops: mark/8 + metedata/8 + 4 + padding/4 = 24
     */
    static class A {
        int a;
    }

    /**
     * -XX:+UseCompressedOops: mark/4 + metedata/8 + 4 + 4 + padding/4 = 24
     * -XX:-UseCompressedOops: mark/8 + metedata/8 + 4 + 4 = 24
     */
    static class B {
        int a;
        int b;
    }

    /**
     * -XX:+UseCompressedOops: mark/4 + metedata/8 + 4 + 4 + padding/4 = 24
     * -XX:-UseCompressedOops: mark/8 + metedata/8 + 8 + 4 + padding/4 = 32
     */
    static class B2 {
        int b2a;
        Integer b2b;
    }

    /**
     * 不考虑对象头：
     * 4 + 4 + 4 * 3 + 3 * sizeOf(B)
     */
    static class C extends A {
        int ba;
        B[] as = new B[3];

        C() {
            for (int i = 0; i < as.length; i++) {
                as[i] = new B();
            }
        }
    }

    static class D extends B {
        int da;
        Integer[] di = new Integer[3];
    }

    /**
     * 会算上A的实例字段
     */
    static class E extends A {
        int ea;
        int eb;
    }

    public static void main(String[] args) throws IllegalAccessException {
        System.out.println(new File("./target/classes").getAbsolutePath());
        System.out.println("sizeOf(new Object())=" + sizeOf(new Object()));
        System.out.println("sizeOf(new A())=" + sizeOf(new A()));
        System.out.println("sizeOf(new B())=" + sizeOf(new B()));
        System.out.println("sizeOf(new B2())=" + sizeOf(new B2()));
        System.out.println("sizeOf(new B[3])=" + sizeOf(new B[3]));
        System.out.println("sizeOf(new C())=" + sizeOf(new C()));
        System.out.println("fullSizeOf(new C())=" + fullSizeOf(new C()));
        System.out.println("sizeOf(new D())=" + sizeOf(new D()));
        System.out.println("fullSizeOf(new D())=" + fullSizeOf(new D()));
        System.out.println("sizeOf(new int[3])=" + sizeOf(new int[3]));
        System.out.println("sizeOf(new Integer(1)=" + sizeOf(new Integer(1)));
        System.out.println("sizeOf(new Integer[0])=" + sizeOf(new Integer[0]));
        System.out.println("sizeOf(new Integer[1])=" + sizeOf(new Integer[1]));
        System.out.println("sizeOf(new Integer[2])=" + sizeOf(new Integer[2]));
        System.out.println("sizeOf(new Integer[3])=" + sizeOf(new Integer[3]));
        System.out.println("sizeOf(new Integer[4])=" + sizeOf(new Integer[4]));
        System.out.println("sizeOf(new A[3])=" + sizeOf(new A[3]));
        System.out.println("sizeOf(new E())=" + sizeOf(new E()));
    }
}

