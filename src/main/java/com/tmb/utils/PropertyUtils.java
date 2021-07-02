package com.tmb.utils;

import com.tmb.constants.FrameworkConstants;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyUtils {

    private static final Properties properties = new Properties();
    private static Map<String,String> MAP =  new HashMap<>();

    //try,catch finally
    //method -->readPropandLoadinmap
    //invalid exception is displayed to users

    static{
        try (FileInputStream fileInputStream =
                     new FileInputStream(FrameworkConstants.getConfigFilePath())){

            properties.load(fileInputStream);
            for (Map.Entry<Object, Object> entry : properties.entrySet()) {
                String key = String.valueOf(entry.getKey());
                String value = String.valueOf(entry.getValue());
                MAP.put(key,value);
            }
        }
        catch(IOException e){
            e.printStackTrace();
            System.exit(0);
        }
    }

    public static String getValue(String key){
        return MAP.get(key);
    }


}
