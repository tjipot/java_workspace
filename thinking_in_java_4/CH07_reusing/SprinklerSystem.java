/* @UNIVESRE.COM_20170116_HYE
 * Demo: composition of code reuse,
 * ch7.1: 组合的语法, p125. */

class WaterSource {

    private String s;

    WaterSource() {
        System.out.println("WaterSource()");
        s = "Constructed";
    }

    public String toString() { return s; }          // 当想要让对象返回字符串时, 默认会调用toString()的;

}

public class SprinklerSystem {

    private String value1, value2, value3, value4;
    private WaterSource source = new WaterSource(); // Composition, 组合形式的代码复用;
    private int i;
    private float f;

    public String toString() {
        return
            "value1 = " + value1 + " "  +
            "value2 = " + value2 + " "  +
            "value3 = " + value3 + " "  +
            "value4 = " + value4 + "\n" +
            "i = "      + i      + " "  +
            "f = "      + f      + " "  +
            "source = " + source;
    }

    public static void main(String[] args) {
        SprinklerSystem sprinkers = new SprinklerSystem();
        System.out.println(sprinkers);
    }
}

/* Result:
 * WaterSource()
 * value1 = null value2 = null value3 = null value4 = null
 * i = 0 f = 0.0 source = Constructed */




