package AnnotationPartTwo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class AutomaticTransmission implements Transmission{

    @Override
    public void getInfoOfTransmission() {
        System.out.println("Автоматическая коробка передач.");;
    }

    public AutomaticTransmission(){
        System.out.println("[Создан объект - AutomaticTransmission]");
    }
}
