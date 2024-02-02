package Training_java_SpringBoot.Cat.repository;

import Training_java_SpringBoot.Cat.entity.CatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatRepository extends JpaRepository<CatEntity, String> {
}
