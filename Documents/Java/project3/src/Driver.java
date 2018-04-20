import java.util.*;
import java.io.*;

public class Driver
{




	public static void main(String[] args) throws FileNotFoundException{
	    int done = 0;
		Table board = new Table();
		board.setValues();

		//reading input file
        ArrayList<String> file = new ArrayList<String>();
        Scanner scan = new Scanner(new File("input.txt"));
        while (scan.hasNextLine()){
            String line = scan.nextLine();
            String[] string = line.split(" ");
            for(int x = 0; x < string.length; x++) {
                file.add(string[x]);
            }
        }
        //checks for adding pieces cue.
        for (int x= 0; x < file.size(); x++){
            if (file.get(x).equals("pawn")){
                board.addPiece( Integer.parseInt(file.get(x+1)) , Integer.parseInt(file.get(x+2)), " -p-");

            }
            if (file.get(x).equals("knight")){
                board.addPiece(Integer.parseInt(file.get(x + 1)), Integer.parseInt(file.get(x+2)), " -h-");

            }
            if (file.get(x).equals("bishop")){
                board.addPiece(Integer.parseInt(file.get(x + 1)), Integer.parseInt(file.get(x+2)), " -b-");

            }
            if (file.get(x).equals("rook")){
                board.addPiece(Integer.parseInt(file.get(x + 1)), Integer.parseInt(file.get(x+2)), " -r-");

            }
            //checks for move cue
            if (file.get(x).equals("move")){

                if (done == 0){
                    board.showTable();
                    done = 1;
                }
                int a = Integer.parseInt(file.get(x+1));
                int b = Integer.parseInt(file.get(x+2));
                int c = Integer.parseInt(file.get(x+3));
                int d = Integer.parseInt(file.get(x+4));
                String piece = board.getPiece(a, b);
                //checks for valid pawn move
                if (piece.equals("pawn")){
                    Pawn pawn = new Pawn(a, b);
                    boolean realMove = pawn.move(c, d);
                    if (realMove == true){
                        board.tableMove(a, b, c, d);

                        System.out.println();

                    }
                    else {
                        System.out.println("Invalid Board Position. (" + a + "," + b + ") (" + c + "," + d + ")");
                    }
                }
                //checks for valid knight move
                if (piece.equals("knight")) {
                    Knight knight = new Knight(a, b);
                    boolean realMove = knight.move(c, d);
                    if (realMove == true) {
                        board.tableMove(a, b, c, d);

                        System.out.println();

                    } else {
                        System.out.println("Invalid Board Position. (" + a + "," + b + ") (" + c + "," + d + ")");
                    }
                }
                //checks for valid bishop move
                if (piece.equals("bishop")) {
                    Bishop bishop = new Bishop(a, b);
                    boolean realMove = bishop.move(c, d);
                    if (realMove == true) {
                        board.tableMove(a, b, c, d);

                        System.out.println();

                    } else {
                        System.out.println("Invalid Board Position. (" + a + "," + b + ") (" + c + "," + d + ")");
                    }
                }
                //checks for valid rook move
                if (piece.equals("rook")) {
                    Rook rook = new Rook(a, b);
                    boolean realMove = rook.move(c, d);
                    if (realMove == true) {
                        board.tableMove(a, b, c, d);

                        System.out.println();

                    } else {
                        System.out.println("Invalid Board Position. (" + a + "," + b + ") (" + c + "," + d + ")");
                    }
                }

            }
        }
        }
    }



