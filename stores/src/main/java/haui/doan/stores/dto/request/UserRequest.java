package haui.doan.stores.dto.request;

import haui.doan.stores.enums.GenderEnum;
import haui.doan.stores.enums.RoleEnum;
import haui.doan.stores.persistenct.domain.User;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class UserRequest {
    private Long id;

    private String username;

    private int role;

    private Long imageId;

    private MultipartFile image;

    private String name;

    private int gender;

    private String address;

    private String phone;

    private String usernameOld;

    public User asUser() {
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setRole(RoleEnum.ofRole(role).getText());
        user.setName(name);
        user.setAddress(address);
        user.setPhone(phone);
        user.setGender(GenderEnum.ofCode(gender).isValue());
        return user;
    }
}
