package ru.fizteh.java2.bajiuk.commands.filesystem;

import ru.fizteh.java2.bajiuk.shell.ExitException;

public class Exit extends FilesystemCommand {

    public Exit(FilesystemContext context) {
        super(context, "exit", 1, "usage: exit");
    }

    @Override
    public String execute() {
        throw new ExitException();
    }
}