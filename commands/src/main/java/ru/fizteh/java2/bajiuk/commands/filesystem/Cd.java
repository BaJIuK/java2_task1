package ru.fizteh.java2.bajiuk.commands.filesystem;

public class Cd extends FilesystemCommand {

    public Cd(FilesystemContext context) {
        super(context, "cd", 2, "usage: cd <path>");
    }

    @Override
    public String execute() {
        return filesystemContext.cd(arguments.get(1));
    }
}
