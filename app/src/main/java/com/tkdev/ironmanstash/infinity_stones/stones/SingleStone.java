package com.tkdev.ironmanstash.infinity_stones.stones;

public class SingleStone {

    private String name;
    private int color;
    private String quest;
    private String password;

    public SingleStone() {
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    int getColor() {
        return color;
    }

    void setColor(int color) {
        this.color = color;
    }

    String getQuest() {
        return quest;
    }

    void setQuest(String quest) {
        this.quest = quest;
    }

    String getPassword() {
        return password;
    }

    void setPassword(String password) {
        this.password = password;
    }
}
