package factory.strings.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @Project: java_demo
 * @PackageName: factory.strings.xml
 * @CreationDate: 2018-03-28 17:52
 * @Description: Root元素item下的一个子元素的Bean
 * @Author: Haoran Ye
 * @ModificationHistory: Who When What
 */
// 此ProductInfoImg会包装在ProductInfoBean的"mainImg"List中, 这个RootElement注解不影响它作为子Element被包装在XMLElementWrapper中;
@XmlRootElement
public class ProductInfoImg {

	@XmlElement(name="url") private String url;     // url元素;

	@XmlElement(name="size") private String size;    // size元素;

	public void setUrl(String url) {
		this.url = url;
	}

	public void setSize(String size) {
		this.size = size;
	}

}
