package denis.dictionaries.web.impl;

import denis.dictionaries.web.dao.KeyRepository;
import denis.dictionaries.web.entity.AbstractKey;
import denis.dictionaries.web.entity.LatinKey;
import denis.dictionaries.web.entity.Value;
import denis.dictionaries.web.interfaces.Dictionary;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractDictionary<T extends AbstractKey> implements Dictionary<T> {

    public abstract boolean dictionaryMatches(String keyCheck, int keyLength);

    private KeyRepository<T> repository;

    public AbstractDictionary(KeyRepository<T> repository) {
        this.repository = repository;
    }

    public List<T> getAll() {
        return repository.findAll();
    }

    @Override
    public boolean remove(String key) {
        AbstractKey abstractKey = repository.findByKey(key);
        if (abstractKey == null) {
            return false;
        }
        repository.delete((T) abstractKey);
        return true;
    }


    @Override
    public boolean removeValue(String key, String value) {
        AbstractKey abstractKey = repository.findByKey(key);
        if (abstractKey == null) {
            return false;
        }
        abstractKey.getValues().removeIf(v -> v.getValue().equals(value));
        repository.save((T) abstractKey);

        return true;
    }

    @Override
    public boolean updateValue(String key, String oldValue, String newValue) {
        AbstractKey abstractKey = repository.findByKey(key);

        if (abstractKey == null) {
            return false;
        }

        abstractKey.getValues().stream()
                .filter(value -> value.getValue().equals(oldValue))
                .forEach(value -> value.setValue(newValue));
        repository.save((T) abstractKey);

        return true;

    }
    @Override
    public boolean addPair(String key, String value) {
        AbstractKey abstractKey = repository.findByKey(key);
        if (abstractKey == null) {

            Value newValue = new Value();
            newValue.setValue(value);

            AbstractKey newKey = new LatinKey();
            newKey.setKey(key);

            newKey.getValues().add(newValue);
            repository.save((T) newKey);
            return true;

        } else if (abstractKey.getValues().stream().noneMatch(v -> v.getValue().equals(value))) {
            Value newValue = new Value();
            newValue.setValue(value);

            abstractKey.getValues().add(newValue);
            repository.save((T)abstractKey);
            return true;
        }
        return false;
    }

    @Override
    public List<String> getValues(String key) {
        AbstractKey abstractKey = repository.findByKey(key);
        List<String> stringList = new ArrayList<>();

        return abstractKey.getValues()
                .stream().map(Value::getValue)
                .collect(Collectors.toList());

    }

}

