package Annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainInjectionTest {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        InjectionTest injectionTest = context.getBean(InjectionTest.class);

        context.close();
        /*Создан объект - TestInsideBean
          Создан объект - InjectionTest и в него внедрен TestInsideBean с помощью @Autowired*/
    }
}
