package haui.doan.stores.persistenct.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
@Data
@Setter
@Getter
public class UserPrincipal extends User {
    private User user;

}
