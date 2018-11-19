package com.csx.framework.util;

import org.apache.commons.lang3.ArrayUtils;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 数组工具类
 * @Author: csx
 * @Date: 2017-09-25
 */
public final class ArrayUtil {
    public static boolean isNotEmpty(Object[] array){
        return !ArrayUtils.isEmpty(array);
    }

    public static boolean isEmpty(Object[] array){
        return ArrayUtils.isEmpty(array);
    }
}
