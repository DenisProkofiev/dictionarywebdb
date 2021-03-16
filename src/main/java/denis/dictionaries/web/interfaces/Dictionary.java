package denis.dictionaries.web.interfaces;

import denis.dictionaries.web.entity.AbstractKey;
import denis.dictionaries.web.enums.DictionaryType;

import java.util.List;

public interface Dictionary<T extends AbstractKey> {

    List<T> getAll();

//    List<String> getPairList();

     boolean remove(String key);

     boolean removeValue(String key, String value);

    boolean updateValue(String key, String oldValue, String newValue);

    List<String> getValues(String key);

    boolean addPair(String key, String value);

    DictionaryType getType();

}
