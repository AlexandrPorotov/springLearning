package ConfigurationWithoutXml;

import AnnotationPartTwo.Polo;
import AnnotationPartTwo.Rapid;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTestCWX {
    /*Есть 3 способа конфигурации spring приложений -
    * 1) Через XML файл конфигурации (конфигурацию бинов прописываем в самом файле) - контекст
    * 2) Через XML файл конфигурации и с помощью аннотаций (помечаем классы в коде
    *    аннотациями, а в XML файле указываем какие пакеты необходимо сканировать)
    * 3) Java код + аннотации (без XML файла) вместо XML файла - класс конфигурации, помеченный
    *    аннотацией @Configuration
    *
    * Все теги из конфигурационного файла, есть в аннотациях.
    * Например - @ComponentScan("package").
    *
    * Тегу <bean> соответствует аннотация @Bean.
    *
    * Вместо обращения к файлу XML (config), используем другой объект, пример ниже в коде.
    * В аргументах передаем ему класс конфигурации.
    *
    * Внедрение зависимости вручную происходит следующим образом.
    *
    * @Bean
    * public Object crateObjectOne() {
    *   return new Object objectOne();
    * }
    *
    * @Bean
    * public Object creatObjectTwo() {
    *   return new Object objectTwo(createObjectOne());
    * }
    *
    * Scope, так же по умолчанию singleton.
    *
    * ! - Внесение данных в поля из внешнего файла.
    * Что бы подключить внешний файл properties, необходимо использовать аннотацию
    * @PropertySource("classpath")
    * Дальше в классах все через аннотацию @Value
    *
    * В качестве примера буду использовать код из пакета AnnotationPartTwo
    * */

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigAnnotationPartTwo.class);

        Polo polo = context.getBean(Polo.class);
        Rapid rapid = context.getBean(Rapid.class);

        System.out.println("----Создал объект Polo----");
        polo.getInfoOfCar();
        System.out.println("----Создал объект Rapid----");
        rapid.getInfoOfCar();


        context.close();
    }
}
