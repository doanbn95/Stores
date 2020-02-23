package haui.doan.stores.enums;

import lombok.Getter;

import java.util.EnumSet;

@Getter
public enum GenderEnum {
    MALE(false, 0),
    FEMALE(true, 1);

    private boolean value;
    private int code;

    GenderEnum(boolean value, int code) {
        this.value = value;
        this.code = code;
    }

    public static GenderEnum ofValue(boolean value) {
        return EnumSet.allOf(GenderEnum.class).stream()
                .filter(genderEnum -> genderEnum.isValue() == value)
                .findFirst()
                .orElse(null);
    }

    public static GenderEnum ofCode(int code) {
        return EnumSet.allOf(GenderEnum.class).stream()
                .filter(genderEnum -> genderEnum.getCode() == code)
                .findFirst()
                .orElse(null);
    }
}
