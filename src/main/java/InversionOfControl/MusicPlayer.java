package InversionOfControl;

public class MusicPlayer {

    private Music music;

    /** Реализуем конструктор, через который будем передавать зависимость
     * IoC.
     * 1) Мы внедряем интерфейс, что позволяет работать нашему классу MusicPlayer с любой
     * реализацией класса Music.
     * 2) Мы уходим от жесткой зависимости класса MusicPlayer от класса Music*/
    public MusicPlayer(Music music) {
        this.music = music;
    }
    public void playMusic() {
        System.out.println("Playing " + music.getSong());
    }

}
