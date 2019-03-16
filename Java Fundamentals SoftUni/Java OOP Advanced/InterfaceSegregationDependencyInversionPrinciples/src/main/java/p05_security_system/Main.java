package p05_security_system;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        ScannerUI scannerUI = new ScannerUI(new Scanner(System.in));

        KeyCardCheckImpl keyCardCheck = new KeyCardCheckImpl(scannerUI);
        PinCodeCheckImpl pinCodeCheck = new PinCodeCheckImpl(scannerUI);

        SecurityManager manager = new SecurityManager(keyCardCheck, pinCodeCheck);
        manager.check();
    }
}
