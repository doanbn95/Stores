package haui.doan.stores.enums;

import lombok.Getter;

import java.util.EnumSet;

@Getter
public enum RoleEnum {

    ROLE_USER(0, "ROLE_USER"),
    ROLE_EMPLOYEE(1, "ROLE_EMP"),
    ROLE_ADMIN(2, "ROLE_ADMIN");

    private int role;
    private String text;

    //Constructor
    RoleEnum(int role, String text) {
        this.role = role;
        this.text = text;
    }

    public static RoleEnum ofRole(int role) {
        return EnumSet.allOf(RoleEnum.class).stream()
                .filter(roleEnum -> roleEnum.getRole() == role)
                .findFirst()
                .orElse(null);
    }

    public static RoleEnum ofText(String text) {
        return EnumSet.allOf(RoleEnum.class).stream()
                .filter(roleEnum -> roleEnum.getText().equals(text))
                .findFirst()
                .orElse(null);
    }

}
