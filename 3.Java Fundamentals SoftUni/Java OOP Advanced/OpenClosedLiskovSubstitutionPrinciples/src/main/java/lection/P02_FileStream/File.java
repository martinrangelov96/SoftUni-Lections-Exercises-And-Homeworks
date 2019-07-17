package lection.P02_FileStream;

public class File extends BaseSource implements Streamable{

    private String name;

    public File(int length, int bytesSent) {
        super(length, bytesSent);
    }


    public int getLength() {
        return super.getLength();
    }

    public int getBytesSent() {
    return super.getBytesSent();
    }
}
