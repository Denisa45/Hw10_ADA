/*
prim starts from a node and look for vertex
Kurtal only work with edges based on minimum wheight
       choose the min edges so it doesnt have any cycles
                     to proof cycles if they belong to the same tree
                     lists of lists with the node , when union a with b , b goes into a's list
                     array of parents , and when make union update the parents
                    implementation with parent references

                    trees
                    arrays
                    and measure the time
 */


import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
       /*  int V=10;
        int E=5;
        Random rand = new Random();

        File output= new File("graph_input.txt");
        FileWriter writer= new FileWriter(output);

        writer.write(V + " " + E + "\n"); // Write both V and E
        for(int v=0; v<E; v++) {
            int i = rand.nextInt(V);
            int j = rand.nextInt(V);
            while(i==j) {
                j = rand.nextInt(V);
            }
            int weight=rand.nextInt(100);
            writer.write(i+" "+j+" "+weight+"\n");

        }*/

        IWeightedGraph graph = new WeightedGraphAdjList("C:\\Users\\DELL\\Desktop\\sem_2\\ADA\\LECTURE\\week_10\\src\\mario_input_file.txt");
        int V = graph.getNrVertices();
        int E = graph.getNrEdges();
        KruskalMST kruskal = new KruskalMST();

        IUnionFind TreeBased= new UnionFindUpForest(V);
        IUnionFind ArrayBased = new UnionFindUpArray(V);

        System.out.println("Using UnionFindUpArray:");
        long start1 = System.currentTimeMillis();
        kruskal.mstEdgeList(graph, ArrayBased);
        long end1 = System.currentTimeMillis();
        System.out.println("Time: " + (end1 - start1) + " ms");

        System.out.println("\nUsing UnionFindUpForest:");
        long start2 = System.currentTimeMillis();
        kruskal.mstEdgeList(graph, TreeBased);
        long end2 = System.currentTimeMillis();
        System.out.println("Time: " + (end2 - start2) + " ms");

    }
}
