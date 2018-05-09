import java.util.*;
import java.lang.*;
public class Table
{
    //chess board
	private String[][] table = new String [9][9];
    boolean game = true;

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
	    if (table[7-y][x+1].equals(" -p-")) {
            return "pawn";
        }
        if (table[7-y][x+1].equals(" -P-")) {
            return "black pawn";
        }
        if (table[7-y][x+1].equals(" -h-")) {
            return "knight";
        }
        if (table[7-y][x+1].equals(" -H-")) {
            return "black knight";
        }
        if (table[7-y][x+1].equals(" -b-")) {
            return "bishop";
        }
        if (table[7-y][x+1].equals(" -B-")) {
            return "black bishop";
        }
        if (table[7-y][x+1].equals(" -r-")) {
            return "rook";
        }
        if (table[7-y][x+1].equals(" -R-")) {
            return "black rook";
        }
        if (table[7-y][x+1].equals(" -K-")){
	        return "black king";
        }
        if (table[7-y][x+1].equals(" -k-")){
	        return "king";
        }
        if (table[7-y][x+1].equals(" -Q-")){
	        return "black queen";
        }
        if (table[7-y][x+1].equals(" -q-")){
	        return "queen";
        }
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

	    Scanner scan = new Scanner(System.in);
		String name = table[7-y][x+1];
		boolean inside = inTable(a, b);
		int free = freePath(x,y,a,b);
		String pieceName = getPiece(x, y);
        if (inside == true) {
            if ((free == 1)||(free == 2) || (free == 3)){

                //checks for white pawn promotion
                if(name.equals(" -p-")){
                    if (b == 7){
                        System.out.println("Would you like to promote your pawn to 1) Queen 2) Rook 3) Bishop 4) Knight ?");
                        int promotion = scan.nextInt();
                        if (promotion == 1){
                            name = " -q-";
                        }
                        else if (promotion == 2){
                            name = " -r-";
                        }
                        else if (promotion == 3){
                            name = " -b-";
                        }
                        else if (promotion == 4){
                            name = " -h-";
                        }

                    }
                }
                //checks for black pawn promotion
                else if(name.equals(" -P-")){
                    if (b == 0) {
                        System.out.println("Would you like to promote your pawn to 1) Queen 2) Knight 3) Bishop 4) Rook ?");

                        int promotion = scan.nextInt();
                        if (promotion == 1) {
                            name = " -Q-";
                        } else if (promotion == 2) {
                            name = " -R-";
                        } else if (promotion == 3) {
                            name = " -B-";
                        } else if (promotion == 4) {
                            name = " -H-";
                        }
                    }
                }
                table[7 - y][x + 1] = " ---";
                table[7 - b][a + 1] = name;
                System.out.println( pieceName + ": (" + x + "," + y + ")" + " (" + a + "," + b + ")");
                System.out.println("Moved!"  + ": (" + x + "," + y + ")" + " (" + a + "," + b + ")");
                System.out.println("====================");
                showTable();
            }
            if (free == 1){

            }
            if (free == 2){
                // make diff exceptions, one for white king killed, one for black, change number 2 and 3, print out winner.
                System.out.print("White king killed!  Black won!");
            }
            if (free == 3){
                System.out.println("Black king killed!  White won!");
            }
            if (free == 0){
                System.out.println("Invalid Board Position. (" + x + "," + y + ") (" + a + "," + b + ")");
            }
        }
        else{
            System.out.println("Invalid Board Position. (" + x + "," + y + ") (" + a + "," + b + ")");
        }
	}
