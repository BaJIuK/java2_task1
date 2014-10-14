package ru.fizteh.java2.bajiuk.commands.database;

import org.springframework.stereotype.Component;
import ru.fizteh.java2.bajiuk.databasecore.Storeable;

import javax.annotation.PostConstruct;

@Component
public class Get extends DatabaseCommand {

    @PostConstruct
    private void PostConstruct() {
        commandName = "get";
        argumentNumber = 2;
        hint = "usage: get <key>";
    }

    @Override
    public String execute() {
        if (databaseContext.table == null) {
            return "No table selected.";
        }

        Storeable storeable = databaseContext.table.get(arguments.get(1));

        if (storeable == null) {
            return "not found";
        } else {
            return "found \n" + databaseContext.provider.serialize(databaseContext.table, storeable);
        }
    }
}
