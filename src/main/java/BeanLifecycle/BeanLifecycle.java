package BeanLifecycle;

public class BeanLifecycle {

    /* Жизненный цикл bean(a).
    * -init-method
    * -destroy-method
    * -factory-method
    * Что происходит с бином.
    * 1) Запуск Spring приложения
    * 2) Запускается Spring контейнер
    * 3) Создается объект бина
    * 4) В бин внедряются зависимости (DI Dependency injection)
    * 5) Вызывается указанный init-method
    * 6) Бин готов к использованию -> использование бина (работа программы)
    * 7) Вызывается указанный destroy-method
    * 8) Остановка Spring приложения
    *
    * Init-method */
}
