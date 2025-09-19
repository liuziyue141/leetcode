class Spreadsheet {
    int[][] spreadsheet;
    public Spreadsheet(int rows) {
        spreadsheet = new int[rows][26];
    }
    
    public void setCell(String cell, int value) {
        int[] idx = getIdx(cell);
        spreadsheet[idx[0]][idx[1]] = value;
    }
    
    public void resetCell(String cell) {
        setCell(cell, 0);
    }
    
    public int getValue(String formula) {
        String[] elem = formula.substring(1).split("\\+");
        int val1 = getCellValue(elem[0]);
        int val2 = getCellValue(elem[1]);
        return val1 + val2;
    }

    public int getCellValue(String cell){
        if(!isCell(cell)){
            return Integer.parseInt(cell);
        }

        int[] idx = getIdx(cell);
        return spreadsheet[idx[0]][idx[1]];
    }

    public int[] getIdx(String cell){
        int col = cell.charAt(0) - 'A';
        int row = Integer.parseInt(cell.substring(1)) - 1;
        return new int[]{row, col};
    }

    public boolean isCell(String cell){
        return cell.charAt(0) >= 'A' && cell.charAt(0) <= 'Z';
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */