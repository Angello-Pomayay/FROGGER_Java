package frogger_game;

import java.awt.*;
import java.io.IOException;
import java.util.Queue;

public class Riga {
    private Frogger frogger;

    int cont;

    private int y = 0;

    private boolean dir;

    public Riga(Frogger frogger){
        this.frogger = frogger;
    }

    void Update() throws InterruptedException {
        int i = 0;
        for (Queue o_coda: frogger.arr_code) {
            for (Car c : frogger.arr_code[i]) {
                c.moveCar();
            }
            i++;
        }
    }

    public int paint(Graphics2D g, int r) throws InterruptedException, IOException {
        cont = 0;

        switch (r){
            case 0: y = 50;
                    dir = true;
                    for (Car c : frogger.arr_code[r]) {
                        if(c.paint(g, y, dir)) cont++;
                    }
                    break;
            case 1: y = 100;
                    dir = false;
                    for (Car c : frogger.arr_code[r]) {
                        if(c.paint(g, y, dir)) cont++;
                    }
                    break;
            case 2: y = 150;
                dir = true;
                for (Car c : frogger.arr_code[r]) {
                    if(c.paint(g, y, dir)) cont++;
                }
                break;
            case 3: y = 200;
                dir = false;
                for (Car c : frogger.arr_code[r]) {
                    if(c.paint(g, y, dir)) cont++;
                }
                break;
            case 4: y = 250;
                dir = true;
                for (Car c : frogger.arr_code[r]) {
                    if(c.paint(g, y, dir)) cont++;
                }
                break;
            case 5: y = 300;
                dir = false;
                for (Car c : frogger.arr_code[r]) {
                    if(c.paint(g, y, dir)) cont++;
                }
                break;
            case 6: y = 350;
                dir = true;
                for (Car c : frogger.arr_code[r]) {
                    if(c.paint(g, y, dir)) cont++;
                }
                break;
            case 7: y = 400;
                dir = false;
                for (Car c : frogger.arr_code[r]) {
                    if(c.paint(g, y, dir)) cont++;
                }
                break;
            case 8: y = 450;
                dir = true;
                for (Car c : frogger.arr_code[r]) {
                    if(c.paint(g, y, dir)) cont++;
                }
                break;

        }

        return cont;
    }



}
