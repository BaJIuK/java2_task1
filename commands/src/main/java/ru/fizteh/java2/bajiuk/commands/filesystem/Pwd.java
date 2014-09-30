package ru.fizteh.java2.bajiuk.commands.filesystem;

public class Pwd extends FilesystemCommand {

    public Pwd(FilesystemContext context) {
        super(context, "pwd", 1, "usage: pwd");
    }

    @Override
    public String execute() {
        return filesystemContext.pwd();
    }
}
