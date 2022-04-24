package Annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OneAndTwoObject {

    private OneAndTwo oneAndTwo;

    @Autowired
    @Qualifier("two")
    public void setTwo(OneAndTwo oneAndTwo) {
        this.oneAndTwo = oneAndTwo;
        System.out.println("Объект two внедрен через сеттер");
    }

    @Autowired
    public OneAndTwoObject(@Qualifier("one") OneAndTwo oneAndTwo){
        System.out.println("OneAndTwoObject создан");
        System.out.println("Внедрен объект one через конструктор");
    }
    /*Внедрение зависимости через сеттер тоже самое
    * через поле тоже
    * просто пишем Autowired над кодом.
    * Так же spring по-барабану как называется метод, главное, что он для внедрения
    *
    * Все способы работают одинаково, однако если выбрал для проекта один стиль внедрения,
    * лучше придерживаться его везде в проекте.*/

}
