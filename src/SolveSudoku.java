public class SolveSudoku {

    public static void main(String args[]){

    }


    public void solveSudoku(char[][] board) {

        solvePartialSudoku(0,0,board);


    }
    private static final char  EMPTY_ENTRY = '.';

    private static boolean solvePartialSudoku(int i, int j, char[][] board){
        if(i == board.length){
            i = 0;
            if(++j == board[i].length){
                return true;
            }
        }

        if(board[i][j] != EMPTY_ENTRY){
            return solvePartialSudoku(i+1, j , board);
        }

        for(int val=1;val <= board.length;val++){

            char c = (char)(val+'0');
            if(validToAddVal(board,i,j,c)){
                board[i][j] = c;
                if(solvePartialSudoku(i+1,j,board)){

                    return true;

                }
            }
        }

        board[i][j] = EMPTY_ENTRY;

        return false;

    }
    private static boolean validToAddVal(char[][] board, int i, int j, char val){

        for(char[] element : board){
            if(val == element[j]){  // Row 
                return false;
            }
        }

        for(int k=0;k<board.length;++k){
            if(val == board[i][k]){     // Column
                return false;
            }
        }

        int regionSize = (int)Math.sqrt(board.length);
        int I = i/ regionSize, J = j / regionSize;
        for(int a=0;a<regionSize;++a){
            for(int b=0;b<regionSize;++b){

                if(val == board[regionSize * I + a][regionSize * J + b]){
                    return false;
                }
            }

        }
        return true;
    }
}