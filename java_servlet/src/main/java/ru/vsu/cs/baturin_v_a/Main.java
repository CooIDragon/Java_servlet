package ru.vsu.cs.baturin_v_a;

import ru.vsu.cs.baturin_v_a.cli.Menu;
import ru.vsu.cs.baturin_v_a.repository.database.DatabaseManagerImpl;

public class Main {

    public static void main(String[] args) {
        DatabaseManagerImpl dbManager = DatabaseManagerImpl.getInstance();
        dbManager.connect();
        Menu.run();
        dbManager.closeConnection();
    }
}
