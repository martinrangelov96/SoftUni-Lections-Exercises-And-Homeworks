package blobs_previous_exam;

import blobs_previous_exam.core.Engine;
import blobs_previous_exam.interfaces.*;
import blobs_previous_exam.interfaces.Runnable;
import blobs_previous_exam.io.ConsoleInputReader;
import blobs_previous_exam.io.ConsoleOutputWriter;
import blobs_previous_exam.models.Blob;
import blobs_previous_exam.models.attacks.PutridFart;
import blobs_previous_exam.models.behaviors.Inflated;
import blobs_previous_exam.observers.Subject;
import blobs_previous_exam.repositories.BlobRepository;
import blobs_previous_exam.utility.MutateBoolean;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {

        Reader reader = new ConsoleInputReader();
        Writer writer = new ConsoleOutputWriter();
        Repository<Blob> blobRepository = new BlobRepository();
        Subject subject = new Subject();
        MutateBoolean mutateBoolean = new MutateBoolean(false);

        Runnable engine = new Engine(reader, writer, blobRepository, subject, mutateBoolean);

        engine.run();

    }
}
