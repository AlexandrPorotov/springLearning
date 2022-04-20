package Annotation;


import org.springframework.stereotype.Component;

@Component("componentTest")
public class ComponentTest {

    public ComponentTest(){}

    public void run() {
        System.out.println("Объект с аннотацией @Component");
    }

}
