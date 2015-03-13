package com.mycompany.iamcoacher.guessnumber;

import java.io.PrintStream;

/**
 * Created by wfsovereign on 15-3-13.
 */
public class GameProcess {
    private PrintStream out;

    public GameProcess(PrintStream out) {
        this.out = out;
    }

    public void start() {
        out.println("welcome!");
        out.println("Please input your number(6): ");
    }
}
