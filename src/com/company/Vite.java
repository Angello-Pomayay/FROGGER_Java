package com.company;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Vite {

    private static Frogger frogger;
    final int y = 570;
    int x = 10;
    static BufferedImage img_cuore;
    static int cont_vite = 3;
    static int punteggio = 0;


    public Vite(Frogger frogger){
        this.frogger = frogger;
    }

    public static void rimuovi() throws InterruptedException {
        cont_vite--;
        if(cont_vite == -1) frogger.gameOver();
    }

    public void paint(Graphics2D g){
        x = 15;
        for(int i = 0; i<cont_vite; i++){
            g.drawImage(img_cuore, x, 550 , 25, 25, null);
            x = x+25;
        }
    }


}
