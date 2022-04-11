package BeanScope;

import DependencyInjectionPathTwo.MusicPlayer;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainBeanScope {
    /* Bean scope - область видимости бинов. Это функция отвечающая за метод создания объектов
    *  например -
    *  1) Singleton - используется по умолчанию. Паттерн проектирования при котором, создается
    *     единственный экземпляр объекта (конструктор проверят условие, null or not).
    *     В spring создается объект в единственном экземпляре (если не указан другой параметр), до вызова
    *     метода .getBean().
    *     При всех вызовах метода .getBean() возвращается ссылка на один и тот же объект.
    *
    *
    *  2) Prototype - создает каждый раз при вызове метода .getBean() новый объект. Создает его каждый раз.
    *     */

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        MusicPlayer musicPlayer1 = context.getBean("musicPlayer", MusicPlayer.class);
        MusicPlayer musicPlayer2 = context.getBean("musicPlayer", MusicPlayer.class);

        /* Создал два объекта, запросив их у контекста Spring. Т.к. по-умолчанию стоит scope=singleton. Получил
        *  две ссылки, которые указывают на один и тот же объект. Ниже реализованна проверка данного условия.*/
        if (musicPlayer1.equals(musicPlayer2)) {
            System.out.println("singleton"); } else {
            System.out.println("prototype");
        }
        System.out.println(musicPlayer1.hashCode());
        System.out.println(musicPlayer2.hashCode());

        // Если в контексте мы пропишем scope = prototype, то получим обратную картину.

        // Особенность использования singleton заключается в том, что если мы создаем несколько объектов. То
        // по факту работаем с одним и тем же объектом.
        // Например - у нас есть много пользователей музыкального проигрывателя. Получается если кто-то один
        // поменяет настройки громкости, то они поменяются у всех пользователей. Так как был использован
        // scope по умолчанию, и были созданы объекты типа singleton.

    }
}
