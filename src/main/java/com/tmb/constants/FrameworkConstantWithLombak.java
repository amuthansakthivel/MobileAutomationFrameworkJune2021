package com.tmb.constants;

import lombok.Getter;

import java.util.Objects;

@Getter
public class FrameworkConstantWithLombak {
    //to call these non static methods, i need to create a new object everytime which is see as a overload

    //singleton

    private static FrameworkConstantWithLombak frameworkConstantWithLombak ;

    public static synchronized FrameworkConstantWithLombak getInstance(){
        if(Objects.isNull(frameworkConstantWithLombak)){
            frameworkConstantWithLombak = new FrameworkConstantWithLombak();
        }
        return frameworkConstantWithLombak;
    }

    private  final String resourcepath = System.getProperty("user.dir") + "/src/test/resources";
    private  final String apkfilepath = resourcepath+"/apkfiles/ApiDemos-debug.apk";
    private  final String configfilepath = resourcepath+"/config/config.properties";

}
