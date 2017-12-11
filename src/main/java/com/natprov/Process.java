package com.natprov;



import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Process {

    public void process(ArrayList<String> List, boolean header, boolean outputFile) {

        ArrayList<String> macs = new ArrayList();
        ArrayList<String> invalid = new ArrayList<String>();
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
               invalid.add(i);
            }


        }


        if(outputFile) {
            System.out.print("Please enter name of output file?");
            Scanner scanner = new Scanner(System.in);
            String name = scanner.next();

            OutputFile o = new OutputFile();
            try {
                if(header) {
                    o.header(macs, name);
                }
                else{
                    o.standard(macs, name);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            Output o = new Output();
            if(header){

                o.header(macs);
            }
        else{
                o.standard(macs);
            }
        }

    if(!invalid.isEmpty()){
            Scanner scanner = new Scanner(System.in);
            int invalidAmount = invalid.size();
            System.out.print("There is " + invalidAmount + " invalid mac." + " Do you want them in an ouput file yes/no?");
            String answer = scanner.next();
            if(answer.equals("yes") || answer.equals("y")){
                System.out.print("Name of output file ");
                String filename = scanner.next();
                OutputFile invalidOut = new OutputFile();
                try {
                    invalidOut.inValid(invalid, filename);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


    }

    }
}
