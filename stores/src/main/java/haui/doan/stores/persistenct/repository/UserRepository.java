package haui.doan.stores.persistenct.repository;

import haui.doan.stores.persistenct.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByUsernameEqualsAndDeletedIs(String username, int deleted);

    List<User> findAllByRoleEqualsAndDeletedIs(String role, int deleted);
}
