package com.csx.framework.util;

import com.csx.framework.FrameworkConstant;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2017-10-29
 */
public class CodecUtils {
    private static final Logger LOGGER= LoggerFactory.getLogger(CodecUtils.class);

    /**
     * 将URL编码
     * @param str
     * @return
     */
    public static String encodeURL(String str){
        String target;
        try {
            target = URLEncoder.encode(str,FrameworkConstant.UTF_8);
        } catch (Exception e) {
            LOGGER.error("编码出错!",e);
            throw new RuntimeException(e);
        }
        return target;
    }

    /**
     * 将URL解码
     * @param str
     * @return
     */
    public static String decodeURL(String str){
        String target;
        try {
            target = URLEncoder.encode(str,FrameworkConstant.UTF_8);
        } catch (Exception e) {
            LOGGER.error("解码出错!",e);
            throw new RuntimeException(e);
        }
        return target;
    }

    /**
     * 将字符串BASE64编码
     * @param str
     * @return
     */
    public static String encodeBASE64(String str){
        String target;
        try {
            target = Base64.encodeBase64URLSafeString(str.getBytes(FrameworkConstant.UTF_8));
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("编码错误!",e);
            throw new RuntimeException(e);
        }
        return target;
    }

    /**
     * 将字符串BASE64解码
     * @param str
     * @return
     */
    public static String decodeBASE64(String str){
        String target;
        try {
            target = new String(Base64.decodeBase64(str),FrameworkConstant.UTF_8);
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("解码错误!",e);
            throw new RuntimeException(e);
        }
        return target;
    }

    /**
     * 将字符串MD5加密
     * @param str
     * @return
     */
    public static String encryptMD5(String str){
        return DigestUtils.md5Hex(str);
    }

    /**
     * 将字符串SHA加密
     * @param str
     * @return
     */
    public static String encrySHA(String str){
        return DigestUtils.sha1Hex(str);
    }

    /**
     * 创建随机数
     * @param count
     * @return
     */
    public static String createRandom(int count){
        return RandomStringUtils.randomNumeric(count);
    }

    /**
     * 创建UUID（32位）
     * @return
     */
    public static String createUUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }




}
