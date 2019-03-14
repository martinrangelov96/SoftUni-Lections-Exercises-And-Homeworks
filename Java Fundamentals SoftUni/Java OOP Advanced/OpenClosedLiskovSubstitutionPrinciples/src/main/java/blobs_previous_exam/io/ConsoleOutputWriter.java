package blobs_previous_exam.io;

import blobs_previous_exam.interfaces.Writer;

public class ConsoleOutputWriter implements Writer {

    @Override
    public void writeLine(String output){
        System.out.println(output);
    }
}
