package org.example.testovoe.repositorie;

import org.example.testovoe.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long>{
    List<UserModel> findAllByStatusEquals(Boolean status);
    List<UserModel> findAllByTimestampAfter(LocalDateTime timestamp);
    List<UserModel> findAllByStatusEqualsAndTimestampAfter(Boolean status, LocalDateTime timestamp);
    UserModel findUserModelByNameLike(String name);
    List<UserModel> findAllByIdIn(Collection<Long> ids);
}
