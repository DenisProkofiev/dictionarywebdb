package denis.dictionaries.web.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("LATIN")
public class LatinKey extends AbstractKey {

}
