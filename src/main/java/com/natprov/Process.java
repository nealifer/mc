package com.natprov;

import java.util.ArrayList;

public class Process {

    public void process(ArrayList<String> List, String header) {

        ArrayList<String> macs = new ArrayList();
        for (String i : List) {

            Convert con = new Convert();
            //String mac = con.standard(i);

            if(i.matches("(?:\\d|\\w){12}")){
                String mac =con.standard(i);
                macs.add(mac);
            }
            else if(i.matches("((?:\\d|\\w){4})\\.((?:\\d|\\w){4})\\.((?:\\d|\\w){4})")) {
                String mac = con.cmts(i);
                macs.add(mac);
            }
        }

        Output o = new Output();
        o.header(macs, header);


    }
}
