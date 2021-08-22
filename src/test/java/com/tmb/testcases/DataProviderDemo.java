package com.tmb.testcases;

import lombok.Data;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataProviderDemo {

    @Test(dataProvider = "getData")
    public void dataProviderTest(Map<String,String> map){
        System.out.println(map.get("username"));
        System.out.println(map.get("password"));
        System.out.println(map.get("address"));
    }

    @DataProvider
    public Object[] getData(){ //Object[][] -> 1st dim - number of time  -->2 * 1
        //2 dim --> number of params to test method
        Map<String,String> map = new HashMap<>();
        map.put("username","abcd");
        map.put("password","12345");
        map.put("address","chennai");
        map.put("phone",null);

        Map<String,String> map1 = new HashMap<>();
        map1.put("username","abcdefgh");
        map1.put("password","123455676");
        map1.put("address","Mumbai");

        List<Map<String,String>> list = new ArrayList<>();
        list.add(map);
        list.add(map1);

        return list.toArray();
    }

    @DataProvider
    public String[][] getData1(){
        return new String[][]{
                {"abcd","1234","sdfsfd","93854"},
                {"efgh","5678","dfgdgds","34535"},
                {"efgh","56789","dfgsdfd","sjkfvns"}
        };
      //  [] --> how many times you want to run the test   -->3
     //   [] -->how many parameter you want to feed to your test       --->4
    }


}
