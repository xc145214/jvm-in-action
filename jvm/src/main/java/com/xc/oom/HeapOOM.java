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
package com.xc.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * 堆内存溢出
 * vm args: -Xms20m -Xmx20m  -XX:+HeapDumpOnOutOfMemoryError -XX:+PrintGCDetails
 *
 *
 * @author xiachuan at 2016/12/9 14:36。
 */

public class HeapOOM {

    static class OOMObject {
    }

    public static void main(String[] args) {

        List<OOMObject> objectList = new ArrayList<OOMObject>();

        while (true){
            objectList.add(new OOMObject());
        }
    }
}

