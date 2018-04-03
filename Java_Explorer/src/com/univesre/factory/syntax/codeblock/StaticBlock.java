package factory.syntax.codeblock;

/**
 * @Project: java_demo
 * @PackageName: factory.syntax.codeblock
 * @CreationDate: 2018-04-03 10:22
 * @Description: 演示静态代码块的使用
 * @Author: Haoran Ye
 * @ModificationHistory: Who When What
 */
public class StaticBlock {

	static {
		System.out.println("Static Code Block..");
	}

	public void showMsg() {
		System.out.println("This is showMsg()..");
	}
}

class StaticBlockDemo {

	static {
		System.out.println("Static Code Block Demo.. One.");
	}

	public static void main(String[] args) {

		new StaticBlock().showMsg();                    // 类使用, 1;
		StaticBlock staticBlock = new StaticBlock();    // 类使用, 2;
		staticBlock.showMsg();

		/*
		 *  Static Code Block Demo.. One.
			Static Code Block Demo.. Two.
			Static Code Block..             // 只显示了一次, 因为static初始化作用的范围是类范围内, 包括对象的创建也包括在类范围内;
			This is showMsg()..
			This is showMsg()..
		*/
	}

	static {
		System.out.println("Static Code Block Demo.. Two.");
	}
}
