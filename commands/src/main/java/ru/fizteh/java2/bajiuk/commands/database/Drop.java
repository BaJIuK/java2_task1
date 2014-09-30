package ru.fizteh.java2.bajiuk.commands.database;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Component
public class Drop extends DatabaseCommand {

    @PostConstruct
    private void PostConstruct() {
        commandName = "drop";
        argumentNumber = 2;
        hint = "usage: drop <table name>";
    }

    @Override
    public String execute() {
        try {
            if ((databaseContext.table != null) && databaseContext.table.getName().equals(arguments.get(1))) {
               databaseContext.table = null;
            }
            databaseContext.provider.removeTable(arguments.get(1));
            return "dropped";
        } catch (IllegalStateException e) {
            return arguments.get(1) + " not exists";
        } catch (IOException e) {
            return e.getMessage();
        }
    }
}
