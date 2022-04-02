package DependencyInjectionPathOne;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainDI {

    /** Применя IoC мы решаем проблему с зависимостью, однако все равно создаем классы в ручную.
     * Проблема - мы в ручную внедряем зависимость Music и вручную создаем класс MusicPlayer (см. пакет InversionOfControl).
     * Решение Dependency Injection (DI) - внедрение зависимостей. */

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        /** Теперь внедрим зависимость с помощью Spring, пропишем в контексте следующее:
          <bean id = "musicPlayer"
                    class="DependencyInjection.MusicPlayer">
                  <constructor-arg ref="musicBean" /> - именно здесь мы говорим Spring, что нам необходимо передать в класс MusicPlayer, класс Music при создании.
          </bean>*/

        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);

        musicPlayer.playMusic(); /*Playing Hungarian Rhapsody*/

        context.close();
    }

}
