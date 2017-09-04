/* @UNIVESRE.COM_20170115_HYE
 * Demo: 枚举和switch, p106. */

public class Burrito {

    Spiciness degree;

    public Burrito(Spiciness degree) {
        this.degree = degree;
    }

    public void describe() {
        System.out.print("This burrito is ");
        switch(degree) {
            case NOT:
                System.out.println("not spice at all.");
                break;
            case MILD:
            case MEDIUM:
                System.out.println("a little hot.");
                break;
            case HOT:
            case FLAMING:
                System.out.println("maybe too hot.");
                break;
            default:
                System.out.println("have no idea.");
        }
    }

    public static void main(String[] args) {

        Burrito plain       = new Burrito(Spiciness.NOT),
                greenChile  = new Burrito(Spiciness.MEDIUM),
                jalapeno    = new Burrito(Spiciness.HOT);

        plain.describe();
        greenChile.describe();
        jalapeno.describe();

    }
}

