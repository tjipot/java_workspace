package org.fkit.converter;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// 自定义属性编辑器;
public class DateEditor extends PropertyEditorSupport {
	
	// 将传入的字符串数据转换成Date类型;
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = dateFormat.parse(text);
			setValue(date);
		    /**
		     * Set (or change) the object that is to be edited.
		     * @param value The new target object to be edited.  Note that this
		     *     object should not be modified by the PropertyEditor, rather
		     *     the PropertyEditor should create a new object to hold any
		     *     modified value.
		     * public void setValue(Object value) {	// 难怪不用对象来调用是此方法了:自带this;
		     *  this.value = value;
		     *  firePropertyChange();
		     *  }
		     * */
		} catch(ParseException e) {
			e.printStackTrace();
		}
	}
}
