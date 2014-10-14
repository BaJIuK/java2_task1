package ru.fizteh.java2.bajiuk.presentation;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import ru.fizteh.java2.bajiuk.shell.Shell;

@Component
public class Presentation implements CommandLineRunner {

    @Override
    public void run(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(MyContext.class);
        Shell shell = ctx.getBean(Shell.class);
        shell.execute();
    }

}
