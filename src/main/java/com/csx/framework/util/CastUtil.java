package com.csx.framework.util;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2017-09-26
 */
public final class CastUtil {
    public static Long castLong(Object object){
        return Long.parseLong((String) object);
    }
}
