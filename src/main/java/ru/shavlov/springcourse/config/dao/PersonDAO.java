package ru.shavlov.springcourse.config.dao;

import org.springframework.stereotype.Component;
import ru.shavlov.springcourse.config.model.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int  PEOPLE_COUNT;

    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Tom", 15, "tom@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Jack", 30, "jack@yandex.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Max", 16, "maxic@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Alex", 90, "alexxx@yandex.ru"));
    }

    public List<Person> index(){
        return people;
    }

    public Person show(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person){
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatedPerson){
        Person personToBeUpdated = show(id);

        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }

    public void delete(int id){
        people.removeIf(person -> person.getId() == id);
    }
}