// checks to see if there are pieces on moving piece's path
    private int freePath(int x, int y, int a, int b)
    {
        int free = 1;

        try {
            PathwayException exceptions = new PathwayException();
            WhiteKilled kingKilled = new WhiteKilled();
            BlackKilled blackKingKilled = new BlackKilled();
            //for white pawn
            if (table[7 - y][x + 1].equals(" -p-")) {
                if (b - y > 0) {
                    for (int c = y + 1; c <= b; c++) {
                        if (table[7 - c][x + 1] != " ---") {
                            throw exceptions;
                        }
                    }
                    if ((x - a > 0) || (x - a < 0)) {
                        if (table[7 - b][a + 1].equals(" ---")) {
                        }
                        if (table[7 - b][a + 1].equals(" ---")) {
                            throw exceptions;
                        }
                        if (table[7 - b][a + 1].equals(" -r-")) {
                            throw exceptions;
                        }
                        if (table[7 - b][a + 1].equals(" -b-")) {
                            throw exceptions;
                        }
                        if (table[7 - b][a + 1].equals(" -h-")) {
                            throw exceptions;
                        }
                        if (table[7 - b][a + 1].equals(" -p-")) {
                            throw exceptions;
                        }
                        if (table[7 - b][a  + 1].equals(" -k-")) {
                            throw exceptions;
                        }
                        if (table[7 - b][a + 1].equals(" -q-")) {
                            throw exceptions;
                        }
                        if (table[7 - b][a + 1].equals(" -K-")) {
                            throw blackKingKilled;
                        }
                    }
                } else {
                    throw exceptions;
                }
                //black pawn code
            } else if (table[7 - y][x + 1].equals(" -P-")) {
                if (b - y < 0) {
                    for (int d = y - 1; d > b; d--) {
                        if (table[7 - d][x + 1] != " ---") {
                            throw exceptions;
                        }
                    }
                    if ((x - a > 0) || (x - a < 0)) {
                        if (table[7 - b][a + 1].equals(" ---")) {
                            throw exceptions;
                        }
                        if (table[7 - b][a + 1].equals(" -R-")) {
                            throw exceptions;
                        }
                        if (table[7 - b][a + 1].equals(" -B-")) {
                            throw exceptions;
                        }
                        if (table[7 - b][a + 1].equals(" -H-")) {
                            throw exceptions;
                        }
                        if (table[7 - b][a + 1].equals(" -P-")) {
                            throw exceptions;
                        }
                        if (table[7 - b][a + 1].equals(" -K-")) {
                            throw exceptions;
                        }
                        if (table[7 - b][a + 1].equals(" -Q-")) {
                            throw exceptions;
                        }
                        //king was killed!
                        if (table[7 - b][a + 1].equals(" -k-")) {
                            throw kingKilled;
                        }
                    }
                } else {
                    throw exceptions;
                }
            }
            //bishop code
            else if (table[7 - y][x + 1].equals(" -b-")) {
                if (a - x > 0) {
                    int distance = b - y;
                    if (distance > 0) {
                        for (int count = 1; count < distance; count++) {
                            if (table[(7 - y - count)][x + 1 + count] != " ---") {
                                throw exceptions;
                            }
                        }
                    } else if (distance < 0) {
                        for (int count = -1; count > distance; count--) {
                            if (table[7 - y - count][x + 1 - count] != " ---") {
                                throw exceptions;
                            }
                        }
                    }
                } else {
                    int distance = b - y;
                    if (distance > 0) {
                        for (int count = 1; count < distance; count++) {
                            if (table[(7 - y - count)][x + 1 - count] != " ---") {
                                throw exceptions;
                            }
                        }
                    } else if (distance < 0) {
                        for (int count = -1; count > distance; count--) {
                            if (table[7 - y - count][x + 1 + count] != " ---") {
                                throw exceptions;
                            }
                        }
                    }
                }
                if (table[7 - b][a + 1].equals(" -p-")) {
                    throw exceptions;
                }
                if (table[7 - b][a + 1].equals(" -b-")) {
                    throw exceptions;
                }
                if (table[7 - b][a + 1].equals(" -h-")) {
                    throw exceptions;
                }
                if (table[7 - b][a + 1].equals(" -r-")) {
                    throw exceptions;
                }
                if (table[7 - b][a + 1].equals(" -q-")) {
                    throw exceptions;
                }
                if (table[7 - b][a + 1].equals(" -k-")) {
                    throw exceptions;
                }
                //king was killed!
                if (table[7 - b][a + 1].equals(" -K-")) {
                    throw blackKingKilled;
                }
            }
            //black bishop
            else if (table[7 - y][x + 1].equals(" -B-")) {
                // four different ways
                if (a - x > 0) {
                    int distance = b - y;
                    if (distance > 0) {
                        for (int count = 1; count < distance; count++) {
                            if (table[(7 - y - count)][x + 1 + count] != " ---") {
                                throw exceptions;
                            }
                        }
                    } else if (distance < 0) {
                        for (int count = -1; count > distance; count--) {
                            if (table[7 - y - count][x + 1 - count] != " ---") {
                                throw exceptions;
                            }
                        }
                    }
                } else {
                    int distance = b - y;
                    if (distance > 0) {
                        for (int count = 1; count < distance; count++) {
                            if (table[(7 - y - count)][x + 1 - count] != " ---") {
                                throw exceptions;
                            }
                        }
                    } else if (distance < 0) {
                        for (int count = -1; count > distance; count--) {
                            if (table[7 - y - count][x + 1 + count] != " ---") {
                                throw exceptions;
                            }
                        }
                    }
                }
                if (table[7 - b][a + 1].equals(" -P-")) {
                    throw exceptions;
                }
                if (table[7 - b][a + 1].equals(" -B-")) {
                    throw exceptions;
                }
                if (table[7 - b][a + 1].equals(" -H-")) {
                    throw exceptions;
                }
                if (table[7 - b][a + 1].equals(" -R-")) {
                    throw exceptions;
                }
                if (table[7 - b][a + 1].equals(" -Q-")) {
                    throw exceptions;
                }
                if (table[7 - b][a + 1].equals(" -K-")) {
                    throw exceptions;
                }
                //king was killed!
                if (table[7 - b][a + 1].equals(" -k-")) {
                    throw kingKilled;
                }
            }

            //rook code
            else if (table[7 - y][x + 1].equals(" -r-")) {
                //4 ways
                //up down, or left and right.
                if (a - x == 0) {
                    if (b - y > 0) {
                        for (int count = y + 1; count < b; count++) {
                            if (table[7 - count][x + 1] != " ---") {
                                throw exceptions;
                            }
                        }
                    } else {
                        for (int count = y - 1; count > b; count--) {
                            if (table[7 - count][x + 1] != " ---") {
                                throw exceptions;
                            }
                        }
                    }

                } else {
                    if (a - x > 0) {
                        for (int count = x + 1; count < a; count++) {
                            if (table[7 - y][count + 1] != " ---") {
                                throw exceptions;
                            }
                        }
                    } else {
                        for (int count = x - 1; count > a; count--) {
                            if (table[7 - y][count + 1] != " ---") {
                                throw exceptions;
                            }
                        }
                    }
                }
                if (table[7 - b][a + 1].equals(" -p-")) {
                    throw exceptions;
                }
                if (table[7 - b][a + 1].equals(" -r-")) {
                    throw exceptions;
                }
                if (table[7 - b][a + 1].equals(" -q-")) {
                    throw exceptions;
                }
                if (table[7 - b][a + 1].equals(" -k-")) {
                    throw exceptions;
                }
                if (table[7 - b][a + 1].equals(" -h-")) {
                    throw exceptions;
                }
                if (table[7 - b][a + 1].equals(" -b-")) {
                    throw exceptions;
                }
                //king was killed!
                if (table[7 - b][a + 1].equals(" -K-")) {
                    throw blackKingKilled;
                }
            }

            //black rook
            else if (table[7 - y][x + 1].equals(" -R-")) {
                //4 ways
                //up down, or left and right.
                if (a - x == 0) {
                    if (b - y > 0) {
                        for (int count = y + 1; count < b; count++) {
                            if (table[7 - count][x + 1] != " ---") {
                                throw exceptions;
                            }
                        }
                    } else {
                        for (int count = y - 1; count > b; count--) {
                            if (table[7 - count][x + 1] != " ---") {
                                throw exceptions;
                            }
                        }
                    }

                } else {
                    if (a - x > 0) {
                        for (int count = x + 1; count < a; count++) {
                            if (table[7 - y][count + 1] != " ---") {
                                throw exceptions;
                            }
                        }
                    } else {
                        for (int count = x - 1; count > a; count--) {
                            if (table[7 - y][count + 1] != " ---") {
                                throw exceptions;
                            }
                        }
                    }
                }
                if (table[7 - b][a + 1].equals(" -P-")) {
                    throw exceptions;
                }
                if (table[7 - b][a + 1].equals(" -R-")) {
                    throw exceptions;
                }
                if (table[7 - b][a + 1].equals(" -Q-")) {
                    throw exceptions;
                }
                if (table[7 - b][a + 1].equals(" -K-")) {
                    throw exceptions;
                }
                if (table[7 - b][a + 1].equals(" -H-")) {
                    throw exceptions;
                }
                if (table[7 - b][a + 1].equals(" -B-")) {
                    throw exceptions;
                }
                //king was killed!
                if (table[7 - b][a + 1].equals(" -k-")) {
                    throw kingKilled;
                }
            }

                //horse code
            else if (table[7 - y][x + 1].equals(" -h-")) {
                if (table[7 - b][a + 1].equals(" -b-")){
                    throw exceptions;
                }
                if (table[7 - b][a + 1].equals(" -p-")){
                    throw exceptions;
                }
                if (table[7 - b][a + 1].equals(" -h-")){
                    throw exceptions;
                }
                if (table[7 - b][a + 1].equals(" -q-")){
                    throw exceptions;
                }
                if (table[7 - b][a + 1].equals(" -k-")){
                    throw exceptions;
                }
                if (table[7 - b][a + 1].equals(" -r-")){
                    throw exceptions;
                }
                //king was killed!
                if (table[7 - b][a + 1].equals(" -K-")) {
                    throw blackKingKilled;
                }
            }
            //black horse
            else if (table[7 - y][x + 1].equals(" -H-")) {
                if (table[7 - b][a + 1].equals(" -B-")){
                    throw exceptions;
                }
                if (table[7 - b][a + 1].equals(" -P-")){
                    throw exceptions;
                }
                if (table[7 - b][a + 1].equals(" -H-")){
                    throw exceptions;
                }
                if (table[7 - b][a + 1].equals(" -Q-")){
                    throw exceptions;
                }
                if (table[7 - b][a + 1].equals(" -K-")){
                    throw exceptions;
                }
                if (table[7 - b][a + 1].equals(" -R-")){
                    throw exceptions;
                }
                //king was killed!
                if (table[7 - b][a + 1].equals(" -k-")) {
                    throw kingKilled;
                }
            }
            //black king
            else if (table[7 - y][x + 1].equals(" -K-")) {
                if (table[7 - b][a + 1].equals(" -Q-")){
                    throw exceptions;
                }
                if (table[7 - b][a + 1].equals(" -P-")){
                    throw exceptions;
                }
                if (table[7 - b][a + 1].equals(" -H-")){
                    throw exceptions;
                }
                if (table[7 - b][a + 1].equals(" -R-")){
                    throw exceptions;
                }
                if (table[7 - b][a + 1].equals(" -B-")){
                    throw exceptions;
                }
                //king was killed!
                if (table[7 - b][a + 1].equals(" -k-")) {
                    throw kingKilled;
                }
            }
            //king
            else if (table[7 - y][x + 1].equals(" -k-")) {
                if (table[7 - b][a + 1].equals(" -q-")){
                    throw exceptions;
                }
                if (table[7 - b][a + 1].equals(" -p-")){
                    throw exceptions;
                }
                if (table[7 - b][a + 1].equals(" -h-")){
                    throw exceptions;
                }
                if (table[7 - b][a + 1].equals(" -r-")){
                    throw exceptions;
                }
                if (table[7 - b][a + 1].equals(" -b-")){
                    throw exceptions;
                }
                //king was killed!
                if (table[7 - b][a + 1].equals(" -K-")) {
                    throw blackKingKilled;
                }
            }

            //queen
            else if (table[7 - y][x + 1].equals(" -q-")){
                //4 ways
                //up down, or left and right.
                if (x - a == 0){
                    int distance = b - y;
                    if (b - y > 0) {
                        for (int count = 1; count < distance; count ++){
                            if (table[7 - y - count][x + 1] != " ---"){
                                throw exceptions;
                            }
                        }
                    }
                    else{
                        for (int count = -1; count > distance; count--){
                            if (table[7 - y - count][x + 1] != " ---"){
                                throw exceptions;
                            }
                        }
                    }
                }
                else if (b - y == 0){
                    int distance = a - x;
                    if (a - x > 0){
                        for (int count = 1  ; count < distance; count++){
                            if (table[7 - y][x + 1 + count] != " ---"){
                                throw exceptions;
                            }
                        }
                    }
                    else{
                        for (int count = -1 ; count > distance ; count--){
                            if (table[7-y][x + 1 - count] != " ---"){
                                throw exceptions;
                            }
                        }
                    }
                }
                else if ((b - y == a - x) || (y - b == a - x)) {
                    // code gotten from bishop diagonal checks
                    if (a - x > 0) {
                        int distance = b - y;
                        if (distance > 0) {
                            for (int count = 1; count < distance; count++) {
                                if (table[(7 - y - count)][x + 1 + count] != " ---") {
                                    throw exceptions;
                                }
                            }
                        } else if (distance < 0) {
                            for (int count = -1; count > distance; count--) {
                                if (table[7 - y - count][x + 1 - count] != " ---") {
                                    throw exceptions;
                                }
                            }
                        }
                    } else {
                        int distance = b - y;
                        if (distance > 0) {
                            for (int count = 1; count < distance; count++) {
                                if (table[(7 - y - count)][x + 1 - count] != " ---") {
                                    throw exceptions;
                                }
                            }
                        } else if (distance < 0) {
                            for (int count = -1; count > distance; count--) {
                                if (table[7 - y - count][x + 1 + count] != " ---") {
                                    throw exceptions;
                                }
                            }
                        }
                    }
                }



                if (table[7 - b][a + 1].equals(" -p-")) {
                    throw exceptions;
                }
                if (table[7 - b][a + 1].equals(" -r-")) {
                    throw exceptions;
                }
                if (table[7 - b][a + 1].equals(" -q-")) {
                    throw exceptions;
                }
                if (table[7 - b][a + 1].equals(" -k-")) {
                    throw exceptions;
                }
                if (table[7 - b][a + 1].equals(" -h-")) {
                    throw exceptions;
                }
                if (table[7 - b][a + 1].equals(" -b-")) {
                    throw exceptions;
                }
                //king was killed!
                if (table[7 - b][a + 1].equals(" -K-")) {
                    throw blackKingKilled;
                }
            }
            //black queen
            else if (table[7 - y][x + 1].equals(" -Q-")){
                //4 ways
                //up down, or left and right.
                if (x - a == 0){
                    int distance = b - y;
                    if (b - y > 0) {
                        for (int count = 1; count < distance; count ++){
                            if (table[7 - y - count][x + 1] != " ---"){
                                throw exceptions;
                            }
                        }
                    }
                    else{
                        for (int count = -1; count > distance; count--){
                            if (table[7 - y - count][x + 1] != " ---"){
                                throw exceptions;
                            }
                        }
                    }
                }
                else if (b - y == 0){
                    int distance = a - x;
                    if (a - x > 0){
                        for (int count = 1  ; count < distance; count++){
                            if (table[7 - y][x + 1 + count] != " ---"){
                                throw exceptions;
                            }
                        }
                    }
                    else{
                        for (int count = -1 ; count > distance ; count--){
                            if (table[7-y][x + 1 - count] != " ---"){
                                throw exceptions;
                            }
                        }
                    }
                }
                else if ((b - y == a - x) || (y - b == a - x)) {
                    // code gotten from bishop diagonal checks
                    if (a - x > 0) {
                        int distance = b - y;
                        if (distance > 0) {
                            for (int count = 1; count < distance; count++) {
                                if (table[(7 - y - count)][x + 1 + count] != " ---") {
                                    throw exceptions;
                                }
                            }
                        } else if (distance < 0) {
                            for (int count = -1; count > distance; count--) {
                                if (table[7 - y - count][x + 1 - count] != " ---") {
                                    throw exceptions;
                                }
                            }
                        }
                    } else {
                        int distance = b - y;
                        if (distance > 0) {
                            for (int count = 1; count < distance; count++) {
                                if (table[(7 - y - count)][x + 1 - count] != " ---") {
                                    throw exceptions;
                                }
                            }
                        } else if (distance < 0) {
                            for (int count = -1; count > distance; count--) {
                                if (table[7 - y - count][x + 1 + count] != " ---") {
                                    throw exceptions;
                                }
                            }
                        }
                    }
                }



                if (table[7 - b][a + 1].equals(" -P-")) {
                    throw exceptions;
                }
                if (table[7 - b][a + 1].equals(" -R-")) {
                    throw exceptions;
                }
                if (table[7 - b][a + 1].equals(" -Q-")) {
                    throw exceptions;
                }
                if (table[7 - b][a + 1].equals(" -K-")) {
                    throw exceptions;
                }
                if (table[7 - b][a + 1].equals(" -H-")) {
                    throw exceptions;
                }
                if (table[7 - b][a + 1].equals(" -B-")) {
                    throw exceptions;
                }
                //king was killed!
                if (table[7 - b][a + 1].equals(" -k-")) {
                    throw kingKilled;
                }
            }
        }
        catch (PathwayException exceptions){
            free = 0;
        }
        catch (WhiteKilled kingKilled){
            free = 2;
            game = false;
        }
        catch (BlackKilled blackKingKilled){
            free = 3;
            game = false;
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

	// this boolean returns if game has ended or not
	public boolean game(){
	    return game;
    }
}