package Annotation;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OneAndTwoMain {
    /*Решение проблемы с пояснением для spring какую из реализаций интерфейса взять,
        это использование аннотации Qualifier
        пример в OneEndTwoObject*/
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        OneAndTwoObject oneAndTwoObject = context.getBean(OneAndTwoObject.class);

        context.close();

    }

}
