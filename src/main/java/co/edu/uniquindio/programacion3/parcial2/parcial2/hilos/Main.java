package co.edu.uniquindio.programacion3.parcial2.parcial2.hilos;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        int[][] matriz = new int[][]{
                {60, 22, 41, 5, 2},
                {13, 33, 44, 5, 3},
                {89, 10, 100, 99, 1}
        };
        T1 s1 = new T1(matriz);
        T2 s2 = new T2(matriz);
        s1.start();
        s2.start();

        try {
            s1.join();
            s2.join();
        } catch (InterruptedException var9) {
            InterruptedException e = var9;
            e.printStackTrace();
        }

        int a = s1.getResultado();
        double b = s2.getPromedio();
        double c = 0.0;
        if (b != 0.0) {
            c = (double)a / b;
        } else {
            System.out.println("B debe ser diferente de 0");
        }

        System.out.println("Resultado de c: " + c);
    }
}
