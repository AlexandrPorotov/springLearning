package Annotation;

import org.springframework.stereotype.Component;

@Component("one")
public class One implements OneAndTwo{

    public One(){
        System.out.println("Класс One создан");
    }

    @Override
    public void go() {
        System.out.println("One.class is run");
    }
}
