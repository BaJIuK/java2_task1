package ru.fizteh.java2.bajiuk.commands.database;

import javax.annotation.PostConstruct;

public class Remove extends DatabaseCommand {
    @PostConstruct
    private void PostConstruct() {
        commandName = "remove";
        argumentNumber = 2;
        hint = "usage: remove <key>";
    }

    @Override
    public String execute() {
        if (databaseContext.table != null) {
            return "no table";
        }

        if (databaseContext.table.remove(arguments.get(1)) == null) {
            return "not found";
        } else {
            return "removed";
        }
    }
}
