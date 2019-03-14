package lection.P02_FileStream;

public abstract class BaseSource {

    private int length;
    private int bytesSent;

    public BaseSource(int length, int bytesSent) {
        this.length = length;
        this.bytesSent = bytesSent;
    }

    public int getLength() {
        return this.length;
    }

    public int getBytesSent() {
        return this.bytesSent;
    }
}
