public class Rook extends ChessPiece
{

	public Rook(int x, int y)
	{
		super(x, y);

	}

	public boolean move(int x, int y)
	{
		// can move 4 ways.
		boolean answer = true;
		if (this.x != x)
		{
			if (this.y != y) {
				answer = false;
			}
		}
		if (this.y != y) {
			if (this.x != x){
				answer = false;
			}
		}
		return answer;
	}
}