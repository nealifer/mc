package com.natprov;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Process {

    public void process(ArrayList<String> List, String header, boolean outputFile) {

        ArrayList<String> macs = new ArrayList();
        for (String i : List) {

            Convert con = new Convert();

            if (i.matches("(?:(?i)[a-f]|[0-9]){12}")) {
                String mac = con.standard(i);
                macs.add(mac);
            } else if (i.matches("((?:(?i)[a-f]|[0-9]){4})\\.((?:(?i)[a-f]|[0-9]){4})\\.((?:(?i)[a-f]|[0-9]){4})")) {
                String mac = con.cmts(i);

                macs.add(mac);

            } else if (i.matches("((?:(?:(?i)[a-f]|[0-9]){2}(?:-|\\.|:)){5}(?:(?i)[a-f]|[0-9]){2})")) {
                String mac = con.colondel(i);
                macs.add(mac);


            }
            else{
                System.out.println(i + "invalid mac");
            }


        }
        if(outputFile) {
            System.out.println("Please enter name of output file?");
            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();

            OutputFile o = new OutputFile();
            try {
                o.header(macs, header,name);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            Output o = new Output();
            o.header(macs, header);
        }
    }
}
