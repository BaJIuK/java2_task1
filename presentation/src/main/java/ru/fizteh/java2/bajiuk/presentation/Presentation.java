package ru.fizteh.java2.bajiuk.presentation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.fizteh.java2.bajiuk.commands.filesystem.*;
import ru.fizteh.java2.bajiuk.shell.Shell;

import java.io.IOException;

public class Presentation {
    public static void main(final String[] args) throws IOException{
        ApplicationContext ctx = new AnnotationConfigApplicationContext(MyContext.class);
        FilesystemContext context = new FilesystemContext();

        Shell shell = ctx.getBean(Shell.class);

        shell.addCommand(new Ls(context));
        shell.addCommand(new Pwd(context));
        shell.addCommand(new Exit(context));
        shell.addCommand(new Mkdir(context));
        shell.addCommand(new Rm(context));
        shell.addCommand(new Cp(context));
        shell.addCommand(new Cd(context));
        shell.addCommand(new Mv(context));

        shell.execute();
    }
}
