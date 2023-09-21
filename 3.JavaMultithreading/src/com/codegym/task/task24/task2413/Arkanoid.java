package com.codegym.task.task24.task2413;

import java.util.List;

public class Arkanoid {
    private int width;
    private int height;
    private Ball ball;
    private Paddle paddle;
    private List<Brick> bricks;

    public static Arkanoid game;
    private boolean isGameOver;

    public Arkanoid() {

    }

    public Arkanoid(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public static void main(String[] args) {

    }

    public void run() {

    }

    public void move() {
        getPaddle().move();
        getBall().move();
    }

    public void draw(Canvas canvas) {
        getBall().draw(canvas);
        getPaddle().draw(canvas);
        for (Brick brick: getBricks()) {
            brick.draw(canvas);
        }
    }

    public void checkBrickCollision() {
        int del = -1;
        for (int i = 0; i < getBricks().size(); i++) {
            if (getBricks().get(i).intersects(ball)) {
                double angle = Math.random() * 360;
                ball.setDirection(angle);
                del = i;
            }
        }
        if (del > -1) getBricks().remove(del);

//        for (Brick brick: new ArrayList<Brick>(getBricks())) {
//            if (brick.intersects(ball)) {
//                double angle = Math.random() * 360;
//                ball.setDirection(angle);
//                getBricks().remove(brick);
//            }
//        }
    }

    public void checkPaddleCollision() {
        if (paddle.intersects(ball)) {
            double angle = 90 + 20 * (Math.random() - 0.5);
            ball.setDirection(angle);
        }
    }

    public void checkGameOver() {
        if (ball.getY() > game.height) {
            isGameOver = true;
        }
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public Paddle getPaddle() {
        return paddle;
    }

    public void setPaddle(Paddle paddle) {
        this.paddle = paddle;
    }

    public List<Brick> getBricks() {
        return bricks;
    }

    public void setBricks(List<Brick> bricks) {
        this.bricks = bricks;
    }
}
