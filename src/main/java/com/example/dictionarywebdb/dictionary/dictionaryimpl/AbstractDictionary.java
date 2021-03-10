package com.example.dictionarywebdb.dictionary.dictionaryimpl;

import com.example.dictionarywebdb.dictionary.interfaces.Dictionary;
import com.example.dictionarywebdb.dictionary.utils.Helper;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public abstract class AbstractDictionary implements Dictionary {
    private Map<String, String> mainMap = new HashMap<>();
    private Path fileSource;
    private String delimiter = ":";

    private Map<String, String> getMap() {
        Map<String, String> mapCopy = new HashMap<>(mainMap.size());
        mapCopy.putAll(mainMap);
        return mapCopy;
    }

    @Override
    public void initialized(String path) {
        if(fileSource != null) {
            return;
        }

       this.fileSource = Paths.get(path);

        if (Files.exists(this.fileSource)) {
            Helper.writeMessage("File is already exist");
        } else {
            try {
                Files.createFile(this.fileSource);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    private void clearMainMap() {
        mainMap.clear();
    }

    @Override
    public List<String> getPairList() {
        List<String> strings = null;
        try {
            strings = Files.readAllLines(fileSource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strings;
    }

    public abstract boolean dictionaryMatches(String keyCheck, String valueCheck, int keyLength, int valueLength);

    @Override
    public boolean addPair(String key, String value) {
        if (dictionaryMatches(key, value, key.length(), value.length())) {
            mainMap.put(key, value);
            updateMainMap();
            return true;
        }
        return false;
    }

    private void updateMainMap() {
        writer(mainMap);

        List<String> stringList = getPairList();

        clearMainMap();
        Stream<String> lines = stringList.stream();
        lines.filter(s -> s.contains(delimiter)).
                forEach(s -> mainMap.putIfAbsent(s.split(delimiter)[0], s.split(delimiter)[1]));

        Helper.writeMessage("Updating complete");
    }


    private void writer(Map<String, String> map) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(String.valueOf(fileSource)))) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String s = entry.getKey() + delimiter + entry.getValue() + System.lineSeparator();
                try {
                    writer.write(s);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean removePair(String key) {
        if (!mainMap.containsKey(key)) {
            Helper.writeMessage("The key is not contained in map");
            return false;
        }

        Helper.writeMessage("Are you sure want to delete pair {" + key + delimiter + mainMap.get(key) + "}? y:Yes or n:No");
        String answer = "";
        do {
            try {
                answer = Helper.readMessage();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (!answer.equalsIgnoreCase("y") && !answer.equalsIgnoreCase("n"));
        if (!mainMap.containsKey(key)) {

        }
        if (answer.equalsIgnoreCase("y")) {
            mainMap.remove(key);
            updateMainMap();
            return true;
        } else {
            Helper.writeMessage("You refused removing");
        }
        return false;
    }

    @Override
    public String getValue(String key) {
        return getMap().get(key);
    }


}
