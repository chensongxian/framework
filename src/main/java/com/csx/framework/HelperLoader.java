package com.csx.framework;

import com.csx.framework.annotation.Controller;
import com.csx.framework.helper.BeanHelper;
import com.csx.framework.helper.ClassHelper;
import com.csx.framework.helper.IocHelper;
import com.csx.framework.util.ClassUtil;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 加载相应的helper类
 * @Author: csx
 * @Date: 2017-09-26
 */
public class HelperLoader {
    public static void init(){
        Class<?>[] classList={
                ClassHelper.class,
                BeanHelper.class,
                IocHelper.class,
                Controller.class
        };
        for(Class<?> cls:classList){
            ClassUtil.loadClass(cls.getName());
        }
    }
}
