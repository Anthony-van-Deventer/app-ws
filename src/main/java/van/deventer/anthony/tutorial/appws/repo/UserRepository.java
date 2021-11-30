package van.deventer.anthony.tutorial.appws.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import van.deventer.anthony.tutorial.appws.io.entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
}
