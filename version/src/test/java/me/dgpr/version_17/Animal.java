package me.dgpr.version_17;

public abstract sealed class Animal permits Cat {
    public abstract void sound();
}
