package ru.fizteh.java2.bajiuk.commands.filesystem;

public class Cp extends FilesystemCommand {

    public Cp(FilesystemContext context) {
        super(context, "cp", 3, "usage: cp <path> <path>");
    }

    @Override
    public String execute() {
        return filesystemContext.cp(arguments.get(1), arguments.get(2));
    }
}
