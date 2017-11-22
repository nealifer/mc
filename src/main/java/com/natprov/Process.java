package com.natprov;

import java.util.ArrayList;

public class Process {

    public void process(ArrayList<String> List) {
        ArrayList<String> macs = new ArrayList();
        for (String i : List) {

            Convert con = new Convert();
            String mac = con.standard(i);
            macs.add(mac);

        }

        for (String i : macs) {
            System.out.println(i);

        }
    }
}
