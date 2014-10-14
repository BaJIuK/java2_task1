package ru.fizteh.java2.bajiuk.shell;

public class ExitException extends RuntimeException {
    public ExitException() {
        super("Exit!");
    }
}
