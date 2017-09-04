/* @UNIVESRE.COM_20170114_HYE
 * Demo: usage of this, p84. */

public class Leaf {

    int i = 0;

    Leaf increment() {
        i++;
        return this;    // 'this' is a pointer, return 'this' is return the ref(the real memory object) of an instance object;
    }

    void print() {
        System.out.println("i = " + i);
    }

    public static void main(String[] args) {
        Leaf x = new Leaf();
        x.increment().increment().increment().print();
    }
}

