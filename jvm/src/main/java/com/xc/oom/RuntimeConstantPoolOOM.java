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
 * vm Args: -XX:PermSize=10M -XX:MaxPermSize=10M
 *
 * @author xiachuan at 2016/12/14 16:10。
 */

public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {

        //使用List保持常量池引用，避免Full GC 回收常量池。
        List<String> list = new ArrayList<String >();
        int i = 0;

        while (true){
            list.add(String.valueOf(i++).intern());
        }
    }
}

