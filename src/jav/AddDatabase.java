package jav;

public class AddDatabase {
    private static AddDatabase database;

    public static AddDatabase getInstance() {
        if (database == null) {
            database = new AddDatabase();
        }
        return database;
    }
}
