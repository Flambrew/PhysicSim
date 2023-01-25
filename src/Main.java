package src;

public class Main {
    public static void main(String[] args) {
        boolean[][] array = {
            {true,  true,  true,  true,  true,  true,  true,  true,  true,  true  },
            {true,  true,  true,  true,  true,  true,  true,  true,  true,  true  },
            {true,  true,  true,  true,  true,  true,  true,  true,  true,  true  },
            {true,  false, false, false, true,  true,  true,  true,  true,  true  },
            {false, false, false, false, false, false, true,  true,  true,  true  },
            {false, false, false, false, false, false, false, true,  true,  true  },
            {false, false, false, false, false, false, false, false, true,  true  },
            {false, false, false, false, false, false, false, false, true,  true  },
            {false, false, false, false, false, false, false, false, false, true  },
            {false, false, false, false, false, false, false, false, false, true  }
        };


        Draw.draw(array);
    }
}