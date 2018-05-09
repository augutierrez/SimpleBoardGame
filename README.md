# simple-chess
Antonio Guteirrez 5/09/2018


ChessPiece:  parent class for all other chess pieces.
Pawn.java:  Code for pawn, keeps X and Y variables, has Move() boolean method.
Bishop.java: Code for bishop,  keeps X and Y variables, has Move() boolean method.
Knight.java: Code for Knight,  keeps X and Y variables, has Move() boolean method.
Rook.java: Code for Rook,  keeps X and Y variables, has Move() boolean method.

Table.java:  Code for chess board.  Also checks for valid moves in terms of: Inside the Board and Free Pathway.  Keeps track of all the chess pieces.

PathwayException: Exception for Free Pathway
OutOfBoardException:  Exception for Out of Board

Driver: Reads input files and handles the desired moves/ added pieces.

input.txt: sample input

