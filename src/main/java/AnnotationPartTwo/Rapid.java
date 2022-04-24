package AnnotationPartTwo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.text.DateFormat;

@Getter
@Setter
@AllArgsConstructor
@Component
public class Rapid implements Car {

    @Value("${rapid.name}")
    private String name;
    private DateFormat age;

    private Engine engine;
    private Transmission transmission;

    @Override
    public void start() {
        System.out.println("Rapid start.");
    }

    @Override
    public void getInfoOfCar() {
        System.out.println("Марка - " + name);
        engine.getInfoOfEngine();
        transmission.getInfoOfTransmission();
    }

    @Autowired
    public Rapid(@Qualifier("rapidEngine") Engine engine, @Qualifier("manualTransmission") Transmission transmission){
        this.engine = engine;
        this.transmission = transmission;
        System.out.println("[Создан объект - Rapid]");
        System.out.println("[Внедрены бины - Engine, Transmission]");
    }

    @PostConstruct
    private void initMethod(){
        System.out.println("[init-method Rapid.class]");
    }

    @PreDestroy
    public void destroyMethod(){
        System.out.println("[Объект Rapid уничтожен.]");
    }
}
