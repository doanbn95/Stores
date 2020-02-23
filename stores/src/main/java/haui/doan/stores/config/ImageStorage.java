package haui.doan.stores.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app.settings")
@Data
public class ImageStorage {
    private String path;
}
