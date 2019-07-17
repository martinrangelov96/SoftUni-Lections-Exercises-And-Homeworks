package logger.io.impl;

import logger.io.interfaces.Reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader implements Reader {
    BufferedReader reader;

    public ConsoleReader() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public String readLine() {
        String line = null;

        try {
            line = this.reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return line;
    }
}
