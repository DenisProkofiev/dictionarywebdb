package denis.dictionaries.web.impl;

import denis.dictionaries.web.dao.LatinKeyRepository;
import denis.dictionaries.web.entity.LatinKey;
import denis.dictionaries.web.enums.DictionaryType;
import denis.dictionaries.web.exception.NotRightLengthWordsException;
import denis.dictionaries.web.exception.NotRightSymbolsException;
import org.springframework.stereotype.Component;

@Component
public class LatinRealization extends AbstractDictionary<LatinKey> {
    public static final int KEY_AND_VALUE_SIZE = 4;
    public static final String LATIN_PATTERN = "^[a-zA-Z0-9]+$";


    public LatinRealization(LatinKeyRepository repository) {
        super(repository);
    }

    @Override
    public boolean dictionaryMatches(String keyCheck, int keyLength) {

        if (keyLength == KEY_AND_VALUE_SIZE) {
            if (keyCheck.matches(LATIN_PATTERN)) {
                return true;
            } else {
                try {
                    throw new NotRightSymbolsException();
                } catch (NotRightSymbolsException e) {
                    e.printStackTrace();
                }
            }
        } else {
            try {
                throw new NotRightLengthWordsException();
            } catch (NotRightLengthWordsException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public LatinKey getAbstractKey() {
        return new LatinKey();
    }

    @Override
    public DictionaryType getType() {
        return DictionaryType.LATIN;
    }
}
