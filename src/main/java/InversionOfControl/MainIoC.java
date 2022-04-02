package InversionOfControl;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainIoC {

    /** Инверсия управления IoC (Inversion of Control) - архитектурный принцип. Заключается в том, что объект не создает
     * сам свои зависимости, а получает их из вне. Например, через конструктор. Затем мы внердряем
     * зависимость.*/

    public static void main(String[] args) {

        /** Создаем объект контекста приложения, откуда будем запрашивать бины */
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        /** Запрашиваем бины у контекста. Мы получаем объект интерфейса Music, соответственно
         * поменять реализацию можем через контекст, не меняя код приложения.
         * В данном примере, есть две реализации интерфейса Music, но запрашиваем мы Music у контекста. Соответственно, получаем ту реализацию, которую прописали
         * в контексте.*/
        Music music = context.getBean("musicBean", Music.class);

        /** Внедрим зависимость в ручную.*/
        MusicPlayer musicPlayer = new MusicPlayer(music);

        musicPlayer.playMusic();
        /* Playing Wind cries Mary - при
        <bean id = "musicBean"
          class="InversionOfControl.RockMusic">
        </bean>*/
        /* Playing Hungarian Rhapsody - при
        <bean id = "musicBean"
          class="InversionOfControl.ClassicalMusic">
        </bean>*/
        /** Контекст необходимо закрывать после работы с ним */
        context.close();
    }

    /** Есть большое кол-во способов внедрения зависимостей.
     * 1) Через конструктор (как в данном примере)
     * 2) Через setter
     * 3) Через конфигурацию (scope, factory method)
     * 4) Через XML, аннотации или Java-код
     * 5) Процесс внедрения можно автоматизировать (Autowiring)*/
}
