package com.mycompany.gol;

/**
 *
 * @author dam2_alu01@inf.ald
 */
public class Modelo {
    private boolean[][] grid;
    private final int rows;
    private final int cols;

    private static final int[][] DIRECCIONES = {
        {-1, -1}, {-1, 0}, {-1, 1},
        { 0, -1},          { 0, 1},
        { 1, -1}, { 1, 0}, { 1, 1}
    };

    public Modelo(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.grid = new boolean[rows][cols];
    }

    public boolean[][] getGrid() {
        return grid;
    }

    public void setGrid(boolean[][] grid) {
        this.grid = grid;
    }

    public void siguienteGeneracion() {
        boolean[][] nuevoGrid = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int vecinasVivas = contarVecinasVivas(i, j);
                boolean viva = grid[i][j];
                if (viva && (vecinasVivas == 2 || vecinasVivas == 3)) {
                    // Sobrevive
                    nuevoGrid[i][j] = true;
                } else if (!viva && vecinasVivas == 3) {
                    // Nace
                    nuevoGrid[i][j] = true;
                } else {
                    // Muere
                    nuevoGrid[i][j] = false;
                }
            }
        }
        grid = nuevoGrid; 
    }

    private int contarVecinasVivas(int i, int j) {
        int contador = 0;

        for (int[] d : DIRECCIONES) {
            int f = (i + d[0] + rows) % rows;
            int c = (j + d[1] + cols) % cols;

            if (grid[f][c]) {
                contador++;
            }
        }

        return contador;
    }
}
