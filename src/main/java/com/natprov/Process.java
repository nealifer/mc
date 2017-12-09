package com.natprov;

import java.util.ArrayList;

public class Process {

    public void process(ArrayList<String> List, String header) {

        ArrayList<String> macs = new ArrayList();
        for (String i : List) {

            Convert con = new Convert();

            if (i.matches("(?:(?i)[a-f]|[0-9]){12}")) {
                String mac = con.standard(i);
                macs.add(mac);
            } else if (i.matches("((?:(?i)[a-f]|[0-9]){4})\\.((?:(?i)[a-f]|[0-9]){4})\\.((?:(?i)[a-f]|[0-9]){4})")) {
                String mac = con.cmts(i);

                macs.add(mac);

            } else if (i.matches("((?:(?:(?i)[a-f]|[0-9]){2}:){5}(?:(?i)[a-f]|[0-9]){2})")) {
                String mac = con.colondel(i);
                macs.add(mac);

            }
            else{
                System.out.println(i + "invalid mac");
            }





        }
        Output o = new Output();
        o.header(macs, header);
    }
}
