package haui.doan.stores.service;

import haui.doan.stores.dto.request.UserRequest;
import haui.doan.stores.dto.response.UserResponse;
import haui.doan.stores.enums.RoleEnum;
import haui.doan.stores.persistenct.domain.User;

import java.util.List;

public interface UserService {

    User createUser(UserRequest request);

    User updateUser(UserRequest request);

    UserResponse editUser(Long id);

    User getUserByUsername(String username);

    void deleteUser(Long id);

    List<User> findUsersByDeletedAndRole(RoleEnum role, int deleted);

    boolean checkUserNameExists(String username, String usernameOld);

    List<UserResponse> findUsers(RoleEnum role, int deleted);

}
