package p05_security_system;

import p05_security_system.contracts.KeyCardCheck;

public class KeyCardCheckImpl extends BaseSecurityCheck implements KeyCardCheck {

    public KeyCardCheckImpl(ScannerUI scannerUI) {
        super(scannerUI);
    }

    @Override
    public boolean validateUser() {
        String code = this.requestKeyCard();
        return isValid(code);
    }

    @Override
    public String requestKeyCard() {
        System.out.println("slide your key card");
        return super.getScannerUI().getScanner().nextLine();
    }

    private boolean isValid(String code) {
        return true;
    }
}
