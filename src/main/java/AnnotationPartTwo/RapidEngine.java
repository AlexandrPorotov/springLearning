package AnnotationPartTwo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RapidEngine implements Engine{

    @Value("${rapid.rapidEngine.mileage}")
    private int mileage;
    @Value("${rapid.rapidEngine.value}")
    private String value;

    @Override
    public void start() {
        System.out.println("Двигатель запущен.");
    }

    @Override
    public void getInfoOfEngine() {
        System.out.println("Двигатель (Rapid). Пробег - " + mileage + ", объем - " + value);
    }

    public RapidEngine(){
        System.out.println("[Создан объект - RapidEngine]");
    }
}
