package uk.netbuilder.go;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseManager implements java.awt.event.MouseListener, MouseMotionListener {
    private boolean mouseClicked = false;
    private boolean mouseRightButtonClicked = false;
    private boolean mouseMiddleClicked = false;
    private boolean mouseMiddlePressed;
    private boolean mouseDragged;

    private float x;
    private float y;
    private float lastUpdatedX;
    private float lastUpdatedY;

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1){
            mouseClicked = true;
        }

        if(e.getButton() == MouseEvent.BUTTON2){
            mouseMiddleClicked = true;
            mouseClicked = false;
        }

        if(e.getButton() == MouseEvent.BUTTON3){
            mouseRightButtonClicked = true;
            mouseClicked = false;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        lastUpdatedX = e.getX();
        lastUpdatedY = e.getY();
        if(e.getButton() == MouseEvent.BUTTON2){
            mouseMiddlePressed = true;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getX() != lastUpdatedX) {
            x = lastUpdatedX;
        }
        if (e.getX() != lastUpdatedY) {
            y = lastUpdatedY;
        }
        if(e.getButton() == MouseEvent.BUTTON2){
            mouseMiddlePressed = false;
        }
        mouseClicked = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {
        mouseClicked = false;
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        x = e.getX();
        y = e.getY();
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public boolean isMouseClicked() {
        return mouseClicked;
    }

    public void setMouseClicked(boolean mouseClicked) {
        this.mouseClicked = mouseClicked;
    }

}
