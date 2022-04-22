package Annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InjectionTest {

    private TestInsideBean testInsideBean;

    @Autowired
    public InjectionTest(TestInsideBean testInsideBean){
        System.out.println("Создан объект - InjectionTest и в него внедрен TestInsideBean с помощью @Autowired");
    }
}
