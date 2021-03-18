package denis.dictionaries.web.entity;

import javax.persistence.*;

@Entity
@Table(name="value")
public class Value {
    private Long id;

    private String value;

    private Long keyId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column
    public String getValue() {
        return value;
    }

    public void setValue(String key) {
        this.value = key;
    }


}

