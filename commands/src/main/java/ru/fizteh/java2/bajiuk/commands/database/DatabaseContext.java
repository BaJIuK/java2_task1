package ru.fizteh.java2.bajiuk.commands.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.fizteh.java2.bajiuk.databasecore.*;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Component
public class DatabaseContext {
    private static final Logger log = LoggerFactory.getLogger(DatabaseContext.class);
    public TableProviderFactory factory;
    public TableProvider provider;
    public Table table;

    @Value("${database.directory:\"D:/\"}")
    private String path;

    public DatabaseContext() {
    }

    @PostConstruct
    private void postConstruct() {
        log.warn("Database folder : " + path);
        factory = new MyTableProviderFactory();
        try {
            provider = factory.create(path);
        } catch (IOException e) {

        }
    }
    public DatabaseContext(String path) throws IOException {
        factory = new MyTableProviderFactory();
        provider = factory.create(path);
    }

    public int getChanges() {
        if (table != null) {
            return ((DataBase) table).getNewKeys();
        }
        return 0;
    }

}
