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
