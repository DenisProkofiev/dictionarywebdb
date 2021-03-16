package denis.dictionaries.web.exception;

import denis.dictionaries.web.utils.Helper;


public class NotRightSymbolsException extends Exception {
    public NotRightSymbolsException() {
    }

    public NotRightSymbolsException(String s) {
        Helper.writeMessage(s);
    }


}
