package easy;

class checkTicTacToeWin 
{
    public static void main(String[] args) {
        int[][] board = {
            {0, 0, 1},
            {0, 1, 1},
            {1, 0, 1}
        };
        System.out.println(hasWin(board));
        // printLeftDiagnal( board);
        // printRightDiagnal(board);
        // for(int i = 0; i < board[0].length; i++)
        // {
        //     printRow(board, i);
        // }
        // board(int i = 0; i < board[0].length; i++)
        // {
        //     printCol(board, i);
        // }
    }

    static boolean hasWin(int[][] board)
    {
        boolean colrowWin = false; 

        for(int i = 0; i<board.length; i++)
        {
            if(isWin(getRow(board, i)) || isWin(getCol(board, i)))
            {
                colrowWin = true;
                break;
            }
        }
         return isWin(getLeftDiagnal(board)) || isWin(getRightDiagnal(board)) || colrowWin;
    } 

    static int[] getLeftDiagnal(int[][] board)
    {
        int[] a  = new int[board.length];
        for(int i = 0; i<board.length; i++)
        {
            for(int j = 0; j < board.length; j++)
            {
                if(i == j)
                {
                    a[i] = board[i][j];
                    // System.out.println(board[i][j]);
                }
            }
        }
        return a;
    }

    static int[] getRightDiagnal(int[][] board)
    {
        int[] a  = new int[board.length];
        for(int i = 0; i < board.length; i++)
        {
            for(int j = board.length - 1; j>=0; j--)
            {
                if(i+j == board.length - 1)
                {
                    a[i] = board[i][j];
                    // System.out.println(board[i][j]);
                }
            }
        }
        return a;
    }

    static int[] getRow(int[][] board, int row)
    {
        int[] a = new int[board.length];
        for(int i = 0; i< board.length; i++)
        {
            a[i] = board[row][i];
            // System.out.println(board[row][i]);
        }
        return a;
    }
    static int[] getCol(int[][] board, int col)
    {
        int[] a = new int[board.length];
        for(int i = 0; i< board.length; i++)
        {
            a[i] = board[i][col];
            // System.out.println(board[i][col]);
        }
        return a;
    }
    static boolean isWin(int[] a)
    {
        for(int i : a)
        {
            if( i != 1 )
            {
                return false;
            } 
        }
        return true;
    }
}