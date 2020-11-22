package com.company.task3.ui;

import javax.swing.*;

public class Application {

    public static final int WINDOW_WIDTH = 800;
    public static final int WINDOW_HEIGHT = 800;

    public static final double halfOfWindowWidth = Application.WINDOW_WIDTH / 2.0;
    public static final double halfOfWindowHeight = Application.WINDOW_HEIGHT / 2.0;

    public static void main(String[] args) {
        JFrame applicationFrame = new JFrame("Координатная сетка");
        applicationFrame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        applicationFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        applicationFrame.setLocationRelativeTo(null);
        applicationFrame.setResizable(false);
        applicationFrame.add(new DrawPanel());
        applicationFrame.setVisible(true);
    }
}
