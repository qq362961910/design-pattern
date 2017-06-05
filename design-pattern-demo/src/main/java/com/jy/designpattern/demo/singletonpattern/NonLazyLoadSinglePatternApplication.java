package com.jy.designpattern.demo.singletonpattern;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * 饿汉式应用
 */
public class NonLazyLoadSinglePatternApplication {
    public static void main(String[] args) {
        AppConfig config = AppConfig.getInstance();
        String result = config.getConfigItem("parameterA", "a-default");
        System.out.println(result);
        result = config.getConfigItem("parameterA", "a-default");
        System.out.println(result);
    }
}

/**
 * 单例类
 * */
class AppConfig {

    //静态变量缓存单例
    private static final AppConfig config = new AppConfig();

    /**
     * 配置文件路径
     * */
    private static final String PROPERTY_FILE_PATH = "parameter.properties";

    /**
     * 成员变量File
     * */
    private File propertiesFile;

    /**
     * 文件最后修改日期
     * */
    private long propertiesFileLastModifiedTime = 0;

    /**
     * 文件所对应的属性对象变量
     * */
    private Properties properties = new Properties();

    //私有化构造方法
    private AppConfig() {
        //AppConfig.class.getResource("").getPath()获取当前类路径
        propertiesFile = new File(AppConfig.class.getResource("").getPath() + PROPERTY_FILE_PATH);
    }
    //静态公开单例方法
    public static AppConfig getInstance() {
        return config;
    }
    public final String getConfigItem(String name, String defaultValue) {
        //检查文件更新
        checkAndReadConfig();
        return properties.containsKey(name) ? properties.getProperty(name) : defaultValue;
    }

    //读取配置文件
    private void checkAndReadConfig() {
        long newTime = propertiesFile.lastModified();
        if (newTime == 0) {
            if (propertiesFileLastModifiedTime == 0) {
                System.err.println(PROPERTY_FILE_PATH + " does not exist!");
            }
            else {
                System.err.println(PROPERTY_FILE_PATH + " was deleted!");
            }
        }
        else {
            if (newTime != propertiesFileLastModifiedTime) {
                properties.clear();
                FileInputStream fis = null;
                try {
                    fis = new FileInputStream(propertiesFile);
                    properties.load(fis);
                    propertiesFileLastModifiedTime = newTime;
                    System.out.println("file: " + PROPERTY_FILE_PATH +" loaded");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}