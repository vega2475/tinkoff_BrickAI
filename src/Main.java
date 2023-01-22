public class Main {
    private static final int ROWS = 4;
    private static final int COLS = 4;
    private static final int[][] field = new int[ROWS][COLS];

    public static void main(String[] args) {
        String sequence = "010"; // input sequence
        for (int i = 0; i < sequence.length(); i++) {
            int brick = Integer.parseInt(sequence.charAt(i) + "");
            int[] coordinates = findEmptySpace(brick);
            if (coordinates != null) {
                System.out.println(coordinates[0] + " " + coordinates[1]);
                fillSpace(coordinates[0], coordinates[1], brick);
            } else {
                releaseFullRowsAndCols();
                coordinates = findEmptySpace(brick);
                if (coordinates != null) {
                    System.out.println(coordinates[0] + " " + coordinates[1]);
                    fillSpace(coordinates[0], coordinates[1], brick);
                } else {
                    System.out.println("No solution found for brick " + brick);
                }
            }
        }
    }

    private static int[] findEmptySpace(int brick) {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (field[i][j] == 0) {
                    if (brick == 0) { // vertical brick
                        if (i + 1 < ROWS && field[i + 1][j] == 0) {
                            return new int[] {i + 1, j + 1};
                        }
                    } else { // horizontal brick
                        if (j + 1 < COLS && field[i][j + 1] == 0) {
                            return new int[] {i + 1, j + 1};
                        }
                    }
                }
            }
        }
        return null;
    }

    private static void fillSpace(int row, int col, int brick) {
        if (brick == 0) { // vertical brick
            field[row - 1][col - 1] = 1;
            field[row][col - 1] = 1;
        } else { // horizontal brick
            field[row - 1][col - 1] = 1;
            field[row - 1][col] = 1;
        }
    }

    private static void releaseFullRowsAndCols() {
        for (int i = 0; i < ROWS; i++) {
            boolean fullRow = true;
            for (int j = 0; j < COLS; j++) {
                if (field[i][j] == 0) {
                    fullRow = false;
                    break;
                }
            }
            if (fullRow) {
                for (int j = 0; j < COLS; j++) {
                    field[i][j] = 0;
                }
            }
        }
        for (int j = 0; j < COLS; j++) {
            boolean fullCol = true;
            for (int i = 0; i < ROWS; i++) {
                if (field[i][j] == 0) {
                    fullCol = false;
                    break;
                }
            }
            if (fullCol) {
                for (int i = 0; i < ROWS; i++) {
                    field[i][j] = 0;
                }
            }
        }
    }
}


