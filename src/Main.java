package src;

public class Main {
    public static void main(String[] args) {

        // GRAPH PARAMETERS
        int x = 0, y = 0;
        int width = 10, height = 10, precision = 20; // n>0

        // GRAPH
        double[][] axes = new double[2][precision];
        for (int i = 0; i < precision; i++) {
            axes[0][i] = x + width * i / (double)(precision - 1);
            axes[1][i] = y + height * i / (double)(precision - 1);
        }

        // FUNCTION VALUES
        int angle = 45; // 0<n<90
        int velocity = 10; // n>0

        
    }



    // 0 = (2.21359x/vcosa)^2 - xtana + y
    // explained at: https://cdn.discordapp.com/attachments/816411343066366002/1067678178178502729/image.png

    // DRAW
    public static void draw(boolean[][] graph) {
        boolean[][] edges = getEdges(graph);
        for (int i = 0; i < edges.length; i += 4, System.out.println())
            for (int j = 0; j < edges[0].length; j += 2)
                System.out.print(parseToChar(getSection(edges, i, j, 2, 4)));
    }

    public static boolean[][] getEdges(boolean[][] graph) {
        boolean[][] points = new boolean[graph.length - 2][graph[0].length - 2];
        for (int i = 0; i < graph.length - 2; i++)
            for (int j = 0; j < graph[0].length - 2; j++)
                points[i][j] = AND(getSection(graph, i, j, 3, 3));
        return points;
    }

    public static boolean[][] getSection(boolean[][] graph, int x, int y, int w, int h) {
        boolean[][] part = new boolean[h][w];
        for (int i = 0; i < h; i++)
            for (int j = 0; j < w; j++)
                part[i][j] = graph[x + i][y + j];
        return part;
    }

    public static boolean AND(boolean[][] graph) {
        boolean allTrue = true, allFalse = true;
        for (boolean[] bs : graph)
            for (boolean b : bs)
                if (b)
                    allFalse = false;
                else
                    allTrue = false;
        return allTrue || allFalse;
    }

    public static char parseToChar(boolean[][] graph) {
        char c = '\u2800';
        c += graph[0][0] ? 1 : 0;
        c += graph[1][0] ? 2 : 0;
        c += graph[2][0] ? 4 : 0;
        c += graph[0][1] ? 8 : 0;
        c += graph[1][1] ? 16 : 0;
        c += graph[2][1] ? 32 : 0;
        c += graph[3][0] ? 64 : 0;
        c += graph[3][1] ? 128 : 0;
        return c;
    }
}