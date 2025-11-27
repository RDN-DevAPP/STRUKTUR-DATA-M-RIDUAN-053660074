// Nama: M. RIDUAN
// NIM: 053660074
// UPBJJ: UT Banjarmasin

// Buatlah program pencarian menggunakan algoritma Breadth-First Search (BFS) dalam bahasa Java. (40 Poin)
// Gunakan graf dengan 8 node yang mewakili a1, a2, a3, a4, a5, a6, a7 , a8 (tentukan sendiri nilai hubungan antar node). 
// Lakukan pencarian angka n pada graf tersebut dengan BFS.
// Jelaskan tahap demi tahap proses pencarian dan gambarkan dengan rinci prosesnya. 


import java.util.LinkedList;
import java.util.Iterator;
import java.util.Scanner;

public class BFSGraph {

    static class Graph {

        private int V;
        private LinkedList<Integer> adj[];
        private int[] values;
        private String[] names;

        Graph(int v, int[] values, String[] names) {
            V = v;
            this.values = values;
            this.names = names;
            adj = new LinkedList[v];
            for (int i = 0; i < v; ++i) {
                adj[i] = new LinkedList<Integer>();
            }
        }

        void addEdge(int v, int w) {
            adj[v].add(w);
        }

        void BFS(int s, int key) {
            boolean visited[] = new boolean[V];
            LinkedList<Integer> queue = new LinkedList<Integer>();
            visited[s] = true;
            queue.add(s);
            boolean found = false;
            while (queue.size() != 0) {
                int v = queue.poll();
                System.out.println("Kunjungi " + names[v] +
                        " (vertex " + v + ", nilai = " + values[v] + ")");
                if (values[v] == key) {
                    System.out.println(">> DITEMUKAN: nilai " + key +
                            " pada node " + names[v] + " (vertex " + v + ")");
                    found = true;
                    break;
                }
                Iterator<Integer> i = adj[v].listIterator();
                while (i.hasNext()) {
                    int n = i.next();
                    if (!visited[n]) {
                        visited[n] = true;
                        queue.add(n);
                    }
                }
            }
            if (!found) {
                System.out.println(">> NILAI " + key + " tidak ditemukan di graf.");
            }
        }
    }

    public static void main(String args[]) {
        String[] names = {
                "a1", "a2", "a3", "a4",
                "a5", "a6", "a7", "a8"
        };

        int[] values = {
                10, 5, 12, 7,
                25, 30, 18, 40
        };

        int V = 8;
        Graph g = new Graph(V, values, names);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 5);
        g.addEdge(4, 6);
        g.addEdge(4, 7);

        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan angka n yang ingin dicari (BFS): ");
        int key = sc.nextInt();

        System.out.println("\nBFS dari node a1 (vertex 0):");
        g.BFS(0, key);

        sc.close();
    }
}
