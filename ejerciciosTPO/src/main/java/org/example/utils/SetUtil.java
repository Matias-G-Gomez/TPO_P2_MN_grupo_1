package org.example.utils;

import org.example.adt.Set;

public class SetUtil {

    public static void print(Set set){
        while(!set.isEmpty()){
            int element = set.choose();
            System.out.println(element);
            set.remove(element);
        }
    }
}
