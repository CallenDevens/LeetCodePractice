class Solution {
	
	char EMPTY_PLACEHOLDER_CHAR = '.';//a constant to avoid typos.. my solution was wrong becuase I typed a comma not dot when removing a number

    int n = 3; //9 small square box size (3*3)
    int N = 9; //board size;(9*9)
    int [][] rows = new int [N][N+1]; //[rowIndex][1~9] (N+1) to spare space for 9
    int [][] columns = new int [N][N+1]; //[colIndex][1~9] same as above
    int [][] boxes = new int[N][N+1]; // [boxIndex(0~8)][1~9] same as above
    
    char [][] board;
    
    boolean sudokuSolved = false;// find only one solution
    
    public void solveSudoku(char[][] board) {
        this.board = board;
        
		//fill boxes with the given board;
        for(int i = 0 ; i < N; i++){
            for(int j = 0; j < N; j++){
                if(board[i][j] != EMPTY_PLACEHOLDER_CHAR){
                    int d = Character.getNumericValue(board[i][j]);
                    placeNumber(d, i, j);
                }
            }
        }
        
        backtrack(0, 0);
        
    }
    
    public void placeNumber(int d, int row, int col){
        int boxId = this.getBoxId(row, col);
        
        //valid range [0~1]
        rows[row][d]++;
        columns[col][d]++;
        boxes[boxId][d]++;
        board[row][col] = (char)(d + '0');
    }
    
    public int getBoxId(int col, int row){
        //(box row *boxPerline) + box column
        return (row / n) * n + col / n;
    }
    
    public void backtrack(int row, int col){

        //place the number for this and next 
        if(this.board[row][col] == EMPTY_PLACEHOLDER_CHAR){
            for(int d = 1; d < 10; d++){
                if(couldPlaceNumber(d, row, col)){
                    placeNumber(d, row, col); 
                    placeNextNumber(row, col);
                    
                    //soduku not solved means current d is not part of the correct solution, remove this number and try next
                    if(!sudokuSolved){ removeNumber(d, row, col);}
                }
            }
            
        }else{
            placeNextNumber(row, col);
        }
    }
    
    public void placeNextNumber(int row, int col){
        if(row == N - 1 && col == N - 1){
            sudokuSolved = true;
        }else if(col == N -1){
            backtrack(row + 1, 0);
        }else{
            backtrack(row, col + 1);
        }
    }
    
    public void removeNumber(int d, int row, int col){
        int boxId = this.getBoxId(row ,col);
        
        rows[row][d]--;
        columns[col][d]--;
        boxes[boxId][d]--;
        board[row][col] = EMPTY_PLACEHOLDER_CHAR;
    }
    
    public boolean couldPlaceNumber(int d,int row, int col){
        int boxId = this.getBoxId(row, col);
        return rows[row][d]==0&& columns[col][d]==0 && boxes[boxId][d] == 0; //the d doesn't break the rule of sukodu on row. column and its inner box
    }
        
}