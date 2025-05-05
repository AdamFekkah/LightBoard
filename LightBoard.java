public class LightBoard {
    private boolean[][] lights;

    /** Constructs a LightBoard object with numRows and numCols lights.
     *  Each light is turned on with 40% probability.
     */
    public LightBoard(int numRows, int numCols) {
        lights = new boolean[numRows][numCols];

        for (int r = 0; r < lights.length; r++) {
            for (int c = 0; c < lights[0].length; c++) {
                if (Math.random() < 0.4) {
                    lights[r][c] = true;
                }
            }
        }
    }

    /** For testing with specific configurations */
    public void setLights(boolean[][] arr) {
        lights = arr;
    }

    /** Returns whether the light should be on or off based on special rules */
    public boolean evaluateLight(int row, int col) {
        boolean light = lights[row][col];
        int colLights = 0;

        for (int r = 0; r < lights.length; r++) {
            if (lights[r][col]) {
                colLights++;
            }
        }

        if (light && colLights % 2 == 0) {
            return false;
        }

        if (!light && colLights % 3 == 0) {
            return true;
        }

        return light;
    }

    /** Returns the proportion of lights that are on */
    public double test() {
        double on = 0;

        for (boolean[] row : lights) {
            for (boolean b : row) {
                if (b) on++;
            }
        }

        return on / (lights.length * lights[0].length);
    }
}
