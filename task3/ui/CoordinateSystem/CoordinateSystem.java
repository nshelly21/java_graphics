package com.company.task3.ui.CoordinateSystem;

import com.company.task3.Core.RealPoint;
import com.company.task3.ui.ScreenConverter;

import javax.swing.*;
import java.util.List;

public interface CoordinateSystem {
    void drawSystem(LineDrawer drawer, ScreenConverter converter, RealPoint posOfCenter);
    List<JLabel> getCoordinateList(LineDrawer lineDrawer, ScreenConverter converter, RealPoint posOfCenter);
}
