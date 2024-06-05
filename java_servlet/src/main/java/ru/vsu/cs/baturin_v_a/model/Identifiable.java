package ru.vsu.cs.baturin_v_a.model;

public interface Identifiable<T> {
    void setId(T id);
    T getId();
}
