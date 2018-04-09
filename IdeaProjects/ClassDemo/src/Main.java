public class Main {

    private static final int MAXIMUM = 10 ;

    public static void main(String[] args) {
	// write your code here
        System.out.println("Good Aftermorning");
        System.out.println("OMG THIS IS A SHORTCUT SOUT");

        int j = 0;
        for(int i = 0; i < MAXIMUM; i ++)
        {
            j = i;
            j = myMethod(j);
            if(j==50)
                throw new MyException();
        }
    }

    private static int myMethod(int j) {
        int result;
        result = j * MAXIMUM;
        return result;
    }

    private static class MyException extends RuntimeException {
    }
}
