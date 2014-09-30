package ru.fizteh.java2.bajiuk.databasecore;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

public class WorkWithJSON {

    public static String serialize(Table table, Storeable value) throws ColumnFormatException {

        try {
            value.getColumnAt(table.getColumnsCount());
            throw new ColumnFormatException("Too many columns!");
        } catch (IndexOutOfBoundsException e) {
        }

        Gson gson = new Gson();
        JsonArray array = new JsonArray();
        for (int i = 0; i < table.getColumnsCount(); ++i) {
            try {
                if (value.getColumnAt(i) == null || value.getColumnAt(i).getClass() == table.getColumnType(i)) {
                    array.add(gson.toJsonTree(value.getColumnAt(i)));
                } else {
                    throw new ColumnFormatException("Column " + i + " has wrong type!");
                }
            } catch (IndexOutOfBoundsException e) {
                throw new ColumnFormatException("Too few columns!");
            }
        }
        return array.toString();
    }

    public static Storeable deserialize(Table table, String value) {
        if (value == null) {
            return null;
        }
        Storeable result = new MyStoreable(table);
        JsonArray array = (new JsonParser().parse(value)).getAsJsonArray();
        for (Integer i = 0; i < array.size(); ++i) {
            result.setColumnAt(i, array.get(i));
        }
        return result;
    }
}
