package ru.fizteh.java2.bajiuk.commands.filesystem;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Cp extends FilesystemCommand {

    @PostConstruct
    public void Cp() {
        postFilesystemCommand("cp", 3, "usage: cp <path> <path>");
    }

    @Override
    public String execute() {
        return filesystemContext.cp(arguments.get(1), arguments.get(2));
    }
}
