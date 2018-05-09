public abstract class ChessPiece
{
    protected int x, y;
    protected boolean isWhite;
	public ChessPiece(int x, int y)
    {
	    this.x = x;
	    this.y = y;
	    isWhite = false;
    }
	public abstract boolean move(int x, int y);

	public void setWhite() {
		isWhite = true;
	}
}