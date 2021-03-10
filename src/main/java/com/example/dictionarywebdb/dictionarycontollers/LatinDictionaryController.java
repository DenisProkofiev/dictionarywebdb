package com.example.dictionarywebdb.dictionarycontollers;

import com.example.dictionarywebdb.dictionary.factories.DictionaryFactory;
import com.example.dictionarywebdb.dictionary.interfaces.Dictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/")
public class LatinDictionaryController {
    private final DictionaryFactory dictionaryFactory;


    public LatinDictionaryController(DictionaryFactory dictionaryFactory) {
        this.dictionaryFactory = dictionaryFactory;
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
