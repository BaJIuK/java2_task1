package ru.fizteh.java2.bajiuk.commands.filesystem;

import com.google.common.base.Splitter;
import ru.fizteh.java2.bajiuk.shell.Command;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public abstract class FilesystemCommand implements Command {

    protected final FilesystemContext filesystemContext;
    private final int argumentNumber;
    private final String commandName;
    private final String hint;
    List<String> arguments = new ArrayList<String>();
    private String error = null;

    public FilesystemCommand(FilesystemContext context, String name, int argNum, String help) {
        filesystemContext = context;
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
                error = hint;
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
