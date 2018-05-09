public class OutOfBoardException extends IllegalArgumentException {
    public OutOfBoardException() {}
    public OutOfBoardException(String message)
    { super("Outside of Board!"); }

}
