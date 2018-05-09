public class King extends ChessPiece{

    public King (int x, int y){
        super(x, y);
    }
    public boolean move(int x, int y){
        boolean answer = true;
        if (this.x == x + 2){
            answer = false;
        }
        if (this.x == x - 2){
            answer = false;
        }
        if (this.y == y + 2){
            answer = false;
        }
        if (this.y == y - 2){
            answer = false;
        }
        return answer;
    }
}
