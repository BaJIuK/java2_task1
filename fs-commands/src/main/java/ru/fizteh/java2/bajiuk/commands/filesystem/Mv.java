package ru.fizteh.java2.bajiuk.commands.filesystem;

import javax.annotation.PostConstruct;

public class Mv extends FilesystemCommand {

    @PostConstruct
    public void Mv() {
        postFilesystemCommand("mv", 3, "usage: mv <path> <path>");
    }

    @Override
    public String execute() {
        return filesystemContext.mv(arguments.get(1), arguments.get(2));
    }
}
