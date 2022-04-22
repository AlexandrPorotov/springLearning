package Annotation;

import org.springframework.stereotype.Component;

@Component
public class Two implements OneAndTwo{

    public Two(){
        System.out.println("Класс Two создан");
    }

    @Override
    public void go() {
        System.out.println("Two.class is run");
    }
}
