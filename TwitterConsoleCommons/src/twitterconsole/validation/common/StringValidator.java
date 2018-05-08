/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twitterconsole.validation.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author User1
 */
public class StringValidator {
    public static boolean containsSpecialCharacter(String text){
        boolean containsSpecialCharacter = false;
        Pattern pattern = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
           containsSpecialCharacter = true;
           break;
        }
        return containsSpecialCharacter;
    }
    
    public static boolean isAlphabetic(String name) {
        return name.matches("[a-zA-Z]+");
    }
}
