package co.edu.uniquindio.programacion3.parcial2.parcial2.hilos;

public class T2 extends Thread {
    private int[][] matriz;
    private double promedio;

    public T2(int[][] matriz) {
        this.matriz = matriz;
    }

    public double promedioMatriz() {
        int sumaTotal = 0;
        int totalElementos = 0;

        for(int i = 0; i < this.matriz.length; ++i) {
            for(int j = 0; j < this.matriz[i].length; ++j) {
                sumaTotal += this.matriz[i][j];
                ++totalElementos;
            }
        }

        return totalElementos > 0 ? (double)sumaTotal / (double)totalElementos : 0.0;
    }

    public void run() {
        this.promedio = this.promedioMatriz();
    }

    public double getPromedio() {
        return this.promedio;
    }
}
