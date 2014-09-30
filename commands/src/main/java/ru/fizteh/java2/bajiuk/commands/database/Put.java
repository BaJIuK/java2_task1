package ru.fizteh.java2.bajiuk.commands.database;

import org.springframework.stereotype.Component;
import ru.fizteh.java2.bajiuk.databasecore.DataBase;
import ru.fizteh.java2.bajiuk.databasecore.Storeable;

import javax.annotation.PostConstruct;
import java.text.ParseException;

@Component
public class Put extends DatabaseCommand {

    @PostConstruct
    private void PostConstruct() {
        commandName = "put";
        argumentNumber = 0;
        hint = "usage: put <key> <value>";
    }

    private String jsonStr;

    @Override
    public String execute() {
        if (databaseContext.table == null) {
            return "no table";
        }
        try {
            Storeable storeable = ((DataBase) databaseContext.table).putStoreable(arguments.get(1), jsonStr);
            if (storeable == null) {
                return "new";
            } else {
                return "overwrote \n" + databaseContext.provider.serialize(databaseContext.table, storeable);
            }
        } catch (ParseException e) {
            return "Wrong type " + e.getMessage();
        }
    }

    @Override
    public boolean isMine(String command) {
        if (super.isMine(command)) {
            if ((command.indexOf("[") == -1) || (command.indexOf("]") == -1)) {
                error = hint;
                return false;
            }
            jsonStr = command.substring(command.indexOf("["), command.lastIndexOf("]") + 1);
            return true;
        }
        return false;
    }
}
