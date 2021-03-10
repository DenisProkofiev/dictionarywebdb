package com.example.dictionarywebdb.dictionarycontollers;

import com.example.dictionarywebdb.dictionary.interfaces.Dictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class NumericDictionaryController {
    private Dictionary dictionary;

    public NumericDictionaryController(@Qualifier("numericRealization") Dictionary dictionary) {
        this.dictionary = dictionary;
    }


    @PutMapping(value = "/put")
    public boolean addPair(@RequestParam("key") String key, @RequestParam("value") String value) {
        return dictionary.addPair(key, value);
    }

    @GetMapping(value = "/getList")
    public List<String> getPairList() {
        return dictionary.getPairList();
    }

    @DeleteMapping(value = "/delete")
    public boolean removePair(String key) {
        return dictionary.removePair(key);
    }

    @GetMapping(value = "/get")
    public String getValue(String key) {
        return dictionary.getValue(key);
    }
}
