package haui.doan.stores.dto.response;

import lombok.Data;

@Data
public class UserResponse {

    private Long id;

    private String username;

    private String role;

    private String image;

    private Long imageId;

    private String name;

    private int gender;

    private String address;

    private String phone;

    private String birthDay;

    private String usernameOld;

}
