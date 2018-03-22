package annotation;

/**
 * @Project: java_demo
 * @PackageName: annotation
 * @CreationDate: 2018-03-22 16:28
 * @Description: 测试自定义注解"Reflect"的使用
 * @Author: Haoran Ye
 * @ModificationHistory: Who When What
 */
public class ReflectTest {

	/**
	 * @Title: sayHello
	 * @Description: 使用注解(默认)
	 * @Parameter: name(由"ReflectProcessor"中的"invoke()"传入)
	 * @Return: void
	 * @Throws: None
	 **/
	@Reflect
	public static void sayHello(final String name) {
		System.out.println("@Reflect outputs: " + name + ", Hello!");
	}

	/**
	 * @Title: sayHelloToSomeone
	 * @Description: 使用注解(传入参数值)
	 * @Parameter: name(由"ReflectProcessor"中的"invoke()"传入)
	 * @Return: void
	 * @Throws: None
	 **/
	@Reflect(name = "SuperMan")
	public static void sayHelloToSomeone(final String name) {
		System.out.println("@Reflect outputs: " + name + ", Hello!");
	}

	/**
	 * @Title: main
	 * @Description: 主入口
	 * @Parameter: args
	 * @Return: void
	 * @Throws: Exception
	 **/
	public static void main(final String[] args) throws Exception {
		final ReflectProcessor reflectProcessor = new ReflectProcessor();
		reflectProcessor.parseMethod(ReflectTest.class);    // 调用ReflectProcessor中的parseMethod方法(里面的逻辑是核心);
	}

}
