public class TryCatchFinally {
    public static void main(String[] args) {
        System.out.println("Return value from returnValue1: " + returnValue1());
        System.out.println("Return value from returnValue2: " + returnValue2());
    }

    static int returnValue1() {
        try {
            return 1;
        } finally {
            return 2; // This will override the return value from the try block
        }
    }

    static int returnValue2() {
        try {
            throw new Exception("An error occurred"); // This will cause an exception to be thrown
        } catch (Exception e) {
            return 3; // This will be returned if an exception occurs
        } finally {
            return 2; // This will override the return value from both the try and catch blocks
        }
    }
}
