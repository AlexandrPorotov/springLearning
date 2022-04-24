package AnnotationPartTwo;

import org.springframework.stereotype.Component;

@Component
public class ManualTransmission implements Transmission{

    @Override
    public void getInfoOfTransmission() {
        System.out.println("Ручная коробка передач.");
    }

    public ManualTransmission(){
        System.out.println("[Создан объект - ManualTransmission]");
    }
}
