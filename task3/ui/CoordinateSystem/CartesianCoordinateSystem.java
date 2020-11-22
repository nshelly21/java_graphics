package com.company.task3.ui.CoordinateSystem;

import com.company.task3.Core.RealPoint;
import com.company.task3.ui.ScreenConverter;

import javax.swing.*;

import java.util.LinkedList;
import java.util.List;

import static com.company.task3.ui.Application.halfOfWindowHeight;
import static com.company.task3.ui.Application.halfOfWindowWidth;

public class CartesianCoordinateSystem implements CoordinateSystem {

    @Override
    public void drawSystem(LineDrawer drawer, ScreenConverter converter, RealPoint posOfCenter) {
        //0x axis
        RealPoint xAxisStart = new RealPoint(- halfOfWindowWidth + posOfCenter.getX(), 0);
        RealPoint xAxisEnd = new RealPoint(halfOfWindowWidth + posOfCenter.getX(), 0);
        drawer.drawLine(converter.r2s(xAxisStart), converter.r2s(xAxisEnd));

        //0y axis
        RealPoint yAxisStart = new RealPoint(0 ,halfOfWindowHeight + posOfCenter.getY());
        RealPoint yAxisEnd = new RealPoint(0 ,- halfOfWindowHeight + posOfCenter.getY());
        drawer.drawLine(converter.r2s(yAxisStart), converter.r2s(yAxisEnd));
    }

    public List<JLabel> getCoordinateList(LineDrawer lineDrawer, ScreenConverter converter, RealPoint posOfCenter) {
        int labelWidth = 10;
        int labelHeight = 10;
        List<JLabel> result = new LinkedList<>();
        /*JLabel label = new JLabel("0");
        RealPoint labelAngle = new RealPoint( - posOfCenter.getX() - labelWidth, - posOfCenter.getY() - labelHeight);
        label.setBounds(converter.r2s(labelAngle).getX(), converter.r2s(labelAngle).getY(), labelWidth, labelHeight);
        result.add(label);
        RealPoint xAxisStart = new RealPoint(- halfOfWindowWidth + posOfCenter.getX(), 10);
        RealPoint xAxisEnd = new RealPoint(halfOfWindowWidth + posOfCenter.getX(), 10);
        lineDrawer.drawLine(converter.r2s(xAxisStart), converter.r2s(xAxisEnd));
        //for (int i = posOfCenter; )
         */
        return result;
    }
}
