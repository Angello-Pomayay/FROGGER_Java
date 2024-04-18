package com.company;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Frog {

    private static final int FR_WH = 40;

    static int x = 360;
    int xa;
    static int y = 550;
    int ya;

    static BufferedImage img_sopra;
    static BufferedImage img_sotto;
    static BufferedImage img_destra;
    static BufferedImage img_sinistra;

    static int verso = 1;
    boolean rightC = false, leftC = false, upC = false, downC = false, singl = false;

    private Frogger frogger;

    void moveFrog() throws InterruptedException {
        if(y == 0) {
            Reset();
            Vite.punteggio++;
            Frogger.vel_counter--;
        }
        if(x+xa>=0&&x+xa<=frogger.getWidth())x = x+xa;
        if(y+ya>=0&&y+ya<=frogger.getHeight()-FR_WH)y = y+ya;
        xa = 0;
        ya = 0;
    }

    public Frog(Frogger frogger){
        this.frogger = frogger;
    }

    public void paint(Graphics2D g) throws IOException {
        switch (verso){
            case 1: g.drawImage(img_sopra, x, y+5, FR_WH, FR_WH, null);
                    break;
            case 2: g.drawImage(img_destra, x, y+5, FR_WH, FR_WH, null);
                    break;
            case 3: g.drawImage(img_sotto, x, y+5, FR_WH, FR_WH, null);
                break;
            case 4: g.drawImage(img_sinistra, x, y+5, FR_WH, FR_WH, null);
                break;

        }
    }

    public void keyReleased(KeyEvent e){
        switch (e.getKeyCode()){
            case KeyEvent.VK_RIGHT:
                rightC = false;
                break;
            case KeyEvent.VK_LEFT:
                leftC = false;
                break;
            case KeyEvent.VK_UP:
                upC = false;
                break;
            case KeyEvent.VK_DOWN:
                downC = false;
                break;
        }
    }

    public void keyPressed(KeyEvent e){

        switch (e.getKeyCode()){
            case KeyEvent.VK_RIGHT:
                if(!rightC) {
                    xa = FR_WH;
                    rightC = true;
                    verso = 2;
                  //  System.out.println("destra");
                }

                break;
            case KeyEvent.VK_LEFT:
                if(!leftC) {
                    xa = -(FR_WH);
                    leftC = true;
                    verso = 4;
                   // System.out.println("sinistra");
                }
                break;
            case KeyEvent.VK_UP:
                if(!upC) {
                    ya = -(FR_WH+10);
                    upC = true;
                    verso = 1;
                 //   System.out.println("sopra");
                }
                break;
            case KeyEvent.VK_DOWN:
                if(!downC) {
                    ya = FR_WH+10;
                    downC = true;
                    verso = 3;
                   // System.out.println("sotto");
                }
                break;
        }

    }

    public static Rectangle getBounds(){
        return new Rectangle(x, y, FR_WH-5, FR_WH-5);
    }

    public static void Reset() throws InterruptedException {
        Thread.sleep(1000);
        verso = 1;
        x = 360;
        y = 550;
    }



}
