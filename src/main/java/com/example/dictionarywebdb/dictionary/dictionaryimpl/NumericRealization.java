package com.example.dictionarywebdb.dictionary.dictionaryimpl;

import com.example.dictionarywebdb.dictionary.dictionaryexception.NotRightLengthWordsException;
import com.example.dictionarywebdb.dictionary.dictionaryexception.NotRightSymbolsException;
import com.example.dictionarywebdb.dictionary.enums.DictionaryType;
import org.springframework.stereotype.Component;

@Component
public class NumericRealization extends AbstractDictionary {
    public static final int KEY_AND_VALUE_SIZE = 5;
    public static final String NUMBER_PATTERN = "^[0-9]+$";

    @Override
    public boolean dictionaryMatches(String keyCheck, String valueCheck, int keyLength, int valueLength) {

        if (keyLength == KEY_AND_VALUE_SIZE && valueLength == KEY_AND_VALUE_SIZE) {
            if (keyCheck.matches(NUMBER_PATTERN) && valueCheck.matches(NUMBER_PATTERN)) {
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
        return new String(NUMBER_PATTERN);
    }

    @Override
    public DictionaryType getType() {
        return DictionaryType.NUMBER;
    }
}
