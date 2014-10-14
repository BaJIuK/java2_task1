package ru.fizteh.java2.bajiuk.commands.filesystem;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Mkdir extends FilesystemCommand {

    @PostConstruct
    public void postMkdir() {
        postFilesystemCommand("mkdir", 2, "usage: mkdir <dirname>");
    }

    @Override
    public String execute() {
        return filesystemContext.makeDir(arguments.get(1));
    }
}
