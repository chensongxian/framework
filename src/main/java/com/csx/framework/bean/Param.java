package com.csx.framework.bean;

import com.csx.framework.util.CastUtil;
import org.apache.commons.collections.MapUtils;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 请求参数对象
 * @Author: csx
 * @Date: 2017-09-26
 */
public class Param {
    private Map<String,Object> paramMap;

    public Param(Map<String, Object> paramMap) {
        this.paramMap = paramMap;
    }

    /**
     * 根据参数名获取long型参数值
     * @param name
     * @return
     */
    public Long getLong(String name){
        return CastUtil.castLong(paramMap.get(name));
    }

    public Map<String, Object> getParamMap() {
        return paramMap;
    }
}
