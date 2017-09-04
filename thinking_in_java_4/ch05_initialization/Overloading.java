/* @UNIVESRE.COM_20170114_HYE
 * Demo: method overload, p78. */

import static net.mindview.util.Print.*;

class Tree {

    int height;

    // Constructor;
    Tree() {
        print("Planting a seedling.");   // seedling: 秧苗, 幼苗, 树苗;
        height = 0;
    }

    Tree(int initialHeight) {
        height = initialHeight;
        print("Creating new Tree that is " + height + " feet tall.");
    }

    void info() {
        print("info(): tree is " + height + " feet tall.");
    }

    void info(String s) {
        print("info(s): " + s + ", tree is " + height + " feet tall.");
    }
}


public class Overloading {

    public static void main(String[] args) {

        for(int i = 0; i < 5; i++) {
            Tree t = new Tree(i);
            t.info();
            t.info("overloaded method");
        }

        // Overloaded constructor;
        new Tree();
    }

}

/* Result:
 * POSIX:ch05_code HY$ java Overloading
 * Creating new Tree that is 0 feet tall.
 * info(): tree is 0 feet tall.
 * info(s): overloaded method, tree is 0 feet tall.
 * Creating new Tree that is 1 feet tall.
 * info(): tree is 1 feet tall.
 * info(s): overloaded method, tree is 1 feet tall.
 * Creating new Tree that is 2 feet tall.
 * info(): tree is 2 feet tall.
 * info(s): overloaded method, tree is 2 feet tall.
 * Creating new Tree that is 3 feet tall.
 * info(): tree is 3 feet tall.
 * info(s): overloaded method, tree is 3 feet tall.
 * Creating new Tree that is 4 feet tall.
 * info(): tree is 4 feet tall.
 * info(s): overloaded method, tree is 4 feet tall.
 * Planting a seedling. */

