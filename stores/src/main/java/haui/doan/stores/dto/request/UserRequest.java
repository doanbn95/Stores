package haui.doan.stores.dto.request;

import lombok.Data;

import java.util.Date;

@Data
public class UserRequest {
    private Long id;

    private String userName;

    private String password;

    private int role;

    private int status;

    private Date createdDate;

    private String creator;

    private Date updatedDate;

    private String updater;

    private Date deleteDate;

    private String deletePerson;

    private String userNameOld;

}
