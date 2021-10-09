package com.kv.concurrency.sorting;

import com.kv.concurrency.dto.Person;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.request.GetRequest;

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

    public static void main(String[] args) throws Exception{
        List<Person> people = add();
        System.out.println(people);
        people.sort((p1, p2) -> p1.getRanking() - p2.getRanking());
        System.out.println(people);

       /* HttpResponse<String> response = Unirest.get("https://alpha-vantage.p.rapidapi.com/query?function=GLOBAL_QUOTE&symbol=AAPL&datatype=json")
                .header("x-rapidapi-key", "f94a94563bmshef4a6c8b12dfa5fp19b6a1jsn69b2b177ed58")
                .header("x-rapidapi-host", "alpha-vantage.p.rapidapi.com")
                .asString();
        System.out.println(response.getBody());*/


        GetRequest getRequest = Unirest.get("https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=JPM&adjusted=true&outputsize=compact&apikey=M5YJO28B6QLN8EYF");
        System.out.println(getRequest.asJson().getBody());
    }
}
