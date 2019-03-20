package lection.interfaces;

import lection.enums.LogType;

public interface Handler {

    void handle(LogType logType, String message);
    void setSuccessor(Handler handler);
}
