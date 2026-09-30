package com.mycompany.gol;

import javax.swing.JFrame;
import javax.swing.Timer;

public class GOL {

    public static void main(String[] args) {

        JFrame ventana = new JFrame("GOL - Conway");

        int rows = 30, cols = 40, cellSize = 20;

        GOLPanel golPanel = new GOLPanel(rows, cols, cellSize);
        Modelo modelo = new Modelo(rows, cols);

        boolean[][] inicial = new boolean[rows][cols];
       inicial[1][2] = true;
       inicial[2][3] = true;
       inicial[3][1] = true;
       inicial[3][2] = true;
       inicial[3][3] = true;
        modelo.setGrid(inicial);
        golPanel.setGrid(modelo.getGrid());

        ventana.add(golPanel);
        ventana.pack();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);

        Timer timer = new Timer(250, e -> {
            modelo.siguienteGeneracion();
            golPanel.setGrid(modelo.getGrid());
        });
        timer.start();
    }
}
