package ru.fizteh.java2.bajiuk.commands.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.fizteh.java2.bajiuk.databasecore.*;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Component
public class DbConfiguration {
    private static final Logger log = LoggerFactory.getLogger(DbConfiguration.class);
    public TableProvider provider;
    public Table table;

    @Value("${database.directory:\"D:/tmp/\"}")
    public String path;

    public DbConfiguration() {
    }

    @PostConstruct
    private void postConstruct() {
        log.warn("Database folder : " + path);
        try {
            provider = new MyTableProviderFactory().create(path);
        } catch (IOException e) {
            log.error("Cannot use directory! " + path + " " + e.toString());
        }
    }

    public int getChanges() {
        if (table != null) {
            return ((DataBase) table).getNewKeys();
        }
        return 0;
    }

}
