package com.example.dictionarywebdb.dictionary.dictionaryexception;

import com.example.dictionarywebdb.dictionary.utils.Helper;


public class NotRightSymbolsException extends Exception {
    public NotRightSymbolsException() {
    }

    public NotRightSymbolsException(String s) {
        Helper.writeMessage(s);
    }


}
