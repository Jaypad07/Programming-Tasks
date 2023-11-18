package com.codegym.task.task27.task2712.kitchen;

public enum Dish {
    Fish,
    Steak,
    Soup,
    Juice,
    Water;

    public static String allDishesToString() {
        StringBuilder result = new StringBuilder();

        for (Dish dish : Dish.values()) {
            if (result.isEmpty()) {
                result.append(dish.name());
            } else {
                result.append(", ").append(dish.name());
            }
        }
        return result.toString();
    }


}
