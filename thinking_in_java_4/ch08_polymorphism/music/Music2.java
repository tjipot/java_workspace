/* @UNVIESRE.COM_20170117_HYE
 * Demo: upcasting 向上转型,
 * ch8.1.1_"忘记"对象类型, p149. */

class Stringed extends Instrument {
    public void play(Note n) {
        System.out.println("Stringed.play() " + n);
    }
}

class Brass extends Instrument {
    public void play(Note n) {
        System.out.println("Brass.play() " + n);
    }
}

public class Music2 {

    // Overloading;
    public static void tune(Wind i) {
        i.play(Note.MIDDLE_C);
    }

    public static void tune(Stringed i) {
        i.play(Note.MIDDLE_C);
    }

    public static void tune(Brass i) {
        i.play(Note.MIDDLE_C);
    }

    // 这个函数是我故意加的, 运行结果表明java会先选择重载而不是向上转型;
    public static void tune(Instrument i) {
        i.play(Note.B_FLAT);    // 这里输出B_FLAT;
    }

    public static void main(String[] args) {

        Wind flute = new Wind();
        Stringed violin = new Stringed();
        Brass frenchHorn = new Brass();

        // No upcasting, it's overloading;
        tune(flute);
        tune(violin);
        tune(frenchHorn);
    }
}

/* Result:
 * Wind.play() MIDDLE_C
 * Stringed.play() MIDDLE_C
 * Brass.play() MIDDLE_C
 * */