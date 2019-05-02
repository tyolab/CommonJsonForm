/*
 * Copyright (c) 2019. TYONLINE TECHNOLOGY PTY. LTD. (TYOLAB)
 *
 */

package au.com.tyo.json.validator;

public abstract class Validator {

    private String errorMessage;

    public Validator(String err) {
        errorMessage = err;
    }

    public abstract boolean isValid(Object object);

    // CharSequence fixText(CharSequence invalidText);


    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
