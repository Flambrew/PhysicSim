package src;

public class Graph {

    public final double[][] axes;

    public Graph() {
        this(10, 10);
    }

    public Graph(int w, int h) {
        this(0, 0, w, h);
    }

    public Graph(int x, int y, int w, int h) {
        this(x, y, w, h, 100);
    }

    public Graph(int x, int y, int w, int h, int p) {
        if (w <= 0 || h <= 0 || p <= 0)
            throw new IllegalArgumentException("shoot");
        axes = new double[2][p];
        for (int i = 0; i < p; i++) {
            axes[0][i] = x + w * i / (double)(p - 1);
            axes[1][i] = y + h * i / (double)(p - 1);
        }
    }
}
