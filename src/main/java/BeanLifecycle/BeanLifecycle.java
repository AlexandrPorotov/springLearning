package BeanLifecycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifecycle {

    /* Жизненный цикл bean(a).
    * -init-method
    * -destroy-method
    * -factory-method
    * Что происходит с бином.
    * 1) Запуск Spring приложения
    * 2) Запускается Spring контейнер
    * 3) Создается объект бина
    * 4) В бин внедряются зависимости (DI Dependency injection)
    * 5) Вызывается указанный init-method
    * 6) Бин готов к использованию -> использование бина (работа программы)
    * 7) Вызывается указанный destroy-method
    * 8) Остановка Spring приложения
    *
    * Init-method
    * Метод, который запускается в ходе инициализации бина. Инициализация ресурсов. Обращение к внешним файлам.
    * Открытие соединения с БД.
    *
    * Destroy-method
    * Метод, который запускается в ходе уничтожения бина. При завершении приложения.
    * Очищение ресурсов. Закрытие потоков ввода/вывода. Закрытие соединений с БД.*/
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        TestBeanLC testBeanLC1 = context.getBean("testBeanLC", TestBeanLC.class); /*запросил бин (создал его) был вызван инит метод*/
        TestBeanLC testBeanLC2 = context.getBean("testBeanLC", TestBeanLC.class);
        TestBeanLC testBeanLC3 = context.getBean("testBeanLC", TestBeanLC.class);
        testBeanLC1.run(); /*вызвал метод у объекта*/
        context.close(); /** ЕСЛИ У БИНА SCOPE PROTOTYPE - он не выполняет destroy метод!!! (оч долго ломал голову).*/
        /*init-method TestBeanLC run
        TestBeanLC - created */

        /* В классе TestBeanLC указан init и destroy методы. Так же в контексте спринга в бине, прописаны их
        * названия. При создании бина, spring берет и запускает метод init который прописан в контексте и реализован
        * в классе бина. При удалении тоже самое, только с destroy методом. */

        /* Для большей наглядности сделал счётчик.
        * У счётчика есть статическое поле count. И методы инкремента.
        * Конструктор, сеттер и геттер для spring.
        * При создании объекта TestBeanLC. Происходит внедрение зависимости через сеттер.
        * Затем в init методе он считает номер объекта и записывает его уже в поле объекта. Так как
        * scope бина TestBeanLC - prototype*/

        /*
        * Создан объект № 1
          Создан объект № 2
          Создан объект № 3
          Объект № 1 в работе*/


        /*Фабричный метод - паттерн проектирования.
        * Статья про паттерн "Фабричный Метод" (Factory Method) - https://refactoring.guru/ru/design-pa...
        * В Spring в property так же можно указать factory-method для создания класса.
        * То есть, мы создаем класс не через оператор new, а через специальный метод. Но внутри него все равно через new.
        * Если мы это применяем, необходимо прописывать конфигурацию бина.
        * Для реализации, нужен приватный конструктор. Что бы объект можно было создать только через фабричный метод.
        * Этот метод должен быть публичным, статическим.
        * Пример
        *
        * private Object() {} приватный конструктор
        *
        * public static Object getObject () { метод возвращающий новый объект
        *   return new Object();
        * }
        *
        * важно сказать об этом Spring
        * <property factory-method .../>*/


    }
}
