package com.natprov;

import java.util.ArrayList;

public class Output {

    public void colonDivided(ArrayList<String> macs, String header){


        for (String i : macs) {
            System.out.println(i);

        }

    }

    public void header(ArrayList<String> macs, String header){

        for (String i : macs) {
            System.out.println(header + i);

        }
    }
}
