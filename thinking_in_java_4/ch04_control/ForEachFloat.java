/* @UNIVESRE.COM_20170114_HYE
 * foreach works on array and containers, p67. */
import java.util.*;

public class ForEachFloat {

    public static void main(String[] args) {
        Random rand = new Random(47);
        float[] f = new float[10];
        for(int i = 0; i < 10; i++) {
            f[i] = rand.nextFloat();
        }
        for(float x : f) {             // f should either be array or container;
            System.out.println(x);
        }
    }
}