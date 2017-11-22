package com.natprov;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Convert {

    public String standard(String mac){

        Formatter format = new Formatter();
        return format.formatter(mac);
    }

    public String cmts(String mac){
        Pattern cmtsMac = Pattern.compile("((?:\\d|\\w){4})\\.((?:\\d|\\w){4})\\.((?:\\d|\\w){4})");
        Matcher matcher = cmtsMac.matcher(mac);
        String first = null;
        String second = null;
        String third = null;


           while(matcher.find()) {
               first = matcher.group(1);
               second = matcher.group(2);
               third = matcher.group(3);
           }

        String combined = first + second + third;
        Formatter formatter = new Formatter();
        return formatter.formatter(combined);

    }



}