package com.company.task2.line_drawers;

import com.company.task2.LineDrawer;
import com.company.task2.PixelDrawer;

import java.awt.*;

public class BresenhamLineDrawer implements LineDrawer {
    private PixelDrawer pd;

    public BresenhamLineDrawer(PixelDrawer pd) {
        this.pd = pd;
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        //int dx = x2 - x1;
        //int dy = y2 - y1;
        //int err = 2 * dy - dx;
        int a;
        if (Math.abs(x2-x1) > Math.abs(y2-y1)) {
            if (x1 > x2){
                int imp =  x1;
                x1 = x2;
                x2 = imp;
                imp = y1;
                y1 = y2;
                y2 = imp;
            }
            if (y2 > y1)
                a = 1;
            else
                a = -1;

            int dx = x2 - x1;
            int dy = y2 - y1;
            int y = y1;
            int err = 2 * dy * a - dx;
        for (int x = x1; x <= x2; x++) {
            pd.drawPixel(x, y, Color.ORANGE);
            if (err > 0) {

                err += -2 * dx + 2 * dy * a;
                y += a;
            } else {
                err += 2 * dy * a;
            }

        }
        } else {
            if (y1 > y2) {
                int imp = y1;
                y1 = y2; y2 = imp;
                imp = x1;
                x1 = x2;
                x2 = imp;
            }
            if (x2 > x1)
                a = 1;
            else
                a = -1;


            int y = y1;
            int dx = x2 - x1;
            int dy = y2 - y1;
            int err = 2 * dx * a - dy;
            for (int x = x1; y <= y2; y++) {
                pd.drawPixel(x, y, Color.black);
                if (err > 0) {
                    err += 2 * dx * a - 2 * dy;
                    x += a;
                } else {
                    err += 2 * dx * a;
                 }
            }
        }
    }
}

