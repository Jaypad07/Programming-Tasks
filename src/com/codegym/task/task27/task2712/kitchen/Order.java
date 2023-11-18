package com.codegym.task.task27.task2712.kitchen;

import com.codegym.task.task27.task2712.Tablet;

import java.util.List;

public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) {
        this.tablet = tablet;
    }
}
