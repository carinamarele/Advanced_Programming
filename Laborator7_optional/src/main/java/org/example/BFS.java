package org.example;


import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    /**
     * <p>Fac o parcurgere bfs pentru a afla numarul de noduri</p>
     * @param matriceAdiacenta matricea de adicacenta ce reprezinta tabela de joc
     * @param visited vector pentru toate nodurile deja vizitate
     * @param startingNode nodul de unde pornesc sa fac parcurgerea BFS
     * @return numarul de noduri a componentei conexe
     */
    public static int BFSAlgoritm(int[][] matriceAdiacenta, boolean visited[], int startingNode) {
        if(visited[startingNode]) return 0;
        Queue<Integer> queue = new LinkedList<>();//coada pentru elementele cu prioritate,aici retin ultimul nod vizitat

        queue.add(startingNode);//adaug nodul de plecare
        visited[startingNode] = true;//bifez ca am fost acolo
        int numberOfNodes = 1;//numar nodurile din componenta conexa

        while (!queue.isEmpty()) {

            int front = queue.remove();//salvez ce urma sa vizitez

            for(int neighbour = 0; neighbour < visited.length; ++neighbour) {

                if(matriceAdiacenta[front][neighbour] == 1) {

                    if(!visited[neighbour]){//daca nu am mai fost in nodul respectiv il bifez in lista de vizitat
                        visited[neighbour] = true;
                        queue.add(neighbour);//il retin ca ultimul nod vizitat
                        numberOfNodes++;// si cresc numarul de noduri
                    }
                }
            }
        }

        //la final in nbNodes voi avea numarul de noduri ale componentei conexe
        return  numberOfNodes;
    }

}