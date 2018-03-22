package annotation;

/**
 * @Project: java_demo
 * @PackageName: annotation
 * @CreationDate: 2018-03-22 18:28
 * @Description: TODO
 * @Author: Haoran Ye
 * @ModificationHistory: Who When What
 */
@adDescription("This Is An Annotation Test Class!")
public class AnnotationTest {

	@adAuthor(name = "Haoran Ye", group = "Univesre")
	public void test() {
		System.out.println("Test Begins, Test Over!");
	}
}
