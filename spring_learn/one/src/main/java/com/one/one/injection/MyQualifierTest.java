package com.one.one.injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class MyQualifierTest {
    /// to over came this issue we can use @Primary or @Qualifier to specify which
    /// implementation we want to inject
    @Autowired
    @Qualifier("impl2")
    MyQualifierTestInterface myQualifierTestInterface;

    @Autowired
    Person person;
    /// if Person is not component then we have to specify which implementation we want to inject
    /// if it's a abstract class or interface then we have to specify which
    /// implementation we want to inject
}
@Component
class Person {

}

@Component
class Employee extends Person {

}

@Component
class Student extends Person {

}

interface MyQualifierTestInterface {
    void test();
}

@Component
@Primary
@Qualifier("impl1")
class MyQualifierTestImpl1 implements MyQualifierTestInterface {
    @Override
    public void test() {
        System.out.println("MyQualifierTestImpl1 test method called");
    }
}

@Component
@Qualifier("impl2")
class MyQualifierTestImpl2 implements MyQualifierTestInterface {
    @Override
    public void test() {
        System.out.println("MyQualifierTestImpl2 test method called");
    }
}

@Component
@Qualifier("impl3")
class MyQualifierTestImpl3 implements MyQualifierTestInterface {
    @Override
    public void test() {
        System.out.println("MyQualifierTestImpl2 test method called");
    }
}
