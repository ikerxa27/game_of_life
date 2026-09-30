/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gol;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;

/**
 *
 * @author dam2_alu01@inf.ald
 */
public class GOLPanel extends JPanel {
    private final int rows;
    private final int cols;
    private final int cellSize;
    private boolean[][] grid;

    public GOLPanel(int rows, int cols, int cellSize) {
        this.rows = rows;
        this.cols = cols;
        this.cellSize = cellSize;
        this.grid = new boolean[rows][cols];

        setPreferredSize(new Dimension(cols * cellSize, rows * cellSize));


    }

    public void setGrid(boolean[][] newGrid) {
        this.grid = newGrid;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

       
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        
        g.setColor(Color.BLACK);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j]) {
                    g.fillRect(j * cellSize, i * cellSize, cellSize, cellSize);
                }
            }
        }

        
        g.setColor(Color.LIGHT_GRAY);
        for (int i = 0; i <= rows; i++) {
            g.drawLine(0, i * cellSize, cols * cellSize, i * cellSize);
        }
        for (int j = 0; j <= cols; j++) {
            g.drawLine(j * cellSize, 0, j * cellSize, rows * cellSize);
        }
    }
}