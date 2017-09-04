package com.univesre.crazy_java_notes.ch14_annotation.s3_event_listener;

import java.awt.event.ActionListener;
import java.lang.reflect.Field;

import javax.swing.AbstractButton;

/**
 * @ClassName: ActionListenerInstaller
 * @Description: TODO
 * @author: UNIVESRE
 * @date: 2017年6月26日 下午3:06:03
 */
public class ActionListenerInstaller {

	public static void processAnnotations(Object obj) {
		
		try {
			Class cl = obj.getClass();
			for(Field f : cl.getDeclaredFields()) {
				f.setAccessible(true);
				ActionListenerFor a = f.getAnnotation(ActionListenerFor.class);
				Object fObj = f.get(obj);
				// 如果f是AbstractButton的实例, 且a不为null;
				if(a != null && fObj != null && fObj instanceof AbstractButton) {
					// 获取a注解里的listener元数据(一个监听器类), ActionListenerFor类里有listener();;
					Class<? extends ActionListener> listenerClazz = a.listener();
					// 用反射建立listener类的对象;
					ActionListener al = listenerClazz.newInstance();
					AbstractButton ab = (AbstractButton)fObj;
					// 根据从listener()中取出的数据绑定事件监听器;
					ab.addActionListener(al);
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}		
	}
}
