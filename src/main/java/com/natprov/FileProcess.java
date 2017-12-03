package com.natprov;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class FileProcess {

    public ArrayList<String> process(File file) throws FileNotFoundException {
        System.out.println(file);
        ArrayList<String> macs = new ArrayList<String>();
        Scanner sc = new Scanner(file);

        while(sc.hasNextLine()){
            String line =sc.nextLine();
            macs.add(line);
        }

        return macs;
    }

}
