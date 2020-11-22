package com.company.task3.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.List;

import com.company.task2.PixelDrawer;
import com.company.task3.Core.RealPoint;
import com.company.task3.Core.ScreenPoint;
import com.company.task3.ui.CoordinateSystem.CartesianCoordinateSystem;
import com.company.task3.ui.CoordinateSystem.CoordinateSystem;
import com.company.task3.ui.CoordinateSystem.DDALineDrawer;
import com.company.task3.ui.CoordinateSystem.LineDrawer;
import com.company.task3.ui.Grid.ClassicGrid;
import com.company.task3.ui.Grid.Grid;
import com.company.task3.ui.Grid.GridLineDrawer;

import static com.company.task3.ui.Application.*;

public class DrawPanel extends JPanel implements MouseListener, MouseMotionListener, KeyListener {

    private final ScreenConverter converter = new ScreenConverter(- halfOfWindowWidth, halfOfWindowHeight,
            WINDOW_WIDTH, WINDOW_HEIGHT,
            WINDOW_WIDTH, WINDOW_HEIGHT);

    private RealPoint oldPoint = null;
    private final RealPoint posOfCenter = new RealPoint(0, 0);
    private double scale = 1;

    private List<JLabel> coordinatesList = null;
    private final JButton plus = new JButton("+");
    private final JButton minus = new JButton("-");

    public DrawPanel() {
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.setLayout(null);
        this.addKeyListener(this);
        addButtonsListeners();
        this.setFocusable(true);
    }

    private void addButtonsListeners() {
        plus.addActionListener(e -> {
            scale *= 2;
            clearContainers();
        });
        minus.addActionListener(e -> {
            scale /= 2;
            clearContainers();
        });
    }

    @Override
    public void paintComponent(Graphics g) {
        converter.setScreenWight(getWidth());
        converter.setRealHeight(getHeight());
        BufferedImage bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D gr = bi.createGraphics();
        gr.setColor(Color.WHITE);
        gr.fillRect(0, 0, getWidth(), getHeight());
        gr.dispose();
        PixelDrawer pd = new BufferedImagePixelDrawer(bi);
        LineDrawer axisDrawer = new DDALineDrawer(pd);
        LineDrawer gridDrawer = new GridLineDrawer(pd);
        /**/
        Grid grid = new ClassicGrid();
        grid.drawGrid(gridDrawer, converter, posOfCenter);

        CoordinateSystem coordinateSystem = new CartesianCoordinateSystem();
        coordinateSystem.drawSystem(axisDrawer, converter, posOfCenter);
        coordinatesList = coordinateSystem.getCoordinateList(axisDrawer, converter, posOfCenter);
        coordinatesList.forEach(this::add);
        /**/
        addButtons();
        g.drawImage(bi, 0, 0, null);
    }

    public void addButtons() {
        plus.setBounds(700, 700, 35, 25);
        minus.setBounds(750, 700, 35, 25);
        this.add(plus);
        this.add(minus);
    }

    public void clearContainers() {
        if (coordinatesList != null) {
            coordinatesList.forEach(this::remove);
        }
        remove(plus);
        remove(minus);
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        oldPoint = converter.s2r(new ScreenPoint(mouseEvent.getX(), mouseEvent.getY()));
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        oldPoint = null;
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    private void updateCoordinates(RealPoint newPoint) {
        double dx = newPoint.getX() - oldPoint.getX();
        double dy = newPoint.getY() - oldPoint.getY();
        converter.setRealX(converter.getRealX() - dx);
        converter.setRealY(converter.getRealY() - dy);
        posOfCenter.setX(posOfCenter.getX() - dx);
        posOfCenter.setY(posOfCenter.getY() - dy);
        clearContainers();
        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        RealPoint newPoint = converter.s2r(new ScreenPoint(mouseEvent.getX(), mouseEvent.getY()));
        if (oldPoint != null){
            updateCoordinates(newPoint);
        }
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int shift = 7;
        oldPoint = posOfCenter;
        int event = e.getKeyCode();
        if (event == KeyEvent.VK_UP || event == KeyEvent.VK_W) {
            updateCoordinates(new RealPoint(posOfCenter.getX(), posOfCenter.getY() - shift));
        } else if (event == KeyEvent.VK_RIGHT || event == KeyEvent.VK_D) {
            updateCoordinates(new RealPoint(posOfCenter.getX() - shift, posOfCenter.getY()));
        } else if (event == KeyEvent.VK_LEFT || event == KeyEvent.VK_A) {
            updateCoordinates(new RealPoint(posOfCenter.getX() + shift, posOfCenter.getY()));
        } else if (event == KeyEvent.VK_DOWN || event == KeyEvent.VK_S) {
            updateCoordinates(new RealPoint(posOfCenter.getX(), posOfCenter.getY() + shift));
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
