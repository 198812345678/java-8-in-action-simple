package com.will.simple.java.eight.in.action.ch3;

import java.io.*;

public class FileProcessor {

    private static String filePath = "D:\\github\\java-8-in-action-simple\\ch3.md";

    public void processFile(BufferedReaderFileProcess process) throws Exception {

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            System.out.println(process.process(reader));
        }
    }
}
