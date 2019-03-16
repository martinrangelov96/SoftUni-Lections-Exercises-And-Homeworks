package p05_security_system;

import p05_security_system.contracts.SecurityCheck;

public abstract class BaseSecurityCheck implements SecurityCheck {

    private ScannerUI scannerUI;

    public BaseSecurityCheck(ScannerUI scannerUI) {
        this.scannerUI = scannerUI;
    }

    public ScannerUI getScannerUI() {
        return this.scannerUI;
    }
}
