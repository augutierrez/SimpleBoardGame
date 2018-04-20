public class Bishop extends ChessPiece {

    public Bishop(int x, int y){
        super(x, y);
    }

    public boolean move(int x, int y){
        boolean answer = true;
        //bishops move diagonally, so both x and y should be changing at the same rate
        if (this.x != x)
        {
            if (this.y != y)
            {
                if (this.x - x == this.y - y) {
                    answer = true;
                }
            }
        }
        else {
            answer = false;
        }
        return answer;
    }
}
