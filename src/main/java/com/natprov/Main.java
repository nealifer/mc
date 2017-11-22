package com.natprov;

import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList();
        Pattern p = Pattern.compile("[a-e]|[0-9]");
        Process process = new Process();

        for (String i : args) {
            boolean valid = true;
            for (char j : i.toCharArray()) {
                char lowerj = Character.toLowerCase(j);
                if (Character.toString(lowerj).matches("[a-f]|[0-9]|\\.")) {

                } else {
                    valid = false;
                }
            }
            if (valid) {
                list.add(i);
            } else {
                System.out.println(i + "invalid mac");
            }



        }

        process.process(list);
    }
}
