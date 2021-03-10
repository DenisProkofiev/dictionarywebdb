package com.example.dictionarywebdb.dictionary.factories;

import com.example.dictionarywebdb.dictionary.enums.DictionaryType;
import com.example.dictionarywebdb.dictionary.interfaces.Dictionary;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class DictionaryFactory {
    private final Map<DictionaryType,Dictionary> dictionaryMap;


    public DictionaryFactory(List<Dictionary> dictionaryList) {
        this.dictionaryMap = dictionaryList.stream().collect(Collectors.toMap(Dictionary::getType, Function.identity()));
    }

    public  Dictionary createDictionary(String path, DictionaryType implementation) {
        Dictionary dictionary = dictionaryMap.get(implementation);
        dictionary.initialized(path);
        return dictionary;
    }

}
