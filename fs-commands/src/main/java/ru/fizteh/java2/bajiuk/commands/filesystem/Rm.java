package ru.fizteh.java2.bajiuk.commands.filesystem;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Rm extends FilesystemCommand {

    @PostConstruct
    public void postRm() {
        postFilesystemCommand("rm", 2, "usage: rm <path>");
    }

    @Override
    public String execute() {
        return filesystemContext.rm(arguments.get(1));
    }
}

