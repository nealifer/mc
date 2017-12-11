package com.natprov;

import java.util.ArrayList;

public class Output {

    public void standard(ArrayList<String> macs){

        for (String i : macs) {
            System.out.println(i);

        }

    }

    public void header(ArrayList<String> macs){

        for (String i : macs) {
            System.out.println("1,6," + i);

        }
    }
}
