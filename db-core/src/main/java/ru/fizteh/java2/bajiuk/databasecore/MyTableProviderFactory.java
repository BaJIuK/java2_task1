package ru.fizteh.java2.bajiuk.databasecore;

import java.io.File;
import java.io.IOException;

public class MyTableProviderFactory implements TableProviderFactory {

    @Override
    public TableProvider create(String dir) throws IOException {
        if (dir == null || dir.trim().equals("")) {
            throw new IllegalArgumentException("Dir cannot be null");
        }

        File tableDirFile = new File(dir);

        if (!tableDirFile.exists()) {
            if (!tableDirFile.mkdirs()) {
                throw new IOException("Cannot create directory! " + tableDirFile.getCanonicalPath());
            }
        }

        if (!tableDirFile.isDirectory()) {
            throw new IllegalArgumentException("Wrong dir " + dir);
        }

        return new DataBaseTable(dir);
    }
}
