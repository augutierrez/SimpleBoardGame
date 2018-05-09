public class Knight extends ChessPiece {

    public Knight(int x, int y){
        super(x, y);
    }

    public boolean move(int x, int y){
        boolean answer = false;
        //horse has 8 possible moves.
        if (x == this.x + 2){
            if (y == this.y + 1){
                answer = true;
            }
            else if (y == this.y - 1){
                answer = true;
            }
        }
        else if (x == this.x - 2){
            if (y == this.y - 1){
                answer = true;
            }
            else if (y == this.y + 1){
                answer = true;
            }
        }
        else if (y == this.y + 2){
            if (x == this.x + 1){
                answer = true;
            }
            else if (x == this.x - 1){
                answer = true;
            }
        }
        else if (y == this.y - 2){
            if (x == this.x - 1){
                answer = true;
            }
            else if (x == this.x + 1){
                answer = true;
            }
        }
        else{
            answer = false;
        }
        return answer;
    }
}
