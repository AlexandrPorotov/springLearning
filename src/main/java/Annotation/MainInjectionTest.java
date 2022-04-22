package Annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainInjectionTest {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        InjectionTest injectionTest = context.getBean(InjectionTest.class);

        context.close();
        /*Создан объект - TestInsideBean
          Создан объект - InjectionTest и в него внедрен TestInsideBean с помощью @Autowired
          Внимательно необходимо использовать данную аннотацию с интерфейсами. Потому что если мы
          в аргументах метода пропишем интерфейс, а реализаций будет несколько, Spring не поймет
          какую именно необходимо взять и внедрить.
          Аннотация Qualifier. Примеры - one and two.
          */
    }
}
