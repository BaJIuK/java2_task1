package ru.fizteh.java2.bajiuk.commands.filesystem;

public class Mv extends FilesystemCommand {

    public Mv(FilesystemContext context) {
        super(context, "mv", 3, "usage: mv <path> <path>");
    }

    @Override
    public String execute() {
        return filesystemContext.mv(arguments.get(1), arguments.get(2));
    }
}
