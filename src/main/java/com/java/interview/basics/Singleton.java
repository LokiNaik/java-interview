package com.java.interview.basics;

public class Singleton {
        private static Singleton instance;

        private Singleton(){
            // Default const.
        }

        public static synchronized Singleton getInstance(){
            if (instance == null){
                instance  = new Singleton();
            }
            return instance;
        }
}

class Test{
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        Singleton x2 = Singleton.getInstance();
        Singleton x3 = Singleton.getInstance();

        if (singleton == x2 && singleton == x3 ){
            System.out.println("Same");
            System.out.println(singleton.toString());
            System.out.println(x3);
            System.out.println(x2);
        }

    }
}
