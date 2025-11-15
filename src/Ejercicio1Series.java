import java.util.Scanner;


public class Ejercicio1Series {

 // leer el arreglo
    public static int[] leerArreglo(int n) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
     }
 // suma de elementos 
      public static int[] sumaElementoElemento(int[] a, int[] b) {
        int n = a.length;
        int[] c = new int[n]
         for (int i = 0; i < n; i++) {
            c[i] = a[i] + b[i];
        }
        return c;
    }
 // producto escalar
    public static int productoEscalar(int[] a, int[] b) {
        int n = a.length;
        int suma = 0;
        for (int i = 0; i < n; i++) {
            suma += a[i] * b[i];
        }
        return suma;
    }

    // se agrega rotaciones de derecha de a para obtener b 

 public static int rotacionDerechaDeAParaObtenerB(int[] a, int[] b) {
        int n = a.length;

        for (int k = 0; k < n; k++) {
            boolean coincide = true;

            for (int i = 0; i < n; i++) {
                int posA = (i - k + n) % n;
                if (a[posA] != b[i]) {
                    coincide = false;
                    break;
                }
            }

            if (coincide) {
                return k;
            }
        }
        return -1;
    }

   // Retorna true si a y b tienen las mismas frecuencias de cada número (sin ordenar).
    
    public static boolean mismosElementosComoMulticonjunto(int[] a, int[] b) {
        int n = a.length;

        for (int i = 0; i < n; i++) {
            int valor = a[i];
            int conteoA = 0;
            int conteoB = 0;

            // Contar en A
            for (int j = 0; j < n; j++) {
                if (a[j] == valor) {
                    conteoA++;
                }
            }

            // Contar en B
            for (int j = 0; j < n; j++) {
                if (b[j] == valor) {
                    conteoB++;
                }
            }

            if (conteoA != conteoB) {
                return false;
            }
        }
        return true;
    }
    
       // METODO PRINCIPAL PARA PODER HALLAR LOS RESULTADOS
     public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        if (N < 5 || N > 50) {
            System.out.println("El tamaño N debe estar entre 5 y 50.");
            return;
        }

        int[] A = leerArreglo(N);
        int[] B = leerArreglo(N);

        int[] suma = sumaElementoElemento(A, B);
        int prod = productoEscalar(A, B);
        int rot = rotacionDerechaDeAParaObtenerB(A, B);
        boolean multi = mismosElementosComoMulticonjunto(A, B);

        System.out.println("Suma elementoS :");
        for (int x : suma) System.out.print(x + " ");
        System.out.println();

        System.out.println("Producto escalar ES : " + prod);

        if (rot == -1) {
            System.out.println("B NO es rotación derecha de A.");
        } else {
            System.out.println("B es A rotado " + rot + " posiciones a la derecha.");
        }

        System.out.println("Mismo multiconjunto: " + (multi ? "Sí" : "No"));
    }

}