package DependencyInjectionPathTwo;

public class MusicPlayer {

    private Music music;
    private String name; /*<property name="name" value=""/>*/
    private int volume; /*<property name="volume" value=""/>*/

    /** Реализуем конструктор, через который будем передавать зависимость
     * IoC.
     * 1) Мы внедряем интерфейс, что позволяет работать нашему классу MusicPlayer с любой
     * реализацией класса Music.
     * 2) Мы уходим от жесткой зависимости класса MusicPlayer от класса Music*/
    public MusicPlayer(Music music) {
        this.music = music;
    }
    public MusicPlayer(){
        /* пустой конструктор необходим для внедрения зависимости через setter, так как Spring не сможет создать без него объект
        * ведь мы оставили только один конструктор, который требует поле Music (java всегда создает по умолчанию пустой конструктор,
        * однако если мы пишем свой, пустой пропадает).*/
    }
    public void setMusic(DependencyInjectionPathTwo.Music music){
        this.music = music;
    }
    public void playMusic() {
        System.out.println("Playing " + music.getSong());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
