/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1pa;

/**
 *
 * @author Carina
 */
public class LAB1PA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        class Graph {//creez o clasa pentru grafuri care imi calculeaza si componentele conexe ale acestuia

            int V, nrcompconexe = 0, dim;
            int[][] matrix;
            int[] visited;

            public Graph(int v) {//constructorul care imi creaza matricea si vectorul vizitat pentru dfs
                V = v;
                dim = v;
                matrix = new int[dim][dim];
                visited = new int[dim];
                System.out.println("Avem un graf cu " + v + " noduri!");
            }

            public void DFS(int x) {
                int i;
                visited[x] = nrcompconexe;
                for (i = 0; i < V; i++) {
                    if (matrix[x][i] == 1 && visited[i] == 0) {
                        DFS(i);
                    }
                }
            }

            public void CompConexe() {
                int i;
                for (i = 0; i < V; i++) {
                    if (visited[i] == 0) {
                        nrcompconexe++;
                        DFS(i);
                    }
                }

            }

            public void AfisareComponente() {
                if (nrcompconexe == 1) {
                    System.out.println("Graful are o singura componenta conexa,deci este conex. ");
                } else {
                    System.out.println("Graful are mai multe componente conexe,deci nu este conex.Acestea sunt:");
                }
                int i, j;
                for (i = 1; i <= nrcompconexe; i++) {
                    System.out.print("Componenta conexa " + i + ": ");
                    for (j = 0; j < V; j++) {
                        if (visited[j] == i) {
                            System.out.print(j + " ");
                        }
                    }
                    System.out.print(".");
                    System.out.println("");
                }
            }
        }
//Partea obligatorie a laboratorului
        char c1 = '\u2726';
        char c2 = '\u2727';
        System.out.println("Hello World!");
        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "Javascript", "PHP", "Swift", "Java"};
        int n = (int) (Math.random() * 1000000);
        System.out.println("Numarul random este " + n);
        n = n * 3;
        String binaryString = "10101";
        n = n + Integer.parseInt(binaryString, 2);
        String hexString = "FF";
        n = n + Integer.parseInt(hexString, 16);
        n = n * 6;
        int sum, ok = 0;
        do {
            sum = 0;
            while (n > 9) {
                sum = sum + n % 10;
                n = n / 10;
            }
            if (10 > sum) {
                ok = 1;
            }
            n = sum;
        } while (n > 10);
        System.out.println("Willie-nilly, this semester I will learn " + languages[n]);
//aici se termina
//optional
        int m = Integer.parseInt(args[0]);
        if (m <= 0) {
            System.out.println("Nu putem avea un numar negativ de noduri!!");
        } else {//daca am un numar pozitiv de noduri continui sa creez graful cu tot cu matricea ei de adiacenta
            Graph g = new Graph(m);
            long start = System.nanoTime();//incep sa calculez cat timp imi ia
            int i, j;
            for (i = 0; i < m - 1; i++) {
                for (j = i + 1; j < m; j++) {//aici pun random valori de 1 si 0 in matricea de adiacenta

                    g.matrix[i][j] = (int) (Math.random() * 2);
                    g.matrix[j][i] = g.matrix[i][j];
                    g.matrix[i][i] = 0;
                }
                g.matrix[m - 1][m - 1] = 0;
                //System.out.println(" ");
            }
            long end = System.nanoTime();
            if (m < 30001) {//daca m este mai mic de 30001 atunci afisez matricea de adiacenta si spun daca este conex si componentele ei conexe 
                for (i = 0; i < m; i++) {
                    for (j = 0; j < m; j++) {
                        if (g.matrix[i][j] == 0) {
                            System.out.print(c2);
                        } else {
                            System.out.print(c1);
                        }
                    }
                    System.out.println("");
                }
                g.CompConexe();//se calculeaza componentele conexe
                g.AfisareComponente();//se afiseaza componentele conexe
            } else if (m >= 30000) {//daca m este mai mare atunci afisez timpul in nanosecunde(dureaza in consola in jur de 23-24 de secunde,iar in netbeans in jur de 26-27 de secunde pentru 30001de noduri)
                System.out.println("Timpul in nanosecunde este " + (end - start));
            }
        }
    }
}
