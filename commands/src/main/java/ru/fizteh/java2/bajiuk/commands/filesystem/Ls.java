package ru.fizteh.java2.bajiuk.commands.filesystem;

public class Ls extends FilesystemCommand {

    public Ls(FilesystemContext context) {
        super(context, "ls", 1, "usage: ls");
    }

    @Override
    public String execute() {
        return filesystemContext.ls();
    }
}
