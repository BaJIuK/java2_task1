package ru.fizteh.java2.bajiuk.commands.filesystem;

import org.springframework.stereotype.Component;
import ru.fizteh.java2.bajiuk.shell.ExitException;

import javax.annotation.PostConstruct;

@Component
public class Exit extends FilesystemCommand {

    @PostConstruct
    public void Exit() {
        postFilesystemCommand("exit", 1, "usage: exit");
    }

    @Override
    public String execute() {
        throw new ExitException();
    }
}