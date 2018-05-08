/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twitterconsole.validation;

import twitterconsole.exception.StringValidationException;
import twitterconsole.validation.common.StringValidator;

/**
 *
 * @author User1
 */
public class UserProfileValidator {
    
    public static void validateUsername(String username) throws StringValidationException{
        if(username == null || username.isEmpty() ) {
            throw new StringValidationException(StringValidationMessageEnum.EMPTY_USERNAME);
        }else{
            if(!StringValidator.isAlphabetic("" + username.charAt(0) ) ){
                //1st character is not alphabetic
                throw new StringValidationException(StringValidationMessageEnum.USERNAME_FIRST_CHAR_NOT_ALPHABETIC);
            }
            if(StringValidator.containsSpecialCharacter(username) ){
                //contains special charaters
                throw new StringValidationException(StringValidationMessageEnum.CONTAINS_SPECIAL_CHARS);
            }
        }
    }
}
