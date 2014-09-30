package ru.fizteh.java2.bajiuk.shell;

public interface Command {
    public boolean isMine(String command);
    public String getError();
    public String execute();
    public String getHint();
}
