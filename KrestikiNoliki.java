/**
 * Created by andrey on 07.03.2016.
 */
public class KrestikiNoliki {
    private char[][] field;
    private char nextmove;
    private int movecount;

    public KrestikiNoliki() {
        field = new char[4][4];
        movecount = 0;
        nextmove = 'O';

        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                field[i][j] = '_';
            }
        }
    }

    void displayField(){
        System.out.println("  1 2 3");

        for (int i = 1; i < 4; i++) {
            System.out.println(Integer.toString(i)+ " " + String.valueOf(field[i][1]) + " " +
                               String.valueOf(field[i][2]) + " " + String.valueOf(field[i][3]));
        }
        System.out.println();
    }

    boolean setMove(int rawcoord){
        int rowcoord = rawcoord%10, colcoord = rawcoord/10;

        if (field[colcoord][rowcoord] == '_') {
            if (nextmove == 'O') {
                field[colcoord][rowcoord] = 'O';
                nextmove = 'X';
                movecount++;
                return true;
            } else {
                field[colcoord][rowcoord] = 'X';
                nextmove = 'O';
                movecount++;
                return true;
            }
        } else {
            System.out.print("This cell is already used! Try again: ");
            return false;
        }
    }

    char getNextMove() {
        return nextmove;
    }

    void checkWinner() {
        for (int i = 1; i < 4; i++){
            if ( (field[i][1] == field[i][2]) && (field[i][2] == field[i][3]) ) {
                if (field[i][1] == 'O'){
                    System.out.print("O is won!");
                    System.exit(0);
                } else if (field[i][1] == 'X') {
                    System.out.print("X is won!");
                    System.exit(0);
                }
            }
            if ( (field[1][i] == field[2][i]) && (field[2][i] == field[3][i]) ) {
                if (field[1][i] == 'O'){
                    System.out.print("O is won!");
                    System.exit(0);
                } else if (field[1][i] == 'X') {
                    System.out.print("X is won!");
                    System.exit(0);
                }
            }
        }

        if ( ( (field[1][1] == field[2][2]) && (field[2][2] == field[3][3]) ) ||
                ( (field[1][3] == field[2][2]) && (field[2][2] == field[3][1]) ) ) {
            if (field[2][2] == 'O'){
                System.out.print("O is won!");
                System.exit(0);
            } else if (field[2][2] == 'X') {
                System.out.print("X is won!");
                System.exit(0);
            }
        }

        if (movecount > 8){
            System.out.print("Draw!");
            System.exit(0);
        }
    }

}
