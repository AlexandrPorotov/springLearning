package ConfigurationWithoutXml;

import AnnotationPartTwo.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("AnnotationPartTwo")
@PropertySource("classpath:car.properties")
public class SpringConfigAnnotationPartTwo {

    /* Ручное внесение зависимостей, если классы размечены аннотациями, не нужно делать так.
    @Bean
    public PoloEngine poloEngine() {
        return new PoloEngine();
    }
    @Bean RapidEngine rapidEngine() {
        return new RapidEngine();
    }

    @Bean
    public ManualTransmission manualTransmission(){
        return new ManualTransmission();
    }

    @Bean
    public AutomaticTransmission automaticTransmission() {
        return new AutomaticTransmission();
    }

    @Bean
    public Polo polo(@Qualifier("poloEngine") Engine engine, @Qualifier("automaticTransmission") Transmission transmission) {
        return new Polo(engine,transmission);
    }
    @Bean
    public Rapid rapid(@Qualifier("rapidEngine") Engine engine, @Qualifier("manualTransmission") Transmission transmission){
        return new Rapid(engine,transmission);
    }

     */
}
