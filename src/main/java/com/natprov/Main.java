package com.natprov;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import joptsimple.OptionParser;
import joptsimple.OptionSet;
import joptsimple.OptionSpec;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class Main

{

    public static void main(String[] args) throws FileNotFoundException {
        String header = "";
        OptionParser parser = new OptionParser();

        OptionSpec<String> head =parser.accepts("h").withRequiredArg().ofType(String.class);
        OptionSpec<File> file =  parser.acceptsAll(Arrays.asList("f","file")).withRequiredArg().ofType(File.class);

        OptionSet options = parser.parse(args);

        if(options.has("h")){

             header = options.valueOf(head);
        }

        if(options.has("f")){

            FileProcess fileProcess = new FileProcess();
            ArrayList<String> macs = new ArrayList<String>();
            File f = options.valueOf(file);
            try {
                macs = fileProcess.process(f);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            Process process = new Process();
            process.process(macs, header);



        }

        else{

            List commandmacs = options.nonOptionArguments();

            ArrayList<String> list = new ArrayList();
            Process process = new Process();
            ArrayList<String> macs = new ArrayList<String>();
            for(Object i: commandmacs){
                String mac = (String) i;
                macs.add(mac);

            }
            if(macs.isEmpty()){
                Scanner scan = new Scanner(System.in);
                while(scan.hasNextLine()){
                    String i = scan.nextLine();
                    macs.add(i);
                }
            }
            process.process(macs, header);


        }




    }
}
