package com.company.task2;

import com.company.task2.line_drawers.BresenhamLineDrawer;
import com.company.task2.line_drawers.DDALineDrawer;
import com.company.task2.line_drawers.GraphicsLineDrawer;
import com.company.task2.line_drawers.WuLineDrawer;
import com.company.task2.utils.DrawUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

public class DrawPanel extends JPanel implements MouseMotionListener {
    private Point position = new Point(0,0);

    public DrawPanel() {
        this.addMouseMotionListener(this);
    }

    @Override
    public void paint(Graphics g) {
        BufferedImage bi = new BufferedImage(
                getWidth(), getHeight(),
                BufferedImage.TYPE_INT_RGB);
        Graphics bi_g = bi.createGraphics();
        PixelDrawer pd = new GraphicsPixelDrawer(bi_g);

        //LineDrawer ld = new DDALineDrawer(pd);
        //LineDrawer ld = new BresenhamLineDrawer(pd);

        LineDrawer ld = new WuLineDrawer(pd);
        bi_g.setColor(Color.WHITE);
        bi_g.fillRect(0,0,getWidth(),getHeight());
        bi_g.setColor(Color.BLACK);
        /**/
       drawAll(ld);
        /**/
        g.drawImage(bi,0,0,null);
        bi_g.dispose();
    }
    private void drawAll(LineDrawer ld){
        DrawUtils.drawSnowflake(ld, getWidth()/2, getHeight()/2, 80, 90);
        ld.drawLine(getWidth()/2,getHeight()/2,position.x,position.y);
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
      position = new Point(e.getX(),e.getY());
      repaint();
    }
}
