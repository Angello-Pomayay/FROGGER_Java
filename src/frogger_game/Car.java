package frogger_game;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Car {

    private static final int HEIGHT = 50;
    private static final int WIDTH = 60;

    static BufferedImage img2;
    static BufferedImage img;

    int xr;
    int xar = 1;
    int xl;
    int xal = -1;

    boolean collisione = false;

    int xrectangle = 0, yrectangle = 0;

    boolean life_end = false;

    public Car(int xr, int xl) {
        this.xr = xr;
        this.xl = xl;
    }


    void moveCar() throws InterruptedException {
        if(collision()){
            Vite.rimuovi();
            Frog.Reset();
        }
        xr = xr + xar;
        xl = xl + xal;
    }

    private boolean collision(){
        return Frog.getBounds().intersects(getBounds());
    }

    public boolean paint(Graphics2D g, int y, boolean dir) throws IOException {
        if(dir) {
            if(xr < 760){
                g.drawImage(img, xr, y, WIDTH, HEIGHT, null);
                /*g.setColor(Color.red);
                g.fillRect(xr, y, WIDTH, HEIGHT);*/
            }else life_end = true;
            xrectangle = xr;
            yrectangle = y;
        }
        else {
            if(xl > -60) {
                g.drawImage(img2, xl, y, WIDTH, HEIGHT, null);
                /*g.setColor(Color.red);
                g.fillRect(xl, y, WIDTH, HEIGHT);*/
            }else life_end = true;
            xrectangle = xl;
            yrectangle = y;
        }
        return life_end;
    }

    public Rectangle getBounds(){
        return new Rectangle(xrectangle, yrectangle, WIDTH, HEIGHT);
    }

}
