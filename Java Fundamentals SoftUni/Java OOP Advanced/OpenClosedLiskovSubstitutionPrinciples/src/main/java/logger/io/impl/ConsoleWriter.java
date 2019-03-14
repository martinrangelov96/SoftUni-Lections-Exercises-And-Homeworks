package logger.io.impl;

import logger.io.interfaces.Writer;

public class ConsoleWriter implements Writer {
    @Override
    public void write(String line) {
        System.out.print(line);
    }

    @Override
    public void writeLine(String line) {
        System.out.println(line);
    }
}
