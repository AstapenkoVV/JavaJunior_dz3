package ru.gb.dz.lesson3;

import java.io.*;

public class Program {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person person = new Person("Andrey", 33);

        try (FileOutputStream fileOutputStream = new FileOutputStream("./src/main/java/ru/gb/dz/lesson3/PersonData.bin");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(person);
            System.out.println("Объект Person сериализован.");
        }

        try (FileInputStream fileInputStream = new FileInputStream("./src/main/java/ru/gb/dz/lesson3/PersonData.bin");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            person = (Person) objectInputStream.readObject();
            System.out.println("Объект Person десериализован.");
            System.out.println("Имя: " + person.getName());
            System.out.println("Возраст: " + person.getAge());
        }
    }
}
