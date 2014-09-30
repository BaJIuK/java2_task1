package ru.fizteh.java2.bajiuk.commands.database;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Rollback extends DatabaseCommand {

    @PostConstruct
    private void PostConstruct() {
        commandName = "rollback";
        argumentNumber = 1;
        hint = "usage: rollback";
    }

    @Override
    public String execute() {
        if (databaseContext.table != null) {
            return Integer.toString(databaseContext.table.rollback());
        } else {
            return "no table";
        }
    }
}
