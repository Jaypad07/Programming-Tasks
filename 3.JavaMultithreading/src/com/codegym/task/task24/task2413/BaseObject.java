package com.codegym.task.task24.task2413;

public abstract class BaseObject {
    protected double x;
    protected double y;
    protected double radius;


    public BaseObject() {

    }

    public BaseObject(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public abstract void draw(Canvas obj);

    public abstract void move();

    public boolean intersects(BaseObject o) {
        return (this.getX() - o.getX()) + (this.getY() - o.getY()) <= Math.max(this.getRadius(), o.radius);
    }


    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
