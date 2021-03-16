package denis.dictionaries.web.dao;

import denis.dictionaries.web.entity.LatinKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LatinKeyRepository extends JpaRepository<LatinKey, Long> {



}
