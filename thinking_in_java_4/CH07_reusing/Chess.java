/* @UNIVESRE.COM_20170116_HYE
 * Demo: constructor with arguments,
 * ch7.2.1带参数的构造器, p130. */

import static net.mindview.util.Print.*;

class Game {
    Game(int i) {
        print("Game constructor.");
    }
}

class BoardGame extends Game {
    BoardGame(int i) {
        super(i);
        print("BoardGame constructor.");
    }
}

public class Chess extends BoardGame {
    Chess() {
        super(11);
        print("Chess constructor.");
    }

    public static void main(String[] args) {
        Chess x = new Chess();
    }
}



