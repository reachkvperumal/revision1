package com.kv.concurrency.sorting;

import com.kv.concurrency.dto.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonImpl {

    public static List<Person> add(){
        //to avoid unsupported operation exception - UOE ImmutableCollections.java:161
        return new ArrayList<>(List.of(new Person[]{new Person("Avantika",15,15),
                new Person("Avyukt",7,7),
                new Person("KV",25,Integer.MAX_VALUE),
                new Person("Anusha",24,-1)}));
    }

    public static void main(String[] args) {
        List<Person> people = add();
        System.out.println(people);
        people.sort((p1, p2) -> p1.getRanking() - p2.getRanking());
        System.out.println(people);

    }
}
