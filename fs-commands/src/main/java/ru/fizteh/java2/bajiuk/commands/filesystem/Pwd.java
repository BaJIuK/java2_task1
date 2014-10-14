package ru.fizteh.java2.bajiuk.commands.filesystem;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Pwd extends FilesystemCommand {

    @PostConstruct
    public void postPwd() {
        postFilesystemCommand("pwd", 1, "usage: pwd");
    }

    @Override
    public String execute() {
        return filesystemContext.pwd();
    }
}
