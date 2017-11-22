package com.natprov;

public class Formatter {


    public String formatter(String mac){
    String first = mac.substring(0,2);
    String second = mac.substring(2,4);
    String third = mac.substring(4,6);
    String four = mac.substring(6,8);
    String five = mac.substring(8,10);
    String six = mac.substring(10,12);

    StringBuilder s = new StringBuilder();
    String[] compenents = {first,second,third,four,five,six};
        for (String i: compenents) {
        String lower = i.toLowerCase();
        s.append(lower + ":");
    }

    String convtMac = s.toString();
    //convtMac = first + ":" + second + ":" + third + ":" + four.toLowerCase() + ":" + five + ":" + six;
        return convtMac.substring(0,convtMac.length() -1);

}
}
