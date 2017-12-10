package com.natprov;

import java.io.*;
import java.util.ArrayList;

public class OutputFile {
    public void header(ArrayList<String> macs, String header, String fileName) throws IOException {

      BufferedWriter out = null;
       FileWriter fileWriter = new FileWriter(fileName, false);
       out = new BufferedWriter(fileWriter);

       for(String i: macs){
           out.write(header + i + "\n");
       }

    out.close();
    }


}
