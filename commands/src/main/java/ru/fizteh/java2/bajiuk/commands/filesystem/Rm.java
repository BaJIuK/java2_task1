package ru.fizteh.java2.bajiuk.commands.filesystem;

public class Rm extends FilesystemCommand {

    public Rm(FilesystemContext context) {
        super(context, "rm", 2, "usage: rm <path>");
    }

    @Override
    public String execute() {
        return filesystemContext.rm(arguments.get(1));
    }
}

