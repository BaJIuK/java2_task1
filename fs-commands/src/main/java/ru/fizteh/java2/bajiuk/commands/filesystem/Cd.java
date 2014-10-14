package ru.fizteh.java2.bajiuk.commands.filesystem;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Cd extends FilesystemCommand {

    @PostConstruct
    public void postCd() {
        postFilesystemCommand("cd", 2, "usage: cd <path>");
    }

    @Override
    public String execute() {
        return filesystemContext.cd(arguments.get(1));
    }
}
