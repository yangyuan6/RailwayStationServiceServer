package com.imudges.web.railwaystationservice.util;

/**
 * Created by yangy on 2018/3/1.
 */
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;



public class PropertiesUtils {
    private static Properties props;
    static{
        loadProps();
    }

    synchronized static private void loadProps(){

        props = new Properties();
        InputStream in = null;
        try {
            // 要加载的属性文件
            in = PropertiesUtils.class.getClassLoader().getResourceAsStream("config.properties");
            props.load(in);
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } finally {
            try {
                if(null != in) {
                    in.close();
                }
            } catch (IOException e) {

            }
        }

    }

    public static String getProperty(String key){
        if(null == props) {
            loadProps();
        }
        return props.getProperty(key);
    }

    public static String getProperty(String key, String defaultValue) {
        if(null == props) {
            loadProps();
        }
        return props.getProperty(key, defaultValue);
    }

}