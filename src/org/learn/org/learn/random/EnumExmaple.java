package org.learn.org.learn.random;

public class EnumExmaple {


    public enum Cases {
        Upper,
        Lower,
        Mixed
    }

    public void pirntCase(Cases cases) {

        if (cases == Cases.Lower) {
            System.out.println(cases.name());
        } else if (cases == Cases.Upper) {
            System.out.println(cases.name());
        } else {
            System.out.println(cases.name());
        }
    }


    public static void main(String[] args) {

        new EnumExmaple().pirntCase(Cases.Upper);
    }


}
