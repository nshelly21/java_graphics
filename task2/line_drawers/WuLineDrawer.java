package com.company.task2.line_drawers;

import com.company.task2.LineDrawer;
import com.company.task2.PixelDrawer;

import java.awt.*;

public class WuLineDrawer implements LineDrawer {
    private PixelDrawer pd;

    public WuLineDrawer(PixelDrawer pd) {
        this.pd = pd;
    }

    public void draw(int x1, int y1, int x2, int y2, boolean change) {
        int a = 1;
        pd.drawPixel(x1, y1, Color.GREEN);
        if (x1 > x2) {
            int imp = x1;
            x1 = x2;
            x2 = imp;
             imp = y1;
             y1 = y2;
             y2 = imp;
        }
        if (y1 > y2)
            a *= -1;

        int dx = x2 - x1; int dy = a * (y2 - y1);
        int x = x1 + 1;
        int y = y1; int yy;
        double tg = (double) dy / dx;
        double y_line;
        double grad;

        int err = 2 * dy - dx; int e1 = 2 * dy; int d2 = 2 * (dy - dx);
        while (x < x2) {
            y_line = tg * (x - x1) * a + y1;
            if (err < 0) {
                err = err + e1;
            } else if (err >= 0) {
                err = err + d2;
                y = y + a;
            }
            if (((a>0) && (y_line>y)) || ((a<0) && (y_line<y))) {
                yy = y + a;
            } else {
                yy = y - a;
            }
            if (yy == y) {
                grad = 1;
            } else {
                if (Math.abs(y_line - y) < 1){
                    grad = Math.abs((y_line - y));
                } else grad = Math.abs(y_line - yy);
            }
            if (change) {


                pd.drawPixel(yy, x, new Color(0, 255, 0, (int) (255 * grad)));
                pd.drawPixel(y, x, new Color(0, 255, 0, (int) (255 * (1 - grad))));

            } else {


                pd.drawPixel(x, yy, new Color(0, 255, 0, (int) (255 * grad)));
                pd.drawPixel(x, y, new Color(0, 255, 0, (int) (255 * (1-grad))));
            }
            x++;
        }
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        int dy = y2 - y1;
        int dx = x2 - x1;
        if (Math.abs(dy) < Math.abs(dx)) {
            draw(x1, y1, x2, y2, false);
        } else if (Math.abs(dy) >= Math.abs(dx)) {
            draw(y1, x1, y2, x2, true);
        }
    }
}





