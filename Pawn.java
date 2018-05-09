
public class Pawn extends ChessPiece {
    //for en passant
    private int counter = 0;

    public Pawn(int x, int y) {
        super(x, y);

    }

    public boolean move(int x, int y) {

        boolean answer = true;
        //pawns should be moving in their designated lane
        if (isWhite) {
            if (this.x == x + 2) {
                answer = false;
            }
            if (this.x == x - 2) {
                answer = false;
            }
            // checks for en passant
            else if (y - this.y > 0) {
                if (y - this.y > 1) {
                    if (counter != 0) {
                        answer = false;
                    }
                    if (y - this.y > 2) {
                        answer = false;
                    }
                }
            }
            if (y - this.y < 0) {
                answer = false;
            }
        } else {
            if (this.x == x + 2) {
                answer = false;
            }
            if (this.x == x - 2) {
                answer = false;
            } else if (y - this.y < 0) {
                if (y - this.y < -1) {
                    if (counter != 0) {
                        answer = false;
                    }
                }
                if (y - this.y < -2) {
                    answer = false;
                }
            }
            if (y - this.y > 0) {
                answer = false;
            }
        }
        return answer;
    }
}



