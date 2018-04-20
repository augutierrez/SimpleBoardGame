public abstract class ChessPiece
{
    protected int x, y;
	public ChessPiece(int x, int y)
    {
	    this.x = x;
	    this.y = y;
    }
	public abstract boolean move(int x, int y);

    //protected boolean white;

}