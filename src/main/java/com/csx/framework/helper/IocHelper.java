package com.csx.framework.helper;



import com.csx.framework.util.ReflectionUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 依赖注解助手类
 * @Author: csx
 * @Date: 2017-09-25
 */
public final class IocHelper {
    static {
        //获取所有bean类和bean实例的映射关系
        Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
        if(MapUtils.isNotEmpty(beanMap)){
            //遍历beanMap
            for (Map.Entry<Class<?>,Object> entry:beanMap.entrySet()){
                //从beanMap中获取bean类和bean实例
                Class<?> beanClass=entry.getKey();
                Object beanInstance=entry.getValue();

                //从bean中获取所有成员边
                Field[] beanFields = beanClass.getDeclaredFields();

                if (ArrayUtils.isNotEmpty(beanFields)){
                    //遍历beanFields
                    for(Field beanField:beanFields){
                        //从beanMap中获取field对应的实例
                        Class<?> beanFieldClass = beanField.getType();
                        Object beanFieldInstance = beanMap.get(beanFieldClass);
                        if(beanFieldInstance!=null){
                            //通过反射初始化field的值
                            ReflectionUtil.setField(beanInstance,beanField,beanFieldInstance);
                        }
                    }
                }
            }
        }
    }
}
