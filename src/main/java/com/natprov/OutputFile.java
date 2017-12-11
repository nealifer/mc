package com.natprov;

import java.io.*;
import java.util.ArrayList;

public class OutputFile {
    public void header(ArrayList<String> macs, String fileName) throws IOException {

      BufferedWriter out = null;
       FileWriter fileWriter = new FileWriter(fileName, false);
       out = new BufferedWriter(fileWriter);

       for(String i: macs){
           out.write("1,6," + i + "\n");
       }

        out.close();
    }
    public void standard(ArrayList<String> macs, String fileName) throws IOException {

        BufferedWriter out = null;
        FileWriter fileWriter = new FileWriter(fileName, false);
        out = new BufferedWriter(fileWriter);

        for(String i: macs){
            out.write( i + "\n");
        }

        out.close();
    }
    public void inValid(ArrayList<String> macs, String fileName) throws IOException {

        BufferedWriter out = null;
        FileWriter fileWriter = new FileWriter(fileName, false);
        out = new BufferedWriter(fileWriter);

        for(String i: macs){
            out.write( i + "\n");
        }

        out.close();
    }



}
