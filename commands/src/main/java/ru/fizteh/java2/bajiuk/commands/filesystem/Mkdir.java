package ru.fizteh.java2.bajiuk.commands.filesystem;

public class Mkdir extends FilesystemCommand {

    public Mkdir(FilesystemContext context) {
        super(context, "mkdir", 2, "usage: mkdir <dirname>");
    }

    @Override
    public String execute() {
        return filesystemContext.makeDir(arguments.get(1));
    }
}
