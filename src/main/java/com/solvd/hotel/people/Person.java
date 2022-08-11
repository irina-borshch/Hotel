package com.solvd.hotel.people;

import java.util.Objects;

public abstract class Person {
    private String name;
    private String lastName;
    private int age;

    public Person() {

    }

    public Person(String name, String lastName, int age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public abstract void introduce();

    @Override
    public String toString() {
        return getClass().getName() + "[name=" + getName() + ", lastName=" + getLastName() + ", age=" + getAge() + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName().hashCode(), getLastName().hashCode(), getAge());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return hashCode() == person.hashCode();
    }
    //@Override
    //public String toString() {
    //  return "Person{" +
    //       "name='" + name + '\'' +
    //         ", lastName='" + lastName + '\'' +
    //        '}';
    //  }
    // @Override
    //public boolean equals(Object o) {
    //  if (this == o) return true;
    //   if (o == null || getClass() != o.getClass()) return false;

    //   Person person = (Person) o;

    //   if (!getName().equals(person.getName())) return false;
    //   return getLastName().equals(person.getLastName());
    // }
    // @Override
    //public int hashCode() {
    //    int result = getName().hashCode();
    //    result = 31 * result + getLastName().hashCode();
    //    return result;
    // }
}
