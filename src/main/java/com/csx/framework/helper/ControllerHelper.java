package com.csx.framework.helper;

import com.csx.framework.annotation.Action;
import com.csx.framework.bean.Handler;
import com.csx.framework.bean.Request;
import com.csx.framework.util.ArrayUtil;
import javafx.scene.shape.SVGPath;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2017-09-26
 */
public final class ControllerHelper {
    /**
     * 用于存放请求与处理器映射关系
     */
    private static final Map<Request,Handler> ACTION_MAP=new HashMap<>();

    static {
        //获取所有controller类
        Set<Class<?>> controllerClassSet = ClassHelper.getControllerClassSet();

        if(CollectionUtils.isNotEmpty(controllerClassSet)){
            //遍历controller
            for(Class<?> controllerClass:controllerClassSet){
                //获取controller中定义的方法
                Method[] methods = controllerClass.getDeclaredMethods();
                if(ArrayUtil.isNotEmpty(methods)){
                    //遍历controller中method方法
                    for(Method method:methods){
                        //判断方法是否有Action注解
                        if(method.isAnnotationPresent(Action.class)){
                            //从Action获取映射规则
                            Action action = method.getAnnotation(Action.class);
                            String mapping = action.value();
                            //验证URL映射规则
                            if(mapping.matches("\\w+:/\\w*")){
                                String[] array = mapping.split(":");
                                if(ArrayUtil.isNotEmpty(array)&&array.length==2){
                                    //获取请求方法和请求路径
                                    String requestMethod=array[0];
                                    String requestPath=array[1];
                                    Request request = new Request(requestMethod, requestPath);
                                    Handler handler=new Handler(controllerClass,method);
                                    ACTION_MAP.put(request,handler);
                                }

                            }
                        }

                    }
                }

            }
        }
    }

    /**
     * 获取Handler
     * @param requestMethod
     * @param requestPath
     * @return
     */
    public static Handler getHandler(String requestMethod,String requestPath){
        Request request = new Request(requestMethod, requestPath);
        return ACTION_MAP.get(request);
    }

}
