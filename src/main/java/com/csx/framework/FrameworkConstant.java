package com.csx.framework;

import com.csx.framework.helper.ConfigHelper;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2017-10-29
 */
public interface FrameworkConstant {
    String UTF_8 = "UTF-8";

    String CONFIG_PROPS = "smart.properties";
    String SQL_PROPS = "smart-sql.properties";

    String PLUGIN_PACKAGE = "org.smart4j.plugin";

    String JSP_PATH = ConfigHelper.getAppJspPath();
//    String WWW_PATH = ConfigHelper.get
}
