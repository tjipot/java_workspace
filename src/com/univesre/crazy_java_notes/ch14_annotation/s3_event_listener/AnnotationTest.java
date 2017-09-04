package com.univesre.crazy_java_notes.ch14_annotation.s3_event_listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * @ClassName: AnnotationTest
 * @Description: TODO
 * @author: UNIVESRE
 * @date: 2017年6月26日 下午2:59:51
 */
public class AnnotationTest {
	
	private JFrame mainWin = new JFrame("Binding Event Listener By Using Annotation");
	@ActionListenerFor(listener=OkListener.class)
	private JButton ok = new JButton("Comfirn");
	@ActionListenerFor(listener=CancelListener.class)
	private JButton cancel = new JButton("Cancel");
	
	public void init() {
		JPanel jp = new JPanel();
		jp.add(ok);
		jp.add(cancel);
		mainWin.add(jp);
		
		/* 用ActionListenerInstaller类来处理程序中的注解, 该处理器分析目标对象中的所有成员变量,
		 * 如果该成员变量前使用了@ActionListenerFor修饰, 则取出该Annotation中的listener元数据,
		 * 并根据该数据来绑定事件监听器; */
		ActionListenerInstaller.processAnnotations(this);
		mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWin.pack();
		mainWin.setVisible(true);
	}
	
	public static void main(String[] args) {
		new AnnotationTest().init();
	}
}

/**
 * @ClassName: OkListener
 * @Description: 默认访问权限是包内可访问
 * @author: UNIVESRE
 * @date: 2017年6月26日 下午2:59:59
 */
class OkListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent evt) {
		JOptionPane.showMessageDialog(null, "Clicked Confirm Button");
	}
	
}

class CancelListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "Clicked Cancel Button");	
	}
	
}


