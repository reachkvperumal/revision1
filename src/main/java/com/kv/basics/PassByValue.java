package com.kv.basics;

public class PassByValue {

    public static void update(Dog dog){
        System.out.println(dog.getName().equals("Maxi"));
        dog = new Dog("Mini");
        System.out.println(dog.getName().equals("Mini"));
        dog.setName("TEST");
    }
    public static void updateFieldValue(Dog dog){
        System.out.println(dog.getName().equals("Maxi"));
        dog.setName("Mini");
    }
    public static void main(String[] args) {
        Dog maxi = new Dog("Maxi");
        Dog max = maxi;
        update(maxi);
        System.out.println(maxi == max);
        System.out.println(maxi.getName());
        updateFieldValue(maxi);
        System.out.println(maxi.getName());
    }

    private static class Dog{
        private String name;

        public Dog(String n){
            this.name = n;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
