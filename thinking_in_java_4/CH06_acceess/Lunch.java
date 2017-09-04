/* @UNIVESRE.COM_20170116_HYE
 * Demo: class access specifiers, make a class
 * effectively private with private constructors;
 * p122. */

class Soup1 {

    private Soup1() {}

    // Allow creation via static method, not by new;
    public static Soup1 makeSoup() {
        return new Soup1();
    }
}

class Soup2 {

    private Soup2() {}

    // Create a static object;
    private static Soup2 ps1 = new Soup2();

    // Return the reference upon request: "singleton pattern";
    public static Soup2 access() {
        return ps1;
    }

    public void f() {}
}

public class Lunch {

    void testPrivate() {
//        Soup1 soup = new Soup1(); // Can't new Soup1(), private Soup1() constructor;
    }

    void testStatic() {
        Soup1 soup = Soup1.makeSoup();
    }

    void testSingleton() {
        Soup2.access().f();
    }
}

