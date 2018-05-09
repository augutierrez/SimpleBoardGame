public class Queen extends ChessPiece {

    public Queen (int x, int y){
        super(x, y);
    }

    public boolean move(int x, int y) {

        boolean answer = false;
        //bishops move diagonally, so both x and y should be changing at the same rate
        if (this.x != x) {
            if (this.y != y) {
                if (this.x - x == this.y - y) {
                    answer = true;
                } else if (x - this.x == this.y - y) {
                    answer = true;
                }
            }
            if (this.y == y) {
                answer = true;
            }
        }
        if (this.y != y) {
            if (this.x == x) {
                answer = true;
            }
        }

        return answer;
    }
}
