package com.will.simple.java.eight.in.action.ch1;

public class Apple {

    private String color;

    private int weight;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public static boolean isGreenApple(Apple apple) {
        if ("green".equals(apple.getColor())) {
            return true;
        }
        return false;
    }
}
