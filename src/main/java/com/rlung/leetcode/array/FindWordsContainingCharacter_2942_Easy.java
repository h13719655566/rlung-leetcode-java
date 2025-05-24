package com.rlung.leetcode.array;

import java.util.*;

public class FindWordsContainingCharacter_2942_Easy {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> list = new ArrayList<>();


        for(int i = 0; i<words.length; i++){
            char[] wordCode = words[i].toCharArray();
            for(int c : wordCode){
                if(c == (int)x){
                    list.add(i);
                    break;
                }
            }

        }
        return list;
    }

    public static void main(String[] args) {
        FindWordsContainingCharacter_2942_Easy solver = new FindWordsContainingCharacter_2942_Easy();


        String[] words = {
                "leet",
                "code"
        };

        char x = 'e';

        System.out.println(solver.findWordsContaining(words, x));
    }
}
