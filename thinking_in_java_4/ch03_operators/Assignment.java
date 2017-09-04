/* @UNIVESRE.COM_20170114_HYE
 * Assignment with objects is a bit tricky, p40. */

import static net.mindview.util.Print.*;    // 修改环境变量之后要重启Terminal.app;

class Tank {                                // class is a kind of data structure;
    int level;
}

public class Assignment {
	public static void main(String[] args){

        Tank t1 = new Tank();
        Tank t2 = new Tank();
        t1.level = 9;
        t2.level = 47;
        print("1: t1.level: " + t1.level + ",\t\t t2.level: " + t2.level);
        
        t1 = t2;                            // Assign the reference(object assignment);
        print("2: t1.level: " + t1.level + ",\t t2.level: " + t2.level);
        t1.level = 27;
        print("3: t1.level: " + t1.level + ",\t t2.level: " + t2.level);

    }
}