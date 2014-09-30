package ru.fizteh.java2.bajiuk.commands.database;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Component
public class Commit extends DatabaseCommand {

    @PostConstruct
    private void PostConstruct() {
        commandName = "commit";
        argumentNumber = 1;
        hint = "usage: commit";
    }

    @Override
    public String execute() {
        try {
            if (databaseContext.table != null) {
                return new Integer(databaseContext.table.commit()).toString();
            } else {
                return "No table selected.";
            }
        } catch (IOException e) {
            return e.getMessage();
        }
    }
}
