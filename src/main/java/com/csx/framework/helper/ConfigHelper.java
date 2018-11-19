package com.csx.framework.helper;

import com.csx.framework.util.ConfigConstant;
import com.csx.framework.util.Prop;
import com.csx.framework.util.PropUtil;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 属性文件助手类
 * @Author: csx
 * @Date: 2017-09-20
 */
public final class ConfigHelper {
    private static final Prop CONFIG_PROPS= PropUtil.getProp(ConfigConstant.CONFIG_FILE);

    /**
     * 获取jdbc驱动
     * @return
     */
    public static String getJdbcDriver(){
        return CONFIG_PROPS.get(ConfigConstant.JDBC_DRIVER);
    }

    /**
     * 获取JDBC URL
     * @return
     */
    public static String getJdbcUrl(){
        return CONFIG_PROPS.get(ConfigConstant.JDBC_URL);
    }

    /**
     * 获取JDBC用户名
     * @return
     */
    public static String getJdbcUserName(){
        return CONFIG_PROPS.get(ConfigConstant.JDBC_USERNAME);
    }

    /**
     * 获取JDBC密码
     * @return
     */
    public static String getJdbcPassword(){
        return CONFIG_PROPS.get(ConfigConstant.JDBC_PASSWORD);
    }

    /**
     * 获取应用基础包
     * @return
     */
    public static String getAppBasePackge(){
        return CONFIG_PROPS.get(ConfigConstant.APP_BASE_PACKAGE);
    }

    /**
     * 获取JSP路径
     * @return
     */
    public static String getAppJspPath(){
        return CONFIG_PROPS.get(ConfigConstant.APP_JSP_PATH,"/WEB-INF/view/");
    }

    public static String getAssetPath(){
        return CONFIG_PROPS.get(ConfigConstant.ASSET_PATH,"/asset/");
    }




}
