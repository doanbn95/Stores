package haui.doan.stores.constant;

import lombok.Data;

@Data
public class CommonConstants {

    public interface DELETED {
        int TRUE = 1;
        int FALSE = 2;
    }

    public interface IMAGE_DEFAULT {
        String NAME = "default.png";
        String CONTENT = "Admin";
        String URL = "/upload/default.png";
    }

}
