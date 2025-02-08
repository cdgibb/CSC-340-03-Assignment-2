package com.csc340.Assignment2;

public class Card {

    private String name;

    private String type;
    private int atk;
    private int def;
    private int level;

    public Card(String name, String type, int atk,int def, int level) {
        this.name = name;
        this.type = type;
        this.atk = atk;
        this.def = def;
        this.level = level;
    }

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {return def; }

    public void setDef(int def) {
        this.def = def;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
