package denis.dictionaries.web.factories;

import denis.dictionaries.web.enums.DictionaryType;
import denis.dictionaries.web.interfaces.Dictionary;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class DictionaryFactory {
    private final Map<DictionaryType, Dictionary> dictionaryMap;

    public DictionaryFactory(List<Dictionary> dictionaryList) {
        this.dictionaryMap = dictionaryList.stream().collect(Collectors.toMap(Dictionary::getType, Function.identity()));
    }

    public Dictionary getDictionary(String implementation) {
        DictionaryType dictionaryType = DictionaryType.valueOf(implementation.toUpperCase(Locale.ROOT));
        return getDictionary(dictionaryType);
    }

    public Dictionary getDictionary(DictionaryType implementation) {
        return dictionaryMap.get(implementation);
    }

}
