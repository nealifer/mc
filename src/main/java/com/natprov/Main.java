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
        for (String i : args) {
            boolean valid = true;
            for (char j : i.toCharArray()) {
                char lowerj = Character.toLowerCase(j);
                if (Character.toString(lowerj).matches("[a-e]|[0-9]")) {

                } else {
                    valid = false;
                }
            }
            if (valid) {
                list.add(i);
            } else {
                System.out.println(i + "invalid mac");
            }
            Process process = new Process();
            process.process(list);

        }
    }
}
