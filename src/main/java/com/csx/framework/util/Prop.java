package com.csx.framework.util;




import org.apache.log4j.Logger;

import java.io.*;
import java.util.Properties;



/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 配置类，用以从classPath或File加载配置文件
 * @Author: csx
 * @Date: 2017-09-20
 */
public class Prop {
    private static final Logger logger=Logger.getLogger(Prop.class);

    private Properties properties=null;

    /**
     * 配置工具类构造方法
     * @param fileName 配置文件名
     */
    public Prop(String fileName) {
        this(fileName, ConfigConstant.DEFAULT_ENCODE);
    }



    /**
     * 配置工具类构造方法
     * @param fileName 配置文件名
     * @param encode 编码
     */
    public Prop(String fileName, String encode) {
        InputStream inputStream=null;
        try {
            inputStream=getClassLoader().getResourceAsStream(fileName);
            if(inputStream==null){
                throw new IllegalArgumentException("Properties file not found in classpath: " + fileName);
            }
            properties=new Properties();
            properties.load(new InputStreamReader(inputStream,encode));
        } catch (IOException e) {
            throw new RuntimeException("Error loading properties file.", e);
        }finally {
            if(inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    logger.error(e.getMessage());
                }
            }
        }
    }

    private ClassLoader getClassLoader() {
        ClassLoader ret = Thread.currentThread().getContextClassLoader();
        return ret != null ? ret : getClass().getClassLoader();
    }


    /**
     * prop构造方法
     * @param file 配置文件对象
     * @param encode 编码
     */
    public Prop(File file,String encode){
        if(file==null){
            throw new IllegalArgumentException("File can not be null");
        }
        if(file.isFile()){
            throw new IllegalArgumentException("File not find:"+file.getName());
        }
        InputStream inputStream=null;
        try {
            inputStream = new FileInputStream(file);
            properties=new Properties();
            properties.load(new InputStreamReader(inputStream,encode));
        } catch (IOException e) {
            throw new RuntimeException("Error loading properties file.", e);
        }finally {
            if(inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    logger.error(e.getMessage());
                }
            }

        }
    }

    /**
     * @see #Prop(File,String)
     */
    public Prop(File file){
        this(file,ConfigConstant.DEFAULT_ENCODE);
    }

    public String get(String key){
        return properties.getProperty(key);
    }

    public String get(String key,String defaultValue){
        return properties.getProperty(key,defaultValue);
    }

    public Integer getInt(String key){
        return getInt(key,null);
    }
    public Integer getInt(String key,Integer defaultValue){
        String value=properties.getProperty(key);
        if(value!=null){
            return Integer.parseInt(value);
        }
        return defaultValue;
    }

    public Long getLong(String key){
        return getLong(key,null);
    }
    public Long getLong(String key,Long defaultValue){
        String value=properties.getProperty(key);
        if(value!=null){
            return Long.parseLong(value);
        }
        return  defaultValue;
    }

    public boolean getBoolean(String key){
        return getBoolean(key,null);
    }

    public boolean getBoolean(String key,Boolean defaultValue){
        String value=properties.getProperty(key);
        if(value!=null){
            value=value.toLowerCase().trim();
            if("true".equals(value)){
                return true;
            }else if("false".equals(value)){
                return false;
            }
            throw new RuntimeException("The value can not parse to Boolean : "+value);
        }
        return defaultValue;
    }

    public boolean containsKey(String key){
        return properties.containsKey(key);
    }

    public Properties getProperties(){
        return properties;
    }
}
