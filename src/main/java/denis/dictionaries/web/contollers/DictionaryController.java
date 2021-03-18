package denis.dictionaries.web.contollers;

import denis.dictionaries.web.entity.AbstractKey;
import denis.dictionaries.web.factories.DictionaryFactory;
import denis.dictionaries.web.interfaces.Dictionary;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController("/")
public class DictionaryController {
    private final DictionaryFactory dictionaryFactory;


    public DictionaryController(DictionaryFactory dictionaryFactory) {
        this.dictionaryFactory = dictionaryFactory;
    }

    @PutMapping(value = "/{dictionaries}/put")
    public boolean add(@PathVariable(name = "dictionaries") String dictionary,
                           @RequestParam("key") String key,
                           @RequestParam("value") String value) {
        return dictionaryFactory.getDictionary(dictionary).add(key, value);
    }

    @GetMapping("/{dictionaries}/getAll")
    public List<AbstractKey> getOneDictionary (@PathVariable(name = "dictionaries") String dictionary) {
      return (List) dictionaryFactory.getDictionary(dictionary).getAll();
    }

    @GetMapping(value = "/getAll")
    public List<AbstractKey> getAll() {
        List<AbstractKey> result = new ArrayList<>();
        for (Dictionary dictionary : dictionaryFactory.getAllDictionary()) {
          result.addAll(dictionary.getAll());
        }
        return result;
    }

    @DeleteMapping(value = "/{dictionaries}/remove")
    public boolean remove(@PathVariable(name = "dictionaries") String dictionary,
                          @RequestParam String key) {
        return dictionaryFactory.getDictionary(dictionary).remove(key);
    }

    @DeleteMapping(value = "/{dictionaries}/removeValue")
    public boolean removeValue(@PathVariable(name = "dictionaries") String dictionary,
                               @RequestParam String key,
                               @RequestParam String value) {
        return dictionaryFactory.getDictionary(dictionary).removeValue(key, value);
    }

    @PutMapping(value = "/{dictionaries}/updateValue")
    public boolean updateValue(@PathVariable(name = "dictionaries") String dictionary,
                               @RequestParam String key,
                               @RequestParam String oldValue,
                               @RequestParam String newValue) {
        return dictionaryFactory.getDictionary(dictionary).updateValue(key, oldValue, newValue);
    }

    @GetMapping(value = "/{dictionaries}/getValues")
    public List getValues(@PathVariable(name = "dictionaries") String dictionary,
                          @RequestParam String key) {
        return dictionaryFactory.getDictionary(dictionary).getValues(key);
    }


}
