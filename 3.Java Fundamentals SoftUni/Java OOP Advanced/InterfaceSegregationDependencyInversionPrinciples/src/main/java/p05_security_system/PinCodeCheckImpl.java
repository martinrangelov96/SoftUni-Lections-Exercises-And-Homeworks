package p05_security_system;

import p05_security_system.contracts.PinCodeCheck;

public class PinCodeCheckImpl extends BaseSecurityCheck implements PinCodeCheck {


    public PinCodeCheckImpl(ScannerUI scannerUI) {
        super(scannerUI);
    }

    @Override
    public boolean validateUser() {
        int pin = this.requestPinCode();
        return isValid(pin);
    }

    private boolean isValid(int pin) {
        return true;
    }

    @Override
    public int requestPinCode() {
        System.out.println("enter your pin code");
        return Integer.parseInt(super.getScannerUI().getScanner().nextLine());
    }
}
