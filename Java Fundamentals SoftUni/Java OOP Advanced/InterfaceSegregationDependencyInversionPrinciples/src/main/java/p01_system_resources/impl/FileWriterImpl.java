package p01_system_resources.impl;

import p01_system_resources.interfaces.Writer;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterImpl implements Writer {
    @Override
    public void writeLine(String line) {
        try {
            FileWriter writer = new FileWriter("result.txt");
            writer.write(line);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
