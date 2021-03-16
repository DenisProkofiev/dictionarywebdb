package denis.dictionaries.web.dao;

import denis.dictionaries.web.entity.NumericKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NumericKeyRepository extends JpaRepository<NumericKey, Long> {

    NumericKey findByKey(String key);

}
