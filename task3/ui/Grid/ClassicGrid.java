package com.company.task3.ui.Grid;

import com.company.task3.Core.RealPoint;
import com.company.task3.ui.CoordinateSystem.LineDrawer;
import com.company.task3.ui.ScreenConverter;

import static com.company.task3.ui.Application.*;

public class ClassicGrid implements Grid {

    private final int indent = 40;

    @Override
    public void drawGrid(LineDrawer drawer, ScreenConverter converter, RealPoint posOfCenter) {
        double startXPoint = - halfOfWindowWidth + posOfCenter.getX() - (- halfOfWindowWidth + posOfCenter.getX()) % indent;
        double startForYConstLine = posOfCenter.getY() + halfOfWindowHeight;
        double endForYConstLine = posOfCenter.getY() - halfOfWindowHeight;
        for (double i = startXPoint; i <= startXPoint + WINDOW_WIDTH; i += indent) {
            drawer.drawLine(converter.r2s(new RealPoint(i, startForYConstLine)), converter.r2s(new RealPoint(i, endForYConstLine)));
        }

        double startYPoint = - halfOfWindowHeight + posOfCenter.getY() - (halfOfWindowWidth + posOfCenter.getY()) % indent;
        double startForXConstLine = posOfCenter.getX() - halfOfWindowWidth;
        double endForXConstLine = posOfCenter.getX() + halfOfWindowWidth;
        for (double i = startYPoint; i <= startYPoint + WINDOW_HEIGHT; i += indent) {
            drawer.drawLine(converter.r2s(new RealPoint(startForXConstLine, i)), converter.r2s(new RealPoint(endForXConstLine, i)));
        }
    }
}
