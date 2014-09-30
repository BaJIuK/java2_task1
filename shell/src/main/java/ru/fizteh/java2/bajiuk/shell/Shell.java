package ru.fizteh.java2.bajiuk.shell;

import java.io.InputStream;
import java.io.PrintStream;

public interface Shell {
    public void addCommand(Command e);
    public void execute();
    public void setInput(InputStream input);
    public void setOutput(PrintStream output);
}
