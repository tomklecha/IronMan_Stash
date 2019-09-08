package com.tkdev.ironmanstash.infinity_stones.fragments.details;

public class SingleStone {

    private String name;
    private int color;
    private int quest;
    private int password;

    public SingleStone() {
    }

    String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    int getQuest() {
        return quest;
    }

    public void setQuest(int quest) {
        this.quest = quest;
    }

    int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }
}
