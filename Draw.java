package src;

public class Draw {
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