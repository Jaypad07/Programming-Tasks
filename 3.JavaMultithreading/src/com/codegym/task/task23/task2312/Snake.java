package com.codegym.task.task23.task2312;

import java.util.ArrayList;
import java.util.List;

public class Snake {

    private int x;
    private int y;
    private List<SnakeSection> sections;
    private boolean isAlive;
    private SnakeDirection direction;

    public Snake() {
    }

    public Snake(int x, int y) {
        this.x = x;
        this.y = y;
        SnakeSection head = new SnakeSection(x, y);
        sections = new ArrayList<>();
        sections.add(head);
        isAlive = true;
    }

    public void move() {

    }

    public int getX() {
        return getSections().get(0).getX();
    }

    public int getY() {
        return getSections().get(0).getY();
    }

    public void setDirection(SnakeDirection direction) {
        this.direction = direction;
    }

    public List<SnakeSection> getSections() {
        return sections;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public SnakeDirection getDirection() {
        return direction;
    }
}
