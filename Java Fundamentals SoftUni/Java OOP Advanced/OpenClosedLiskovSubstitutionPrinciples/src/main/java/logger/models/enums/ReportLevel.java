package logger.models.enums;

public enum ReportLevel {
    INFO, WARNING, ERROR, CRITICAL, FATAL;

    @Override
    public String toString() {
        return this.name();
    }
}
