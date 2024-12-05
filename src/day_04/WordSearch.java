package day_04;

public class WordSearch {
    LetterGrid letterGrid;

    public WordSearch(LetterGrid letterGrid) {
        this.letterGrid = letterGrid;
    }

    public boolean checkDirection(String word, int row, int column, int rowDelta, int columnDelta) {
        int wordLength = word.length();

        for(int i = 0; i < wordLength; i++) {
            int newRow = row + i * rowDelta;
            int newColumn = column + i * columnDelta;

            if(newRow < 0 || newRow >= letterGrid.getRows() ||
                newColumn < 0 || newColumn >= letterGrid.getColumns()) {
                return false;
            }

            if(letterGrid.getCharAt(newRow, newColumn) != word.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public int countXMASOccurrences() {
        int count = 0;

        for (int row = 1; row < letterGrid.getRows() - 1; row++) {
            for (int col = 1; col < letterGrid.getColumns() - 1; col++) {
                if (isXMASPattern(row, col)) {
                    count++;
                }
            }
        }

        return count;
    }

    public boolean isXMASPattern(int row, int col) {
        String diagonal1 = "" + letterGrid.getCharAt(row - 1, col - 1) + letterGrid.getCharAt(row, col) + letterGrid.getCharAt(row + 1, col + 1);
        String diagonal2 = "" + letterGrid.getCharAt(row + 1, col - 1) + letterGrid.getCharAt(row, col) + letterGrid.getCharAt(row - 1, col + 1);

        return (isMAS(diagonal1) && isMAS(diagonal2));
    }

    public boolean isMAS(String word) {
        return word.equals("MAS") || word.equals("SAM");
    }

    public int countOccurrences(String word) {
        int rows = letterGrid.getRows();
        int columns = letterGrid.getColumns();

        int[][] directions = {
                {0, 1}, // horizontal right
                {0, -1}, // horizontal left
                {1, 0}, // vertical down
                {-1, 0}, // vertical up
                {1, 1}, // diagonal: down, right
                {1, -1}, // diagonal: down, left
                {-1, -1}, // diagonal: up, left
                {-1, 1}, // diagonal: up, right
        };

        int count = 0;

        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < columns; col++) {
                for(int[] dir : directions) {
                    if(checkDirection(word, row, col, dir[0], dir[1])) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
