package haui.doan.stores.persistenct.repository;

import haui.doan.stores.persistenct.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByUserNameIs(String userName);
}
