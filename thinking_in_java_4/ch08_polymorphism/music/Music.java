/* @UNVIESRE.COM_20170117_HYE
 * Demo: upcasting 向上转型,
 * ch8.1再论向上转型, p148. */
//package ch08_polymorphism.music;

public class Music {

    public static void tune(Instrument i) {
        i.play(Note.MIDDLE_C);
    }

    public static void main(String[] args) {
        Wind flute = new Wind();
        tune(flute);    // upcasting;
    }
}