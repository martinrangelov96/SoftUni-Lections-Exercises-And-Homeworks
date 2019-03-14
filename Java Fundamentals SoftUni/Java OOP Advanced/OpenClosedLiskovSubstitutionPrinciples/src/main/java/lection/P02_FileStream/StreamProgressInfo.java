package lection.P02_FileStream;

public class StreamProgressInfo {
    private Streamable source;

    public StreamProgressInfo(Streamable source) {
        this.source = source;
    }

    public int calculateCurrentPercent() {
        return (this.source.getBytesSent() * 100) / this.source.getLength();
    }
}
