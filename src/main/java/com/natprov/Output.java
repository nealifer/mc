package com.natprov;

import java.util.ArrayList;

public class Output {

    public void colonDivided(ArrayList<String> macs){


        for (String i : macs) {
            System.out.println(i);

        }

    }

    public void header(ArrayList<String> macs){
        String header = "1,6,";
        for (String i : macs) {
            System.out.println(header + i);

        }
    }
}
