package org.example;

public class SetUtilEJ6 {
    public static Set copy(Set set) {
        Set aux = new StaticSetEJ6();
        Set aux2 = new StaticSetEJ6();
        while(!set.isEmpty()) {
            int element = set.choose();
            aux.add(element);
            aux2.add(element);
            set.remove(element);
        }

        while(!aux2.isEmpty()) {
            int element = aux2.choose();
            set.add(element);
            aux2.remove(element);
        }

        return aux;
    }

    public static boolean in(int element, Set set) {
        Set copy = copy(set);
        while(!copy.isEmpty()) {
            int value = copy.choose();
            if(value == element) {
                return true;
            }
            copy.remove(value);
        }
        return false;
    }

    public static boolean subseteq(Set set, Set set2) {
        Set copy = copy(set);
        while(!copy.isEmpty()) {
            int element = copy.choose();
            if(!in(element,set2)){
                return false;
            }
            copy.remove(element);
        }
        return true;
    }


}
