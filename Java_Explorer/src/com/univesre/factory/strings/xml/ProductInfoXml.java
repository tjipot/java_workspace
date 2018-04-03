package factory.strings.xml;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;  // 此OutputFormat非String中的Format, 此处是XML要Serialize的Format;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import org.junit.Test;

/* The JAXBContext class provides the client's entry point to the JAXB API. It provides an abstraction for
 * managing the XML/Java binding information necessary to implement the #JAXB binding framework# operations:
 * unmarshal, marshal and validate*/
import javax.xml.bind.JAXBContext;
/* The Marshaller class is responsible for governing the process of serializing Java content trees back into XML data */
import javax.xml.bind.Marshaller;
import javax.xml.transform.sax.SAXResult;   // Simple Api Xml;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @Project: java_demo
 * @PackageName: factory.strings.xml
 * @CreationDate: 2018-03-28 17:54
 * @Description: Ref[https://blog.csdn.net/u010648555/article/details/51681695],
 * @逻辑梳理: 1.将某些Bean类用"XmlElement"等注解标记之, 2.创建并实例化要转换成XML的Bean类, 3."objToCdataXml"具体转换实现, 4.IO到xml文件.
 * @Author: Haoran Ye
 * @ModificationHistory: Who When What
 */
public class ProductInfoXml {

	// private static Marshaller marshal;   // Never Used;

	/**
	 * @Title:
	 * @Description: 进行Xml内容填充, 进而生成Xml
	 * @Parameter: 
	 * @Return: 
	 * @Throws: 
	 **/
	@Test
	public void generateXml() throws Exception {

		// 1.包装"idList"参数;
		List<String> idList = new ArrayList<String>();
		idList.add("11_11_11");
		idList.add("22_22_22");
		idList.add("33_33_33");

		// 2.包装"productInfoImgList"参数;
		List<ProductInfoImg> productInfoImgList = new ArrayList<ProductInfoImg>();
		ProductInfoImg productInfoImg = null;
		for (int i = 0; i < 2; i++) {
			productInfoImg = new ProductInfoImg();
			productInfoImg.setUrl("-" + i + "-");
			productInfoImg.setSize("40×40");
			productInfoImgList.add(productInfoImg);
		}

		// 3.被XmlElement包装的对象;
		ProductInfoBean productInfoBean = new ProductInfoBean();
		productInfoBean.setVersion("1.0");
		productInfoBean.setId("1110");
		productInfoBean.setTitle("4K 高清");
		productInfoBean.setCategory("电视>4K>高清");
		productInfoBean.setUrl("http://baidu.com");
		productInfoBean.setUrlWap("http://baidu.wap.com");
		productInfoBean.setPrice("100");
		productInfoBean.setPromotionPrice("111");
		productInfoBean.setWapPrice("113");
		productInfoBean.setSubItemIds(idList);
		productInfoBean.setDetail("theDetail");
		productInfoBean.setStatus("1");
		productInfoBean.setMainImg(productInfoImgList);
		productInfoBean.setExtraImg(productInfoImgList);

		// 4.输出Xml字串;
		PrintWriter pw = new PrintWriter(new File("/Users/UNIVESRE/desktop/xmlTest.xml"));
		String cdataXmlStr = objToCdataXml(ProductInfoBean.class, productInfoBean);
		System.out.println(cdataXmlStr);   // 1.System.out的输出流;
		pw.println(cdataXmlStr);           // 2.PrintWriter的输出流;
		pw.close();
	}

	/**
	 * @Title:
	 * @Description: Helper Fn, 具体Bean到XML转换的逻辑实现
	 * @Parameter:
	 * @Return:
	 * @Throws:
	 **/
	public static String objToCdataXml(Class clazz, Object object) throws Exception {

		JAXBContext context = JAXBContext.newInstance(clazz);       // 接收需要转换成XML的Bean类(ProductInfoBean.class);
		OutputFormat outputFormat = new OutputFormat();             // Configure an OutputFormat to handle CDATA;
		outputFormat.setCDataElements( new String[]                 // outputFormat中需要添加"CDATA"标记的元素;
				{ "^title", "^category", "^url", "^url_wap", "^detail" } );
		outputFormat.setPreserveSpace(true);                        // Set any other options you like;
		outputFormat.setIndenting(true);

		/* ###1.This class implements an output stream in which the data is written into a byte array.
		 * The buffer automatically grows as data is written to it. The data can be retrieved using
		 * toByteArray() and toString(). ###2.Closing a ByteArrayOutputStream has no effect. The methods
		 * in this class can be called after the stream has been closed without generating an IOException. */
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();              // JAVA IO;
		XMLSerializer xmlSerializer = new XMLSerializer(byteArrayOutputStream, outputFormat);   // Create the serializer;
		SAXResult saxResult = new SAXResult(xmlSerializer.asContentHandler());

		Marshaller marShaller = context.createMarshaller();                                     // Marshaller;
		marShaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);                         // 属性设置;
		/* object为实例, 而非"ProductInfoBean.class": marshal中用saxResult格式对productInfoBean进行格式化, 理解这个marshal()函数
		 * 的关键是此函数作用于参数对象的内存, 而本身并不产生以及返回什么实际内容的值: 当它对byteArrayOutputStream对象的内存marshal了一遍后,
		 * 你再返回"byteArrayOutputStream"对象, 就达成格式转换的目的了 */
		marShaller.marshal(object, saxResult);

		return byteArrayOutputStream.toString("utf-8");
	}

	/**
	 * @Title:
	 * @Description: 程序入口
	 * @Parameter:
	 * @Return:
	 * @Throws:
	 **/
	public static void main(String[] args) throws Exception {
		ProductInfoXml productInfoXml = new ProductInfoXml();
		try {
			productInfoXml.generateXml();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
