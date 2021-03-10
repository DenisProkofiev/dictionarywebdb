package com.example.dictionarywebdb.dictionary.dictionaryexception;

import com.example.dictionarywebdb.dictionary.utils.Helper;


public class NotRightLengthWordsException extends Exception {

    public NotRightLengthWordsException() {
    }

    public NotRightLengthWordsException(String s) {
        Helper.writeMessage(s);
    }
}
