package ru.fizteh.java2.bajiuk.shell;

import com.google.common.base.Splitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

@Component
public class MainShell implements Shell {
    List<Command> commands;
    InputStream input;
    PrintWriter output;

    @Autowired
    public void setCommands(List<Command> newCommands) {
        if (newCommands == null) {
            return;
        }
        commands.addAll(newCommands);
    }

    public MainShell() {
        commands = new ArrayList<>();
    }

    public void runCommand(String command) {
        for (Command x : commands) {
            if (x.isMine(command)) {
                String answer = x.execute();
                if (answer != null) {
                    output.println(answer);
                    output.flush();
                } else {
                    String error = x.getError();
                    if (error != null) {
                        output.println(error);
                        output.flush();
                    }
                }
                return;
            }

            String error = x.getError();
            if (error != null) {
                output.println(error);
                output.flush();
                return;
            }
        }
        output.println("illegal command");
        output.flush();
    }

    @Override
    public void addCommand(Command e) {
        commands.add(e);
    }

    @Override
    public void execute() {
        try {
            Scanner in = new Scanner(input);
            while (in.hasNextLine()) {
                String command = in.nextLine();
                Iterable<String> array = Splitter.on(';').omitEmptyStrings().split(command);
                Iterator itr = array.iterator();
                while (itr.hasNext()) {
                    runCommand((String) itr.next());
                }
            }
        } catch (ExitException e) {

        }
    }

    @Override
    @Autowired
    public void setInput(InputStream input) {
        this.input = input;
    }

    @Override
    @Autowired
    public void setOutput(PrintStream output) {
        this.output = new PrintWriter(output);
    }
}
