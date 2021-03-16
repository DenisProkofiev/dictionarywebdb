package denis.dictionaries.web.exception;

import denis.dictionaries.web.utils.Helper;


public class NotRightLengthWordsException extends Exception {

    public NotRightLengthWordsException() {
    }

    public NotRightLengthWordsException(String s) {
        Helper.writeMessage(s);
    }
}
