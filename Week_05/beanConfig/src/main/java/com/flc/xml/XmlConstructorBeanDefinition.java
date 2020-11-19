package com.flc.xml;

import com.flc.bean.Class;
import com.flc.bean.Student;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @creator fanglc@anch.net
 * @createdTime 2020/11/18 20:37
 * @desc
 */
public class XmlConstructorBeanDefinition {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        String xmlResourcePath = "classpath:spring-config.xml";
        // 加载 XML 资源，解析并且生成 BeanDefinition
        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);
        // 依赖查找并且创建 Bean
        Class aClass = beanFactory.getBean(Class.class);
        System.out.println(aClass.toString());
    }
}
