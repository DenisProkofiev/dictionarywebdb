package denis.dictionaries.web.dao;

import denis.dictionaries.web.entity.AbstractKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KeyRepository<T extends AbstractKey> extends JpaRepository<T ,Long> {
    T findByKey(String key);

}
