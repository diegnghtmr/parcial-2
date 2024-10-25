package co.edu.uniquindio.programacion3.parcial2.parcial2.hilos;

public class T1 extends Thread {
    private int[][] matriz;
    private int resultado;

    public T1(int[][] matriz) {
        this.matriz = matriz;
    }

    private int menorRecursividad(int fila, int columna, int[][] matriz) {
        if (fila >= matriz.length) {
            return Integer.MAX_VALUE;
        } else if (columna >= matriz[fila].length) {
            return this.menorRecursividad(fila + 1, 0, matriz);
        } else {
            int menorEnResto = this.menorRecursividad(fila, columna + 1, matriz);
            return Math.min(matriz[fila][columna], menorEnResto);
        }
    }

    public void run() {
        this.resultado = this.menorRecursividad(0, this.matriz.length, this.matriz);
    }

    public int getResultado() {
        return this.resultado;
    }
}
