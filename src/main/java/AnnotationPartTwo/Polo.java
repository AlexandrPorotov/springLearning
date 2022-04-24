package AnnotationPartTwo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.text.DateFormat;

@Getter
@Setter
@AllArgsConstructor
@Component
@Scope("singleton") /*Просто для примера т.к. по умолчанию singleton*/
public class Polo implements Car{

    @Value("${polo.name}")
    private String name;
    private DateFormat age;

    private Engine engine;
    private Transmission transmission;

    @Override
    public void start() {
        System.out.println("Polo start.");
    }

    @Override
    public void getInfoOfCar() {
        System.out.println("Марка - " + name);
        engine.getInfoOfEngine();
        transmission.getInfoOfTransmission();
    }

    @Autowired
    public Polo(@Qualifier("poloEngine") Engine engine, @Qualifier("automaticTransmission") Transmission transmission){
        this.engine = engine;
        this.transmission = transmission;
        System.out.println("[Создан объект - Polo]");
        System.out.println("[Внедрены бины - Engine, Transmission]");
    }

    @PostConstruct
    private void initMethod(){
        System.out.println("[init-method Polo.class]");
    }

    @PreDestroy
    private void destroyMethod(){
        System.out.println("[Объект Polo уничтожен.]");
    }
}
