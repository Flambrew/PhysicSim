package src;

public class Main {
    public static void main(String[] args) {
        int x = 0, y = 0;
        int width = 10, height = 10, precision = 25; // n > 0
        double angle = 45; // 0 < n < 90
        double velocity = 10; // n > 0

        double[][] axes = new double[4 * precision + 2][2];
        for (int i = 0; i < 4 * precision + 1; i++)
            axes[i] = new double[] { x + width * i / (4 * precision + 1.), y + height * i / (4 * precision + 1.) };
            
        boolean[][] greater = new boolean[axes.length][axes.length];
        for (int i = 0; i < greater.length; i++)
            for (int j = 0; j < greater.length; j++)
                greater[greater.length - i - 1][j] = 0 > 4.9 * Math.pow(axes[j][0] / velocity / Math.cos(angle), 2)
                        - axes[j][0] * Math.tan(angle) + axes[i][1];

        draw(greater);
    }

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