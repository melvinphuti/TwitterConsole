/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twitterconsole.exception;

import twitterconsole.validation.StringValidationMessageEnum;

/**
 *
 * @author User1
 */
public class StringValidationException extends Exception{
    
    private final StringValidationMessageEnum message;
    public StringValidationException(StringValidationMessageEnum message){
        this.message = message;
    }
    
    @Override
    public String getMessage(){
        return message.getMessage();
    }
            
}
