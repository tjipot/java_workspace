package factory.strings.xml;

import javax.xml.bind.annotation.XmlAttribute;      // Maps a JavaBean property to a XML attribute.
import javax.xml.bind.annotation.XmlElement;        // Maps a JavaBean property to a XML element derived from property name.
/* XmlElementWrapper: Generates a wrapper element around XML representation. This is primarily intended to be used to
 * produce a wrapper XML element *around collections*. The annotation therefore supports two forms of serialization shown below. */
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;    // Maps a class or an enum type to an XML element(作用于Class类型级别的).
import java.util.List;

/**
 * @Project: java_demo
 * @PackageName: factory.strings.xml
 * @CreationDate: 2018-03-28 17:48
 * @Description: TODO
 * @Author: Haoran Ye
 * @ModificationHistory: Who When What
 */
@XmlRootElement(name="item")
public class ProductInfoBean {

	@XmlAttribute private String version;           // 此注解的作用机制是反射, XML的操作类会依据JAVA的反射机制来生成相应的XML元素;

	@XmlElement private String id;
	@XmlElement private String title;
	@XmlElement private String category;
	@XmlElement private String url;                 // 商品的PC端Url;
	@XmlElement private String price;
	@XmlElement private String detail;              // detail;
	@XmlElement private String status;              // status;

	@XmlElement(name="url_wap") private String urlWap;                  // 商品的WAP端Url;
	@XmlElement(name="promotion_price") private String promotionPrice;  // promotion_price;
	@XmlElement(name="wap_price") private String wapPrice;              // wap_price;

	@XmlElementWrapper(name="sub_item_ids")         // Wrapper的作用对象需要是Collection类型的?!;
	@XmlElement(name="sub_item_id")
	private List<String> subItemIds;                // sub_item_ids

	@XmlElementWrapper(name="pic_main")
	@XmlElement(name="img")
	private List<ProductInfoImg> mainImg;           // pic_main

	@XmlElementWrapper(name="pic_extra")
	@XmlElement(name="img")
	private List<ProductInfoImg> extraImg;          // pic_extra

	/** Setters: 14个, 注解不影响Setter的逻辑 */
	public void setVersion(String version) {
		this.version = version;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setUrlWap(String urlWap) {
		this.urlWap = urlWap;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public void setPromotionPrice(String promotionPrice) {
		this.promotionPrice = promotionPrice;
	}

	public void setWapPrice(String wapPrice) {
		this.wapPrice = wapPrice;
	}

	public void setSubItemIds(List<String> subItemIds) {
		this.subItemIds = subItemIds;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setMainImg(List<ProductInfoImg> mainImg) {
		this.mainImg = mainImg;
	}

	public void setExtraImg(List<ProductInfoImg> extraImg) {
		this.extraImg = extraImg;
	}

}
