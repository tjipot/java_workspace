/* @UNIVESRE.COM_20170115_HYE
 * Demo: using finalize() to detect an object that
 * hasn't been properly cleaned up, p89. */

class Book {

    boolean checkedOut = false;
    Book(boolean checkOut) {
        checkedOut = checkOut;
    }

    void checkIn() {
        checkedOut = false;
    }

    protected void finalize() {
        if(checkedOut) {
            System.out.println("Error: checked out!");
            // Normally, you will also do this:
//            super.finalize();   // Call the base-class version;
        }
    }
}

public class TerminationCondition {

    public static void main(String[] args) {
        Book novel = new Book(true);
        // Proper cleanup:
        novel.checkIn();

        // Drop the reference, forget to clean up:
        new Book(true);
        // Force garbage collection & finalization:
        System.gc();
        // 奇怪的这个程序并没有输出"Error: ...", 和书上的不符;
    }
}
