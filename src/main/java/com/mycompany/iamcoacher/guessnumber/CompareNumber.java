package com.mycompany.iamcoacher.guessnumber;

/**
 * Created by wfsovereign on 15-3-12.
 */
public class CompareNumber {
    public String getTips(String input,String answer){
        if(input.equals(answer)){
            return "4A0B";
        }
        int containCount = 0;
        for (int i = 0; i < input.length(); i++) {
            if(answer.contains(String.valueOf(input.charAt(i)))){
                containCount++;
            }
        }
        if (containCount == 0){
            return "0A0B";
        }
        return null;
    }
}
