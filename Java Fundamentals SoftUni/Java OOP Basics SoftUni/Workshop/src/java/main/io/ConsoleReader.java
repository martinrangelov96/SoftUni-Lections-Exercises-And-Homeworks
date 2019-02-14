package java.main.io;

import net.java.main.interfaces.InputReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.main.interfaces.InputReader;

public class ConsoleReader implements InputReader {

    private BufferedReader reader;

    public ConsoleReader(){
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public String readLine() throws IOException {
        return this.reader.readLine();
    }
}
