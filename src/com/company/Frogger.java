package com.company;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;
public class Frogger extends JPanel{

    Frog frog = new Frog(this);
    Riga riga = new Riga(this);

    Vite vite = new Vite(this);
    final ImageIcon icon = new ImageIcon(Frogger.class.getResource("/img/end_emoji.png"));
    public static Queue<Car>[] arr_code = new Queue[9];

    static Random random = new Random();
    static int vel_counter = 4;
    private static int speed = 8;
    static long inizio;
   static Font customFont, customFontCountdown;

    public Frogger(){
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(System.currentTimeMillis() > (inizio + 4000)) {
                    frog.keyPressed(e);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(System.currentTimeMillis() > (inizio + 4000)) {
                    frog.keyReleased(e);
                }
            }
        });
        setFocusable(true);
    }

    private void move() throws InterruptedException {
        frog.moveFrog();
        riga.Update();
    }

    public void gameOver() throws InterruptedException {
       // JOptionPane.showMessageDialog(this, "PUNTEGGIO: "+ Vite.punteggio + "\nRIPROVA", "GAME OVER", JOptionPane.PLAIN_MESSAGE, icon); //solo riprova niente opzioni
        Object[] options = {"RIPROVA", "ESCI"};
        int scelta = JOptionPane.showOptionDialog
                (
                this, "PUNTEGGIO: "+ Vite.punteggio,
                "GAME OVER",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                icon,
                options,
                options[0]
                );

        if(scelta == 0){
        Vite.cont_vite = 3;
        Vite.punteggio = 0;
        speed = 8;
        Frog.Reset();
        inizio = System.currentTimeMillis();
       }
        else System.exit(ABORT);
    }

    @Override
    public void paint(Graphics g){
        int cont = 0;
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(Color.gray);
        g.fillRect(0, 50, 775, 450);
        g.setColor(new Color(0,153,204));
        g.fillRect(0, 0, 775, 50);
        g.setColor(new Color(17, 161, 89));
        g.fillRect(0, 500, 775, 110);

        try {
            frog.paint(g2d);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        vite.paint(g2d);

        //CODA 0
        try {
          cont = riga.paint(g2d, 0);
        } catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
        generatore(cont, 0);

        //CODA 1
        try {
            cont = riga.paint(g2d, 1);
        } catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
        generatore(cont, 1);

        //CODA 2
        try {
            cont = riga.paint(g2d, 2);
        } catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
        generatore(cont, 2);

        //CODA 3
        try {
            cont = riga.paint(g2d, 3);
        } catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
        generatore(cont, 3);

        //CODA 4
        try {
            cont = riga.paint(g2d, 4);
        } catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
        generatore(cont, 4);

        //CODA 5
        try {
            cont = riga.paint(g2d, 5);
        } catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
        generatore(cont, 5);

        //CODA 6
        try {
            cont = riga.paint(g2d, 6);
        } catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
        generatore(cont, 6);

        //CODA 7
        try {
            cont = riga.paint(g2d, 7);
        } catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
        generatore(cont, 7);

        //CODA 8
        try {
            cont = riga.paint(g2d, 8);
        } catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
        generatore(cont, 8);

        g.setFont(customFontCountdown);
        g.setColor(Color.white);
        if(System.currentTimeMillis()> (inizio + 1000) && System.currentTimeMillis() < (inizio+2000)){
            g.drawString("3", 310, 350);
        }
        if(System.currentTimeMillis()> (inizio + 2000) && System.currentTimeMillis() < (inizio+3000)){
            g.drawString("2", 310, 350);
        }
        if(System.currentTimeMillis()> (inizio + 3000) && System.currentTimeMillis() < (inizio+4000)){
            g.drawString("1", 310, 350);
        }

        g.setFont(customFont);
        g.setColor(Color.white);

        if(Vite.punteggio<10) g.drawString("0000"+Vite.punteggio, 650, 570);
        else g.drawString("000"+Vite.punteggio, 650, 570);
    }

    public void generatore(int contatore, int n_coda){
        int add_car = 0;
        int num_casuale;
        for(int i = 0; i< contatore; i++){
            arr_code[n_coda].remove();
        }
        for (Car c : arr_code[n_coda]) {
            if(c.xr == 100) add_car++;
        }


        for(int i =0; i<add_car; i++){
            //arr_code[n_coda].add(new Car(random.nextInt(200-60)-200, random.nextInt(900-760)+760)); problema di sovrapposizione
            num_casuale = random.nextInt(240);
            arr_code[n_coda].add(new Car(num_casuale-300, 1000-num_casuale)); //niente sovrapposizione
        }
    }

    public static void main(String[] args) throws InterruptedException, IOException, FontFormatException {
        //coda.add(new Car());
        int num_casuale;
        for(int i = 0; i <= 8; i++){                                    //inizializzo e aggiungo un'auto ad ogni coda;
            num_casuale = random.nextInt(240);
            arr_code[i] = new LinkedList<Car>();
            arr_code[i].add(new Car(num_casuale-300, 1000-num_casuale));
        }

        /*Car.img = ImageIO.read(new File("img/destra_racing.png"));
        Car.img2 = ImageIO.read(new File("img/sinistra_racing.png"));
        Frog.img_sopra = ImageIO.read(new File("img/frog_sopra.png"));
        Frog.img_destra = ImageIO.read(new File("img/frog_destra.png"));
        Frog.img_sinistra = ImageIO.read(new File("img/frog_sinistra.png"));
        Frog.img_sotto = ImageIO.read(new File("img/frog_sotto.png"));
        Vite.img_cuore = ImageIO.read(new File("img/cuore.png"));*/

        //aggiustamento per l'inserimento dentro il jar della cartella img e fonts

        Car.img = ImageIO.read(Frogger.class.getResourceAsStream("/img/destra_racing.png"));
        Car.img2 = ImageIO.read(Frogger.class.getResourceAsStream("/img/sinistra_racing.png"));
        Frog.img_sopra = ImageIO.read(Frogger.class.getResourceAsStream("/img/frog_sopra.png"));
        Frog.img_destra = ImageIO.read(Frogger.class.getResourceAsStream("/img/frog_destra.png"));
        Frog.img_sinistra = ImageIO.read(Frogger.class.getResourceAsStream("/img/frog_sinistra.png"));
        Frog.img_sotto = ImageIO.read(Frogger.class.getResourceAsStream("/img/frog_sotto.png"));
        Vite.img_cuore = ImageIO.read(Frogger.class.getResourceAsStream("/img/cuore.png"));


        /*customFontCountdown = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/custom_8bit.ttf")).deriveFont(150f);
        customFont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/custom_8bit.ttf")).deriveFont(20f);*/

        customFont = Font.createFont(Font.TRUETYPE_FONT, Frogger.class.getResourceAsStream("/fonts/custom_8bit.ttf")).deriveFont(20f);
        customFontCountdown = Font.createFont(Font.TRUETYPE_FONT, Frogger.class.getResourceAsStream("/fonts/custom_8bit.ttf")).deriveFont(150f);


        inizio = System.currentTimeMillis();

        JFrame frame = new JFrame("FROGGER");
        Frogger frogger = new Frogger();
        frame.add(frogger);
        frame.setSize(775, 640);
        frame.setVisible(true);
        frame.setResizable(false);
        //frame.setIconImage(ImageIO.read(new File("img/frog.png")));
        frame.setIconImage(ImageIO.read(Frogger.class.getResourceAsStream("/img/frog.png")));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        while(true){
            frogger.move();
            frogger.repaint();
            Thread.sleep(speed);
            if(vel_counter == 0 && speed>3){       // aumento la velocità ogni volta che vince 4 volte fino a 3
                speed--;
                vel_counter = 4;
            }
            //System.out.println(speed); //stampa la velocità attuale
        }

    }

}
