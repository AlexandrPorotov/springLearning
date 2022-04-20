package Annotation;
/** В данном уроке рассмотрено простое создание бина при помощи аннотации @Component*/
/*Java аннотации - специальный тип комментариев в коде с помощью которых можно -
*   - Передавать какие-либо инструкции для Java компилятора. Пример - @Override.
*   - Передавать какие-либо инструкции для анализаторов исходного кода.
*   - Передавать метаданные, которые могут быть использованы либо Java приложением (с помощью рефлексии),
*     либо другими приложениями или фреймворками.
*
* Spring сканирует все классы и находит помеченные аннотациями, затем создает бины из этих классов.
*
* @Component - обозначает класс бин. Вместо XML. Если не указать Id - spring автоматически берет название класса и прописывает его с маленькой буквы.
* Что бы это работало, необходимо в конфигурационном файле указать spring, на необходимость сканировать файлы.
* <context:component-scan base-package="Annotation"/>
* base-package - указание пакета, в котором необходимо сканировать классы.
* */


import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationTestSpring {

    public static void main(String[] args) {

        /*Пришлось поменять версию Spring, т.к. была ошибка Exception in thread "main" org.springframework.beans.factory.BeanDefinitionStoreException: Failed to read candidate component class: file
        описание решения проблемы - Another reason is use of Spring 3 with Java 8. Java 8 requires Spring 4.
        https://stackoverflow.com/questions/22771826/beandefinitionstoreexception-failed-to-read-candidate-component-class*/

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        ComponentTest componentTest = context.getBean("componentTest", ComponentTest.class);

        componentTest.run();

        context.close();

    }

    /*Так же мы можем прописывать и scope аннотацией*/
}
