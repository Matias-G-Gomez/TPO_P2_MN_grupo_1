package org.example;

public class SuperconjuntoEJ6 extends StaticSetEJ6 {

    public SuperconjuntoEJ6() {
        super();
    }

    public boolean isSubset(Set set) {
        return SetUtilEJ6.subseteq(set, this);
    }

    public Set complement(Set set) {
        if (!this.isSubset(set)) {
            throw new IllegalArgumentException("El conjunto dado no es un subconjunto del superconjunto");
        }

        Set complementSet = new StaticSetEJ6();
        Set copySuperSet = SetUtilEJ6.copy(this);

        while (!copySuperSet.isEmpty()) {
            int element = copySuperSet.choose();
            if (!SetUtilEJ6.in(element, set)) { // Usa 'in' para verificar la pertenencia
                complementSet.add(element);
            }
            copySuperSet.remove(element);
        }

        return complementSet;
    }
}

