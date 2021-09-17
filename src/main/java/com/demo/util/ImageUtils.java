package com.demo.util;

import java.util.ArrayList;
import java.util.List;

public class ImageUtils {

    public static List<String> StringToList(String stringList) {
        String[] springs = stringList.split(";");
        if(springs == null) {
            return null;
        }
        List<String> list = new ArrayList<>();
        for(String s: springs) {
            list.add(s);
        }
        return list;
    }

    public static String ListToString(List<String> list) {
        if(list == null || list.size() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for(String s: list) {
            sb.append(s + ";");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "123";
        List<String> list = StringToList(str);
        System.out.println(list);
        System.out.println(ListToString(list));
    }
}
