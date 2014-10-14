package ru.fizteh.java2.bajiuk.commands.database;

import org.springframework.stereotype.Component;
import ru.fizteh.java2.bajiuk.databasecore.Table;

import javax.annotation.PostConstruct;

@Component
public class Use extends DatabaseCommand {

    @PostConstruct
    private void PostConstruct() {
        commandName = "use";
        argumentNumber = 2;
        hint = "usage: use <table name>";
    }

    @Override
    public String execute() {
        if (databaseContext.table != null && databaseContext.getChanges() != 0) {
            return Integer.toString(databaseContext.getChanges()) + " unsaved changes";
        }

        Table old = databaseContext.table;
        databaseContext.table = databaseContext.provider.getTable(arguments.get(1));
        if (databaseContext.table != null) {
            return "using " + arguments.get(1);
        } else {
            databaseContext.table = old;
            return arguments.get(1) + "not exists";
        }
    }
}
