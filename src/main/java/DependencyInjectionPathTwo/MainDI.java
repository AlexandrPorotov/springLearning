package DependencyInjectionPathTwo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainDI {

    /** Применя IoC мы решаем проблему с зависимостью, однако все равно создаем классы в ручную.
     * Проблема - мы в ручную внедряем зависимость Music и вручную создаем класс MusicPlayer (см. пакет InversionOfControl).
     * Решение Dependency Injection (DI) - внедрение зависимостей. */

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        /** Теперь внедрим зависимость с помощью Spring, пропишем в контексте следующее:
         <bean id = "musicBean"
            class="DependencyInjectionPathTwo.ClassicalMusic">
         </bean>
         <bean id = "musicPlayer"
            class="DependencyInjectionPathTwo.MusicPlayer">
            <property name = "music" ref="musicBean"/> - здесь мы указываем что необходимо передать в метод setter. Важно что бы в классе был пустой конструктор.
                Так же важно прописывать все правильно setMusic и.т.д иначе Spring не сможет определить какой метод ему использовать.
         </bean>*/

        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);

        musicPlayer.playMusic(); /*Playing Hungarian Rhapsody*/

        System.out.println("private String name; /*<property name=\"name\" value=\"\"/>*/\n" +
                "private int volume; /*<property name=\"volume\" value=\"\"/>*/");

        System.out.println(musicPlayer.getName()); /*внедрили эти зависимости через setter в контексте spring*/
        System.out.println(musicPlayer.getVolume());

        /* Так же мы их можем устанавливать из конфигурационного файла. Для этого создаем musicPlayer.properties. Туда заносим значения типа
        * ключ - значение. И потом в конфигурации контекста прописываем ссылку на стороннюю конфигурацию бинов, а именно их примитивных полей
        * <context:property-placeholder location = "classpath:musicPlayer.properties"/>
        * musicPlayer.name = Some name
          musicPlayer.volume = 87
        * Spring возьмет две строки выше из конфигурации и поместит их в объект.*/
        context.close();

        /* Что происходит за кулисами. Spring создает объект musicPlayer используя пустой конструктор.
        * Затем он вызывает setMusic и передает туда bean Music.
        * В прошлой части он сразу же передавал объект bean при создании.
        * <property name="name" value= "${musicPlayer.name}"/>
        * <property name="volume" value="${musicPlayer.volume}"/> */

    }

}
