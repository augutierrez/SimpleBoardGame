import java.util.*;
import java.io.*;

public class Driver
{
	public static void main(String[] args) throws FileNotFoundException {
        boolean again = true;
        Scanner scanner = new Scanner(System.in);
        while (again) {
            int done = 0;
            Table board = new Table();
            board.setValues();

            //reading input file
            ArrayList<String> file = new ArrayList<String>();
            Scanner scan = new Scanner(new File("input.txt"));
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] string = line.split(" ");
                for (int x = 0; x < string.length; x++) {
                    file.add(string[x]);
                }
            }
            //checks for adding pieces cue.
            String name;
            for (int x = 0; x < file.size(); x++) {
                if (file.get(x).equals("pawn")) {
                    if (file.get(x + 3).equals("w")) {
                        name = " -p-";
                    } else {
                        name = " -P-";
                    }
                    board.addPiece(Integer.parseInt(file.get(x + 1)), Integer.parseInt(file.get(x + 2)), name);

                }
                if (file.get(x).equals("knight")) {
                    if (file.get(x + 3).equals("w")) {
                        name = " -h-";
                    } else {
                        name = " -H-";
                    }
                    board.addPiece(Integer.parseInt(file.get(x + 1)), Integer.parseInt(file.get(x + 2)), name);

                }
                if (file.get(x).equals("bishop")) {
                    if (file.get(x + 3).equals("w")) {
                        name = " -b-";
                    } else {
                        name = " -B-";
                    }
                    board.addPiece(Integer.parseInt(file.get(x + 1)), Integer.parseInt(file.get(x + 2)), name);

                }
                if (file.get(x).equals("rook")) {
                    int check = x + 3;
                    if (file.get(check).equals("w")) {
                        name = " -r-";
                    } else {
                        name = " -R-";
                    }
                    board.addPiece(Integer.parseInt(file.get(x + 1)), Integer.parseInt(file.get(x + 2)), name);

                }
                if (file.get(x).equals("king")) {
                    int check = x + 3;
                    if (file.get(check).equals("w")) {
                        name = " -k-";
                    } else {
                        name = " -K-";
                    }
                    board.addPiece(Integer.parseInt(file.get(x + 1)), Integer.parseInt(file.get(x + 2)), name);

                }
                if (file.get(x).equals("queen")) {
                    int check = x + 3;
                    if (file.get(check).equals("w")) {
                        name = " -q-";
                    } else {
                        name = " -Q-";
                    }
                    board.addPiece(Integer.parseInt(file.get(x + 1)), Integer.parseInt(file.get(x + 2)), name);

                }
            }
            //checks for move cue
            //loops until a king is killed
            while (board.game()) {

                if (done == 0) {
                    board.showTable();
                    done = 1;
                }
                // user input, source of piece, desired move location for piece
                System.out.println("What is the x value of the piece you want to move?");
                int a = scanner.nextInt();
                System.out.println("What is the y value of the piece you want to move?");
                int b = scanner.nextInt();
                System.out.println("What is the x value of where you want to move?");
                int c = scanner.nextInt();
                System.out.println("What is the y value of where you want to move?");
                int d = scanner.nextInt();
                String piece = board.getPiece(a, b);

                if (piece.equals("no piece")) {
                    System.out.println("No piece picked up!");
                }
                //checks for valid pawn move
                if (piece.equals("pawn")) {
                    Pawn pawn = new Pawn(a, b);
                    pawn.setWhite();
                    boolean realMove = pawn.move(c, d);
                    if (realMove == true) {
                        board.tableMove(a, b, c, d);

                        System.out.println();

                    } else {
                        System.out.println("Invalid Board Position. (" + a + "," + b + ") (" + c + "," + d + ")");
                    }
                    //checks for valid black pawn move
                } else if (piece.equals("black pawn")) {
                    Pawn pawn = new Pawn(a, b);
                    boolean realMove = pawn.move(c, d);
                    if (realMove == true) {
                        board.tableMove(a, b, c, d);

                        System.out.println();

                    } else {
                        System.out.println("Invalid Board Position. (" + a + "," + b + ") (" + c + "," + d + ")");
                    }

                }
                //checks for valid knight move
                if (piece.equals("knight")) {
                    Knight knight = new Knight(a, b);
                    knight.setWhite();
                    boolean realMove = knight.move(c, d);
                    if (realMove == true) {
                        board.tableMove(a, b, c, d);

                        System.out.println();

                    } else {
                        System.out.println("Invalid Board Position. (" + a + "," + b + ") (" + c + "," + d + ")");
                    }
                }
                //checks for valid black knight move
                if (piece.equals("black knight")) {
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
                    bishop.setWhite();
                    boolean realMove = bishop.move(c, d);
                    if (realMove == true) {
                        board.tableMove(a, b, c, d);

                        System.out.println();

                    } else {
                        System.out.println("Invalid Board Position. (" + a + "," + b + ") (" + c + "," + d + ")");
                    }
                }
                // checks for valid black bishop move
                if (piece.equals("black bishop")) {
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
                    rook.setWhite();
                    boolean realMove = rook.move(c, d);
                    if (realMove == true) {
                        board.tableMove(a, b, c, d);

                        System.out.println();

                    } else {
                        System.out.println("Invalid Board Position. (" + a + "," + b + ") (" + c + "," + d + ")");
                    }
                }
                //checks for valid black rook move
                if (piece.equals("black rook")) {
                    Rook rook = new Rook(a, b);
                    boolean realMove = rook.move(c, d);
                    if (realMove == true) {
                        board.tableMove(a, b, c, d);

                        System.out.println();

                    } else {
                        System.out.println("Invalid Board Position. (" + a + "," + b + ") (" + c + "," + d + ")");
                    }
                }
                // checks for valid queen move
                if (piece.equals("queen")) {
                    Queen queen = new Queen(a, b);
                    queen.setWhite();
                    boolean realMove = queen.move(c, d);
                    if (realMove == true) {
                        board.tableMove(a, b, c, d);

                        System.out.println();

                    } else {
                        System.out.println("Invalid Board Position. (" + a + "," + b + ") (" + c + "," + d + ")");
                    }
                }
                // checks for valid black queen move
                if (piece.equals("black queen")) {
                    Queen queen = new Queen(a, b);
                    boolean realMove = queen.move(c, d);
                    if (realMove == true) {
                        board.tableMove(a, b, c, d);

                        System.out.println();

                    } else {
                        System.out.println("Invalid Board Position. (" + a + "," + b + ") (" + c + "," + d + ")");
                    }
                }
                //checks for valid king move
                if (piece.equals("king")) {
                    King king = new King(a, b);
                    king.setWhite();
                    boolean realMove = king.move(c, d);
                    if (realMove == true) {
                        board.tableMove(a, b, c, d);

                        System.out.println();

                    } else {
                        System.out.println("Invalid Board Position. (" + a + "," + b + ") (" + c + "," + d + ")");
                    }
                }
                //checks for valid black king move
                if (piece.equals("black king")) {
                    King king = new King(a, b);
                    boolean realMove = king.move(c, d);
                    if (realMove == true) {
                        board.tableMove(a, b, c, d);

                        System.out.println();

                    } else {
                        System.out.println("Invalid Board Position. (" + a + "," + b + ") (" + c + "," + d + ")");
                    }
                }
            }
            // find out if player wants to play again
            System.out.println("Want to play again? 1) no 2) yes");
            int decision = scanner.nextInt();
            if (decision != 2){
                again = false;
            }
        }
    }
    }