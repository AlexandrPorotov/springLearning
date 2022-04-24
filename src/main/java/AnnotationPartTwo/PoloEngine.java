package AnnotationPartTwo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@Component
public class PoloEngine implements Engine{

    @Value("${polo.poloEngine.mileage}")
    private int mileage;
    @Value("${polo.poloEngine.value}")
    private String value;

    @Override
    public void start() {
        System.out.println("Двигатель запущен.");
    }

    @Override
    public void getInfoOfEngine() {
        System.out.println("Двигатель (Polo). Пробег - " + mileage + ", объем - " + value);
    }

    public PoloEngine(){
        System.out.println("[Создан объект - PoloEngine]");
    }
}
