package com.company.task3.ui.Grid;

import com.company.task3.Core.RealPoint;
import com.company.task3.ui.CoordinateSystem.LineDrawer;
import com.company.task3.ui.ScreenConverter;

public interface Grid {
    void drawGrid(LineDrawer drawer, ScreenConverter converter, RealPoint posOfCenter);
}
