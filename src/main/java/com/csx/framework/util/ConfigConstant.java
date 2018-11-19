package com.csx.framework.util;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 提供相关配置常量
 * @Author: csx
 * @Date: 2017-09-20
 */
public interface ConfigConstant {
    String CONFIG_FILE="smart.properties";

    String DEFAULT_ENCODE="UTF-8";//默认编码

    String JDBC_DRIVER="smart.framework.jdbc.driver";
    String JDBC_URL="smart.framework.jdbc.url";
    String JDBC_USERNAME="smart.framework.jdbc.username";
    String JDBC_PASSWORD="smart.framework.jdbc.password";
    String APP_BASE_PACKAGE="smart.framework.app.base_package";
    String APP_JSP_PATH="smart.framework.app.jsp_path";
    String ASSET_PATH="smart.framework.app.asset_path";
}
