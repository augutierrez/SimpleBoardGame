# simple-chess
Antonio Guteirrez 5/09/2018

This project practices Java’s class inheritance property.  I create a “ChessPiece” class that gives basic movement functionality to a chess piece, and also keeps track of whether it is black or white.  Then, 6 subclasses were built that inherit “ChessPiece” (pawn, knight, rook, bishop, queen, and king) that put restrictions on how each piece may move.  These pieces were created and stored on the class “Table” which is where the movement in a game’s progress is recorded.

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

