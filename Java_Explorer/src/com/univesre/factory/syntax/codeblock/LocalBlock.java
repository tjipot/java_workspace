package factory.syntax.codeblock;

/**
 * @Project: java_demo
 * @PackageName: factory.syntax.codeblock
 * @CreationDate: 2018-04-02 18:15
 * @Description: 演示局部代码块的使用
 * @Author: Haoran Ye
 * @ModificationHistory: Who When What
 */
public class LocalBlock {

	public static void main(String[] args) {

		// int 我是变量 = 0;    // 不注释, 会报错;
		// 局部代码块: 要存在于方法中, 这个例子中, 只要块代码结束了, 即便main还没结束, "我是变量"也不会占用内存了;
		{
			int 我是变量 = 9;   // 绝了, 中文变量;
			System.out.println(我是变量);
		}

		// System.out.println(我是变量);
		System.out.println("局部代码块外面..");

	}
}
