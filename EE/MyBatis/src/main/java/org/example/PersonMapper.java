package org.example;

import org.example.domain.Person;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


public interface PersonMapper {
    Person selectPerson(int id);

    Person selectPersonByName(String name);

    Person selectPersonByIdAndName(int id, String name);    // (arg0 arg1)  param1 param2
//    Person selectPersonByIdAndName(@Param("id") int id, @Param("name") String name);

    Person selectPersonByInstance(Person p);

    Person selectPersonByMap(Map<String, Object> map);

    Person selectPersonByList(List list1);

    List<Person> selectPersons(int age);

    Map selectPerson();

    Person selectPersonByIdWithDetails(int id);

}
