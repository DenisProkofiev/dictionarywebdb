package denis.dictionaries.web.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("NUMERIC")
public class NumericKey extends AbstractKey {
}
