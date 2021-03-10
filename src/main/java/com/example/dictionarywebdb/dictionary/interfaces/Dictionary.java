package com.example.dictionarywebdb.dictionary.interfaces;

import com.example.dictionarywebdb.dictionary.enums.DictionaryType;

import java.util.List;

public interface Dictionary {

     List<String> getPairList();

     boolean removePair(String key);

     String getValue(String key);

     boolean addPair(String key, String value);

    DictionaryType getType();

    void initialized(String path);
}
