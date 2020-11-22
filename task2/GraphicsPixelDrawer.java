package com.company.task2;

import java.awt.*;

public class GraphicsPixelDrawer implements PixelDrawer {
    private Graphics g;

    public GraphicsPixelDrawer(Graphics g) {
        this.g = g;
    }

    @Override
    public void drawPixel(int x, int y, Color C) {
        g.setColor(C);
        g.fillRect(x,y,1,1);

    }
}
