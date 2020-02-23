package haui.doan.stores;

import haui.doan.stores.config.ImageStorage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({ImageStorage.class})
public class StoresApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoresApplication.class, args);
    }

}
