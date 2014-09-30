package ru.fizteh.java2.bajiuk.commands.database;
import com.google.common.base.Splitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.fizteh.java2.bajiuk.shell.Command;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public abstract class DatabaseCommand implements Command {
    @Autowired
    protected DatabaseContext databaseContext;
    protected int argumentNumber;
    protected String commandName;
    protected List<String> arguments = new ArrayList<String>();
    protected String error = null;
    protected String hint;

    public DatabaseCommand() {
        //nothing
    }

    public DatabaseCommand(DatabaseContext context, String name, int argNum, String help) {
        databaseContext = context;
        argumentNumber = argNum;
        commandName = name;
        hint = help;
    }

    @Override
    public boolean isMine(String command) {
        Iterable<String> ans = Splitter.on(' ').omitEmptyStrings().split(command);
        arguments.clear();
        CollectionUtils.addAll(arguments, ans.iterator());
        if (arguments.get(0).equals(commandName)) {
            if (argumentNumber != 0 && arguments.size() != argumentNumber) {
                error = "Invalid argument number.";
                return false;
            }
            return true;
        }
        return false;
    }

    @Override
    public String getError() {
        String buf = error;
        error = null;
        return buf;
    }

    @Override
    public String getHint() {
        return hint;
    }
}

