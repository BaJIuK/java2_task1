package ru.fizteh.java2.bajiuk.shell;

public class ExitException extends Error {
    public ExitException() {
        super("Exit!");
    }
}
