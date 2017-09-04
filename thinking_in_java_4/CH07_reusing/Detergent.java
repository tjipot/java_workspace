/* @UNIVESRE.COM_20170116_HYE
 * Demo: the syntax of inheritance,
 * ch7.2继承语法, p127. */

import static net.mindview.util.Print.*;

class Cleanser {

    private String s = "Cleanser";

    public void append(String a) { s += a; }
    public void dilute() { append(" dilute()"); }
    public void apply() { append(" apply()"); }
    public void scrub() { append(" scrub()"); }
    public String toString() { return s; }

    public static void main(String[] args) {
        Cleanser x = new Cleanser();
        x.dilute(); x.apply(); x.scrub();
        print(x);
    }
}

/* Subclass will automatically get all the fileds and methods of base class. */
public class Detergent extends Cleanser {

    // Change a method, override, 重写;
    public void scrub() {
        append(" Detergent.scrub()");
        super.scrub();  // Call base-class version;
    }

    // Add methods to the interface, 接口扩充;
    public void foam() { append(" foam()"); }

    // Test the new class;
    public static void main(String[] args) {
        Detergent x = new Detergent();
        x.dilute(); x.apply(); x.scrub(); x.foam();
        print(x);
        print("Testing base class:");
        Cleanser.main(args);    // Shit, 还能这么用, TM的狗屎的大学人生;
    }
}

/* Result:
 * Cleanser dilute() apply() Detergent.scrub() scrub() foam()
 * Testing base class:
 * Cleanser dilute() apply() scrub() */

