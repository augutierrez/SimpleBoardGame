
import java.lang.*;
public class Table
{
    //chess board
	private String[][] table = new String [9][9];

	public void setValues()
	{
		// fresh board
		for (int y = 0; y < 8; y++)
		{
		table [y][0] = "=" + (7 - y) + "=";
		table [8][y+1] = " =" + y + "=";
		}

		for (int y = 0; y <= 7; y ++)
		{
			System.out.println();
			for (int x = 1; x <= 8; x++)
			{
				table[y][x] = " ---";
			}
		}
		table[8][0] = "===";


	}

	//returns piece at certain coordinate
	public String getPiece(int x, int y){
	    if (table[7-y][x+1].equals(" -p-"))
	        return "pawn";
        if (table[7-y][x+1].equals(" -h-"))
            return "knight";
        if (table[7-y][x+1].equals(" -b-"))
            return "bishop";
        if (table[7-y][x+1].equals(" -r-"))
            return "rook";
        else
            return "no piece";
    }

// adds piece to the chessboard
	public void addPiece(int x , int y, String piece)
	{
		table[7-y][x+1] = piece;


	}
// moves piece existing on chessboard
	public void tableMove(int x, int y, int a , int b)
	{
		String name = table[7-y][x+1];
		boolean inside = inTable(a, b);
		boolean free = freePath(x,y,a,b);
		String pieceName = getPiece(x, y);
        if (inside == true) {
            if (free == true) {
                table[7 - y][x + 1] = " ---";
                table[7 - b][a + 1] = name;
                System.out.println( pieceName + ": (" + x + "," + y + ")" + " (" + a + "," + b + ")");
                System.out.println("Moved!"  + ": (" + x + "," + y + ")" + " (" + a + "," + b + ")");
                System.out.println("====================");
                showTable();
            }
            else{
                System.out.println("Invalid Board Position. (" + x + "," + y + ") (" + a + "," + b + ")");
            }
        }
        else{
            System.out.println("Invalid Board Position. (" + x + "," + y + ") (" + a + "," + b + ")");
        }
	}
// checks to see if there are pieces on moving piece's path
    private boolean freePath(int x, int y, int a, int b)
    {
        boolean free = true;

        try {
            PathwayException exceptions = new PathwayException();
            //for pawn
            if (table[7 - y][x + 1].equals(" -p-")) {
                if (b - y > 0) {
                    for (int c = y + 1; c <= b; c++) {
                        if (table[7 - c][x + 1] != " ---") {
                            throw exceptions;
                        }
                    }
                }
                if (b - y < 0) {
                    for (int d = y - 1; d > b; d--) {
                        if (table[7 - d][x + 1] != " ---") {
                            throw exceptions;
                        }
                    }
                }
            }
            //bishop code
            else if (table[7 - y][x + 1].equals(" -b-")) {
                // four different ways
                if (a - x > 0) {
                    int distance = b - y;
                    if (distance > 0) {
                        for (int count = 1; count < distance; count++) {
                            if (table[(7 - y - count)][x + 1 + count] != " ---") {
                                throw exceptions;
                            }
                        }
                    }
                    else if (distance < 0) {
                        for (int count = -1; count > distance; count--) {
                            if (table[7 - y - count][x + 1 + count] != " ---") {
                                throw exceptions;
                            }
                        }
                    }
                } else{
                    int distance = b - y;
                    if (distance > 0) {
                        for (int count = 0; count < distance; count++) {
                            if (table[(7 - y - count)][x + 1 + count] != " ---") {
                                throw exceptions;
                            }
                        }
                    } else if (distance < 0) {
                        for (int count = 0; count > distance; count--) {
                            if (table[7 - y - count][x + 1 + count] != " ---") {
                                throw exceptions;
                            }
                        }
                    }
                }
                //rook code
            } else if (table[7 - y][x + 1].equals(" -r-")) {
                //4 ways
                //up down, or left and right.
                if (a - x == 0){
                    if (b - y > 0) {
                        for (int count = y + 1; count < b; count++){
                            if (table[7-count][x+1] != " ---"){
                                throw exceptions;
                            }
                        }
                    }
                    else {
                        for (int count = y - 1; count > b; count--){
                            if  (table[7-count][x+1] != " ---"){
                                throw exceptions;
                            }
                        }
                    }
                }
                else {
                    if (a - x > 0){
                        for (int count = x + 1; count < a; count++){
                            if (table[7-y][count + 1] != " ---"){
                                throw exceptions;
                            }
                        }
                    }
                    else{
                        for (int count = x - 1; count > a; count--){
                            if (table[7-y][count + 1] != " ---"){
                                throw exceptions;
                            }
                        }
                    }
                }
            }

            //horse code
            else if (table[7-y][x + 1].equals(" -h-")){
                if (table[7- b][a + 1] != " ---"){
                        throw exceptions;
                }
            }
        }

        catch (PathwayException exceptions){
            free = false;
        }
        return free;
    }
// boolean that makes sure move is within table boundaries
    public boolean inTable(int x, int y)
    {
        boolean inside = true;
        try {
            OutOfBoardException exception = new OutOfBoardException();
            if (x > 7) {
                throw exception;
            }
            if (x < 0) {
                throw exception;
            }
            if (y > 7) {
                throw exception;
            }
            if (y < 0) {
                throw exception;
            }
        }

        catch (OutOfBoardException exception) {
            inside = false;
        }
        return inside;
    }
// displays working chess table
	public void showTable()
	{

		for (int y = 0; y <= 8; y ++)
		{
			System.out.println();
			for (int x = 0; x <= 8; x++)
			{
				System.out.print(table[y][x]);
			}
		}
		System.out.println();
	}
}