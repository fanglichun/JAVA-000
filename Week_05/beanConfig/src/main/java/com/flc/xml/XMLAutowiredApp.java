package com.flc.xml;

import com.flc.bean.Student;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @creator fanglc@anch.net
 * @createdTime 2020/11/18 20:37
 * @desc
 */
public class XMLAutowiredApp {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        String xmlResourcePath = "classpath:spring-config.xml";
        // 加载 XML 资源，解析并且生成 BeanDefinition
        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);
        // 依赖查找并且创建 Bean
        Student stu1 = beanFactory.getBean(Student.class);
        System.out.println(stu1);
        Object stu2 = beanFactory.getBean("stu1");
        System.out.println(stu2);
        System.out.println(stu1.equals(stu2));
        Object kClass = beanFactory.getBean("kClass");
        System.out.println(kClass);

    }
}
