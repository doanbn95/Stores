package haui.doan.stores.service;

import haui.doan.stores.constant.CommonConstants;
import haui.doan.stores.dto.request.ImageRequest;
import haui.doan.stores.dto.request.UserRequest;
import haui.doan.stores.enums.GenderEnum;
import haui.doan.stores.enums.RoleEnum;
import haui.doan.stores.persistenct.domain.Image;
import haui.doan.stores.persistenct.domain.User;
import haui.doan.stores.persistenct.repository.UserRepository;
import haui.doan.stores.utils.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private ImageService imageService;

    @Override
    public User createUser(UserRequest request) {
        User user = request.asUser();
        user.setPassword("admin");
        ImageRequest imageRequest = new ImageRequest(request.getId(), request.getImage());
        Image image = imageService.saveImage(imageRequest);
        user.setImageId(image.getId());
        user.setImage(image);
        user.setDeleted(CommonConstants.DELETED.FALSE);
        return userRepository.save(user);
    }

    @Override
    public User updateUser(UserRequest request) {
        User user = userRepository.getOne(request.getId());
        user.setId(request.getId());
        user.setName(request.getName());
        user.setGender(GenderEnum.ofCode(request.getGender()).isValue());
        user.setAddress(request.getAddress());
        user.setPhone(request.getPhone());
        ImageRequest imageRequest = new ImageRequest(request.getId(), request.getImage());
        Image image = imageService.updateImage(imageRequest);
        user.setImageId(image.getId());
        user.setImage(image);
        return userRepository.save(user);
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findUserByUsernameEqualsAndDeletedFalse(username);
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.getOne(id);
        user.setDeleted(CommonConstants.DELETED.TRUE);
    }

    @Override
    public List<User> findUsersByDeletedAndRole(RoleEnum role, int deleted) {
        return userRepository.findAllByRoleEqualsAndDeletedIs(role.getText(), deleted);
    }

    @Override
    public boolean checkUserNameExists(String username, String usernameOld) {
        if (!StringUtils.isEmpty(username)) {
            User flag = userRepository.findUserByUsernameEqualsAndDeletedFalse(username);
            if (StringUtils.isEmpty(usernameOld)) {
                return flag == null;
            } else {
                return username.equals(usernameOld) || flag == null;
            }
        }
        return true;
    }
}
