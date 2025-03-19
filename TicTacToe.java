 //i need a matrix to store the value of x and o
//i need to print the matrix
//check diagnol, check tie, check overwrite

import java.util.*;



class TicTacToe 
{
    public static int check(int player, int[][] matrix){


        for(int i=0;i<3;i++){
            if(matrix[i][0] == player && matrix[i][1]==player && matrix[i][2]==player)
            return 1;

            else if(matrix[0][i] == player && matrix[1][i]==player && matrix[2][0]==player)
            return 1;
            
            else if(matrix[0][0] == player && matrix[1][1]==player && matrix[2][2]==player)
            return 1;

            else if(matrix[0][2] == player && matrix[1][1]==player && matrix[2][0]==player)
            return 1;

        }
        return 0;
    }
    public static void main(String args[]){
        //created a 2d matrix
        int[][] matrix= new int[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
            matrix[i][j]=-1;
            System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        //now get input from 2 users alternatively
        int player1=0;
        int player2=1;
       // System.out.print("player1 : " + player1 + " player2 : "+ player2);
       Scanner scanner = new Scanner(System.in);
       for(int i=0;i<9;i++){
        if(i%2==0)
            System.out.println("Player 1 turn, Press the board Number (0,1,2):");
            
       else
        System.out.println("Player 2 turn, Press the board Number:");
       
       
            int row=scanner.nextInt();
            int col=scanner.nextInt();
            if(i%2==0)
            matrix[row][col]=0;
            else
            matrix[row][col]=1;

        //print the updated matrix
            for(int k=0;k<3;k++){
            for(int l=0;l<3;l++){
            System.out.print(matrix[k][l] + " ");
            }
            System.out.println();
        }
        //check if any row or coloum or diagnol is filled by the same number
        int won = check(i%2,matrix);
        if(won==1)
        {
            System.out.println("player " + i%2  +"won!!!!");
            break;
        }

       }
    }
}
