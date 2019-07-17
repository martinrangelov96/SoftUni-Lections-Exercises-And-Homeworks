package logger;

import logger.core.Engine;
import logger.io.impl.ConsoleReader;
import logger.io.impl.ConsoleWriter;
import logger.io.interfaces.Reader;
import logger.io.interfaces.Writer;

public class Main {
    public static void main(String[] args) {

        Writer writer = new ConsoleWriter();
        Reader reader = new ConsoleReader();

        Engine engine = new Engine(writer, reader);
        engine.run();
    }
}
