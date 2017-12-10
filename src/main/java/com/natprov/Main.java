package com.natprov;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import joptsimple.AbstractOptionSpec;
import joptsimple.OptionParser;
import joptsimple.OptionSet;
import joptsimple.OptionSpec;

import static java.lang.System.exit;

import java.util.Arrays;

/**
 * Hello world!
 *
 */

public class Main

{

    public static void main(String[] args) throws IOException {
        String header = "";
        boolean output = false;
        OptionParser parser = new OptionParser();


        OptionSpec<String> head =parser.accepts("h","header, example 1,6,").withOptionalArg().defaultsTo("1,6,").ofType(String.class);
        OptionSpec<File> file =  parser.acceptsAll(Arrays.asList("f","file"),"File name").withRequiredArg().ofType(File.class);
        parser.accepts("o","ouput file");
        parser.acceptsAll(Arrays.asList( "v","help"), "help screjaven").forHelp();

        OptionSet options = parser.parse(args);
        if(options.has("help")){

            parser.printHelpOn(System.out);
            exit('1');

        }

        if(options.has("h")){
            header = options.valueOf(head);
        }

        if(options.has("o")){
            output = true;
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
            process.process(macs, header, output);

        }

        else{

            List commandmacs = options.nonOptionArguments();

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
            process.process(macs, header, output);


        }




    }
}
