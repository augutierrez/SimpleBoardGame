
public class Pawn extends ChessPiece
{
	//for en passant
	private int counter = 0;

	public Pawn(int x, int y)
	{
        super(x, y);

	}

	public boolean move(int x, int y)
	{

		boolean answer = true;
		//pawns should be moving in their designated lane
		if (this.x != x)
		{
			answer = false;
		}
		// checks for en passant
		else if (y - this.y > 0){
			if (y - this.y > 1){
				if (counter != 0){
					answer = false;
				}
			}
		}
		else if (y- this.y < 0){
			if (this.y - y > 1) {
				if (counter != 0) {
					answer = false;
				}
			}
		}

		return answer;
	}
}