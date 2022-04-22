package Annotation;

import org.springframework.stereotype.Component;

@Component
public class TestInsideBean {

    public TestInsideBean(){
        System.out.println("Создан объект - TestInsideBean");
    }
}
