/* @UNVIESRE.COM_20170117_HYE
 * Demo: upcasting 向上转型,
 * ch8.1再论向上转型, p148. */
//package ch08_polymorphism.music;

// Wind objects are instruments because they have the same interface;
public class Wind extends Instrument {  // 风笛类;

    // Redefining interface method;
    public void play(Note n) {
        System.out.println("Wind.play() " + n);
    }
}
