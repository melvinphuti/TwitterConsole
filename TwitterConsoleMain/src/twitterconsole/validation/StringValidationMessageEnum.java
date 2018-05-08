/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twitterconsole.validation;

/**
 *
 * @author User1
 */
public enum StringValidationMessageEnum{
    EMPTY_USERNAME("Text is empty nor null."),
    CONTAINS_SPECIAL_CHARS("Text contains special characters."),
    INVALID_LINE_INPUT("Line input is invalid."),
    USERNAME_FIRST_CHAR_NOT_ALPHABETIC("First character must be alphabetic.");
    private final String message;

    StringValidationMessageEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
    
}

