package com.csx.framework.bean;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 返回数据对象
 * @Author: csx
 * @Date: 2017-09-26
 */
public class Data {
    /**
     * 数据对象
     */
    private Object model;

    public Data(Object model) {
        this.model = model;
    }

    public Object getModel() {
        return model;
    }

}
