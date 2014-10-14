package ru.fizteh.java2.bajiuk.commands.filesystem;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Ls extends FilesystemCommand {

    @PostConstruct
    public void Ls() {
        postFilesystemCommand("ls", 1, "usage: ls");
    }

    @Override
    public String execute() {
        return filesystemContext.ls();
    }
}
