package com.natprov;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Convert {
    Formatter formatter = new Formatter();
    public String standard(String mac){


        return formatter.formatter(mac);
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

        return formatter.formatter(combined);

    }

    public String colondel(String mac){
        String parts[] = mac.split(":|-|\\.");
        String combined = parts[0] + parts[1] + parts[2] + parts[3] + parts[4] + parts[5];


       return formatter.formatter(combined);

    }



}