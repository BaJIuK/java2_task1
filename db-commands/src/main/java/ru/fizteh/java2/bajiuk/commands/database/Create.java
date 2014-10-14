package ru.fizteh.java2.bajiuk.commands.database;

import org.springframework.stereotype.Component;
import ru.fizteh.java2.bajiuk.databasecore.MySignature;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Component
public class Create extends DatabaseCommand {

    public Create() {
    }

    @PostConstruct
    private void PostConstruct() {
        commandName = "create";
        argumentNumber = 0;
        hint = "usage: create <tablename> (<type1> <type2> ... )";
    }

    private String types;

    @Override
    public String execute() {
        try {
            if (databaseContext.provider.createTable(arguments.get(1), MySignature.getTypes(types)) != null) {
                return "created";
            } else {
                error = "Table " + arguments.get(1) + " exists";
            }
        } catch (IOException e) {
            error = "Wrong type: " + e.getMessage();
        }
        return null;
    }

    @Override
    public boolean isMine(String command) {
        if (super.isMine(command)) {
            if ((command.indexOf("(") == -1) || (command.indexOf(")") == -1)) {
                error = hint;
                return false;
            }
            types = command.substring(command.indexOf("("), command.lastIndexOf(")") + 1);
            return true;
        }
        return false;
    }
}
