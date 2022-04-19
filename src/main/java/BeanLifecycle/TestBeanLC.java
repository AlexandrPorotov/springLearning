package BeanLifecycle;

public class TestBeanLC {

    private Count count;

    private int number;

    public Count getCount() {
        return count;
    }

    public void setCount(Count count) {
        this.count = count;
    }

    /*Тестовый объект для проверки инит и дестрой метода*/
    private void doMyInit() {
        //System.out.println("init-method TestBeanLC run");
        number = count.plus() + 1; /*Костыль, если добавить начало с 1 в count, то результат в конце 4 (хотя объект создаю 3 раза).
        Видимо потому что spring еще кладет 1 бин про запас в контейнер не выводя его при этом в "свет".*/
        System.out.println("Создан объект № " + number );
    }
    public void run() {
        //System.out.println("TestBeanLC - run");
        System.out.println("Объект № " + number + " в работе");
    }
    private void doMyDestroy() { /* не будет выполнятся у бинов со scope - prototype*/
        //System.out.println("destroy_method TestBeanLC run");
        System.out.println("Удален объект № " + number );
    }
}
