#include<iostream>
using namespace std;

char board[3][3] = {{'1', '2', '3'}, {'4', '5', '6'}, {'7','8', '9' }};
bool draw = false;
char turn = 'X';
void boards(){
    
    cout <<"\t\t\t\t\t" "     |     |     \n";
    cout <<"\t\t\t\t\t""  "<<board[0][0]<<"  |  "<<board[0][1]<<"  |  " <<board[0][2]<<" \n";
    cout << "\t\t\t\t\t""_____|_____|_____\n";
    cout <<"\t\t\t\t\t" "     |     |     \n"; 
    cout <<"\t\t\t\t\t""  "<<board[1][0]<<"  |  "<<board[1][1]<<"  |  " <<board[1][2]<<" \n";
    cout << "\t\t\t\t\t""_____|_____|_____\n";
    cout <<"\t\t\t\t\t" "     |     |     \n";
    cout <<"\t\t\t\t\t""  "<<board[2][0]<<"  |  "<<board[2][1]<<"  |  " <<board[2][2]<<" \n";
    cout <<"\t\t\t\t\t" "     |     |     \n\n\n\n";
}
void play(){
    int choice;
    if(turn=='X')
        cout << "\n player[X] turn:";
    else
    {
        /* code */
         cout << "\n player[O] turn:";
    }
    


    cin >> choice;
    int row, col;
    switch(choice){
        case 1:
            row = 0, col = 0;
            break;
         case 2:
            row = 0, col = 1;
            break;
         case 3:
            row = 0, col = 2;
            break;
         case 4:
            row = 1, col = 0;
            break;
         case 5:
            row = 1, col = 1;
            break;
         case 6:
            row = 1, col = 2;
            break;

         case 7:
            row = 2, col = 0;
            break;
         case 8:
            row = 2, col = 1;
            break;
         case 9:
            row = 2, col = 2;
            break;
        default:
            cout << "INVALID";
            play();
            break;

    }
    if(turn=='X'&& board[row][col]!='X' && board[row][col]!='O' ){
        board[row][col] = 'X';
        turn = 'O';

    }
    else if(turn=='O'&& board[row][col]!='X' && board[row][col]!='O'){
        board[row][col] = 'O';
        turn = 'X';

    }
    else
    {
        cout << "BOX ALREADY FILLED\n";
        cout << "Please try Again!\n\n";
        play();
    }
   boards();  



}
bool gameover(){

    for (int i = 0; i < 3;i++)
    if((board[i][0]==board[i][1] && board[i][1]==board[i][2])||(board[0][i]==board[1][i] && board[2][i]==board[1][i]))
        return true;

for (int i = 0; i < 3;i++)
    if((board[0][0]==board[1][1] && board[1][1]==board[2][2])||(board[0][2]==board[1][1] && board[2][0]==board[1][1]))
        return true;

    


    for (int i = 0; i < 3;i++)
        for (int j = 0; j < 3;j++)
        if(board[i][j]!='X'&& board[i][j]!='O')
            return false;

    draw = true;
    return true;

}

int main(){
    cout << "WELCOME!!!\n";
    cout << "\t\t\t\t\tTICK CROSS GAME\n\n";
    cout << "player[x]\n";
    cout << "player[O]\n";
    while(!gameover()){
    boards();
    play();
   
    }
    if(turn=='X' && draw==false)
        cout << "Player[O] Won!...Congratulations!!\n\n";
    else if(turn=='O' && draw==false)
    cout << "Player[X] Won!...Congratulations!!\n\n";
    else
    {
        cout << "GAME DRAW!!\n\n";
    }
    
            return 0;
}