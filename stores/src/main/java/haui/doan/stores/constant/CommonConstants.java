package haui.doan.stores.constant;

import lombok.Data;

@Data
public class CommonConstants {
    public static final String RESOURCE_BUNDLE_COMMON = "messages";

    public interface DELETED {
        int TRUE = 1;
        int FALSE = 0;
    }

    public interface IMAGE_DEFAULT {
        String NAME = "default.png";
        String CONTENT = "Admin";
        String URL = "/upload/default.png";
    }

    public interface DATE_FORMAT {
        String YYYY_MM_DD = "yyyy-MM-dd";
        String MM_DD_YYYY = "MM-dd-yyyy";
    }

}
