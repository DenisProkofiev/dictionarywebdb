package denis.dictionaries.web.impl;

import denis.dictionaries.web.dao.KeyRepository;
import denis.dictionaries.web.entity.NumericKey;
import denis.dictionaries.web.enums.DictionaryType;
import denis.dictionaries.web.exception.NotRightLengthWordsException;
import denis.dictionaries.web.exception.NotRightSymbolsException;
import org.springframework.stereotype.Component;

@Component
public class NumericRealization extends AbstractDictionary<NumericKey> {
    public static final int KEY_AND_VALUE_SIZE = 5;
    public static final String NUMBER_PATTERN = "^[0-9]+$";


    public NumericRealization(KeyRepository<NumericKey> repository) {
        super(repository);
    }

    @Override
    public boolean dictionaryMatches(String keyCheck, int keyLength) {

        if (keyLength == KEY_AND_VALUE_SIZE) {
            if (keyCheck.matches(NUMBER_PATTERN)) {
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

    public static int getKeyAndValueSize() {
        return KEY_AND_VALUE_SIZE;
    }

    public static String getNumberPattern() {
        return NUMBER_PATTERN;
    }

    @Override
    public DictionaryType getType() {
        return DictionaryType.NUMERIC;
    }
}
