package com.example.dictionarywebdb.dictionary.utils;

import java.io.*;

public class Helper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readMessage() throws IOException {
        return reader.readLine();
    }


}
