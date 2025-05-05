package daynamic_programin;

import java.util.ArrayList;
import java.util.List;

public class SolveNQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result =new ArrayList<>();
        char[][] board =new char[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j]='.';
            }
        }
        solve(0, n, board, result);
        return result;
    }

    private boolean isSafe(int row, int col, int n, char[][] board){ //current row, current col, total col, board
        for(int i=0; i< row; i++){
            if(board[i][col] =='Q') return false;
        }

        for(int i=row, j=col; i>=0 && j>=0; i--, j-- ){
            if(board[i][j] =='Q') return false;
        }

        for(int i=row, j=col; i>=0 && j<n; i--,j++){
            if(board[i][j] =='Q') return false;
        }
        return true;
    }

    private void solve(int row, int n, char[][] board, List<List<String>> result ){
        if(row == n){
            List<String> currentBoard =new ArrayList<>();
            for(int i=0; i<board.length;i++){
                String curr="";
                for(int j=0; j< board[i].length;j++){
                    curr +=board[i][j];
                }
                currentBoard.add(curr);
            }
            result.add(currentBoard);
        }
        for(int col=0; col<n; col++){
            if(isSafe(row, col, n, board)){
                board[row][col] ='Q';
                solve(row+1,n, board, result);
                board[row][col]='.';
            }
        }
    }
    public static void main(String[] args) {
        SolveNQueens solveNQueens = new SolveNQueens();
        System.out.println(solveNQueens.solveNQueens(4));
    }
}
