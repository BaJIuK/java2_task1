package ru.fizteh.java2.bajiuk.commands.database;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Size extends DatabaseCommand {

    @PostConstruct
    private void PostConstruct() {
        commandName = "size";
        argumentNumber = 1;
        hint = "usage: size";
    }

    @Override
    public String execute() {
        if (databaseContext.table != null) {
            return Integer.toString(databaseContext.table.size());
        } else {
            return "no table";
        }
    }
}
