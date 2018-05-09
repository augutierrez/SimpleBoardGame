public class PathwayException extends IllegalArgumentException {
    public PathwayException() {}
    public PathwayException(String message)
    { super("Chess Piece(s) in the way!"); }
}
