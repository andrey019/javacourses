import java.util.Scanner;

public class Main {
    private static int getCoord (){
        Scanner scan = new Scanner (System.in);
        int result;

        while (true) {
            result = scan.nextInt();
            if ( (result%10<4 && result%10>0) && (result<34 && result/10>0) ) {
                return result;
            } else {
                System.out.print("Incorrect! Try again: ");
            }
        }
    }

    public static void main (String[] args){
        KrestikiNoliki mygame = new KrestikiNoliki();
        mygame.displayField();
        System.out.println("Enter the row and column like this: '13', '22', '32'");

        while (true){
            System.out.print(String.valueOf( mygame.getNextMove() ) + ", it's your move: ");
            while (!mygame.setMove( getCoord() ));
            mygame.displayField();
            mygame.checkWinner();
        }
    }
}
