import java.util.*;
public class player
{

    private char symbol;

    public player(char symbol)
    {
        this.symbol=symbol;
    }
    public char getSymbol(){

        return this.symbol;
    }


}


public class board
{

    private char [][] board = new char [3][3];

    
    public void initialiseBoard()
    {
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++)
            board[i][j]=' ';
           
        }
    }


    public void printBoard()
    {
        System.out.println("You are viewing the latest Board!");
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(board[i][j] + " ");               
            }
            System.out.println();
        }
    }

    public boolean checkWinner(player currentplayer)
    {
        char symbol=currentplayer.getSymbol();
                //check diagnol
                if(board[0][0]==symbol && board[1][1]==symbol && board[2][2] == symbol)
                return true;

                //check antidiagnol
                if(board[0][2]==symbol && board[1][1]==symbol && board[2][0] == symbol)
                return true;

        for(int i=0;i<3;i++){
  
                //check rowmatch
                if(board[i][0]==symbol && board[i][1]==symbol && board[i][2] == symbol)
                return true;
                //check colmatch
                if(board[0][i]==symbol && board[1][i]==symbol && board[2][i] == symbol)
                return true;
            

        }
        return false;
    }
    

    public boolean PlaceMove(int row,int col,player currentplayer)
    {
        char symbol=currentplayer.getSymbol();
        if(board[row][col]==' ' && row>=0 && row<3 && col>=0 && col<3)
        {
            board[row][col]=symbol;
            printBoard();
            return true;

        }else
        {
            System.out.println("Not a Valid Move! Try again");
            return false;
        }
    }



    
}
public class TicTacToeOops
{

    public static void main(String args[]){
        board b = new board();
        b.initialiseBoard();
        Scanner scanner = new Scanner(System.in);
        player player1 = new player('X');
        player player2 = new player('O');
        
        player currentplayer = player1;
        int i=0;
        while(i<9){

            //place move
            System.out.println("Enter values between (0,1,2):");
            int row=scanner.nextInt();
            int col=scanner.nextInt();
            while(true){
                if(b.PlaceMove(row,col,currentplayer)==false){
                                 row=scanner.nextInt();
                                 col=scanner.nextInt();
                }else
                {
                    break;
                }
            }
            if(b.checkWinner(currentplayer))
            {
               //System.out.print("Player Won!!");
               System.out.println("Player " + currentplayer.getSymbol() + " Won!!");
               return;
            }
            currentplayer = (currentplayer==player1)?player2 : player1;
            i++;
        }
        System.out.println("And Its a draw!!");
        scanner.close();
    return ;
        
    }


    
}