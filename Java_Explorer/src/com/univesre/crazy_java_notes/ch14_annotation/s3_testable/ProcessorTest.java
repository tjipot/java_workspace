package com.univesre.crazy_java_notes.ch14_annotation.s3_testable;

import java.lang.reflect.Method;

/**
 * @ClassName: ProcessorTest
 * @Description: TODO
 * @author: UNIVESRE
 * @date: 2017年6月26日 下午1:55:28
 */
public class ProcessorTest {

    public static void process(String clazz) throws ClassNotFoundException {

        int passed = 0;
        int failed = 0;

        for (Method m : Class.forName(clazz).getMethods()) {
            if (m.isAnnotationPresent(Testable.class)) {
                try {
                    m.invoke(null);
                    passed++;
                } catch (Exception ex) {
                    System.out.println("Method " + m + " 运行失败_异常:" + ex.getCause());
                    failed++;
                }
            }
        }

        System.out.println("Running " + (passed + failed) + " Methods:\n" + failed + " Failed,\n" + passed + " Passed!");
    }
}
