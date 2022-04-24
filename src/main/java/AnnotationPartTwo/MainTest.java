package AnnotationPartTwo;

/*Видео урока -
https://www.youtube.com/watch?v=oNfK1FJ7Lkw&list=PLAma_mKffTOR5o0WNHnY0mTjKxnCgSXrZ&index=12

 Аннотация @Value - позволяет внедрять данные в поля из файла конфигурации.
Первые два шага идентичны методу с использованием контекста.
1) Создаем файл properties, куда заносим пары - ключ=значение.
2) Указываем в контексте связь с данным файлом properties.
3) Указываем над полями аннотацию @Value и в качестве аргумента ссылку вида -
   ${musicPlayer.name}*/

/*Аннотация @Scope - отвечает за область видимости бинов.
* То есть за паттерн - singleton/prototype (по умолчанию singleton) */

/*Аннотации @PostContract и @PreDestroy
*  @PostContract - init-method
*  @PreDestroy - destroy-method
*  Что бы их использовать на java 9+ необходимо добавлять annotation-api в pom
*  Ссылка на сайт с описанием - https://www.baeldung.com/spring-postconstruct-predestroy*/

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Polo polo = context.getBean(Polo.class);
        Rapid rapid = context.getBean(Rapid.class);

        System.out.println("----Создал объект Polo----");
        polo.getInfoOfCar();
        System.out.println("----Создал объект Rapid----");
        rapid.getInfoOfCar();


        context.close();
    }
}
