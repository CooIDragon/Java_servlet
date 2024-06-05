package ru.vsu.cs.baturin_v_a.cli;

public interface Command {
    void execute();

    String getCommandName();
}
