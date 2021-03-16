package denis.dictionaries.web.contollers;

import denis.dictionaries.web.factories.DictionaryFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/")
public class DictionaryController {
    private final DictionaryFactory dictionaryFactory;


    public DictionaryController(DictionaryFactory dictionaryFactory) {
        this.dictionaryFactory = dictionaryFactory;
    }

    @PutMapping(value = "/{dictionaries}/put")
    public boolean addPair(@PathVariable(name = "dictionaries") String dictionary,
                           @RequestParam("key") String key,
                           @RequestParam("value") String value) {
        return dictionaryFactory.getDictionary(dictionary).addPair(key, value);
    }

    @GetMapping(value = "/{dictionaries}/getList")
    public List getPairList(@PathVariable(name = "dictionaries") String dictionary) {
        return dictionaryFactory.getDictionary(dictionary).getAll();
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

    @GetMapping(value = "/{dictionary}/getValues")
    public List<String> getValues(@PathVariable(name = "dictionaries") String dictionary,
                          @RequestParam String key) {
        return dictionaryFactory.getDictionary(dictionary).getValues(key);
    }


}
