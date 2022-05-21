package com.company.classes;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
    /**
     * Реализовать сериализацию/десериализацию данных в файл/из файла на диске для Задания №6 в виде отдельного класса с методами Save и Load.
     * Использовать независимых 2 способа: нативную Java-сериализацию и любую внешнюю библиотеку.
     * Предусмотреть автоматическое создание новой резервной копии файла данных при завершении работы программы, имя файла - метка времени
     * Реализовать восстановление данных из последней созданной копии при запуске.
     * */
public class Packer {
    public static void saveNative(TrianglesList trianglesList, String filename) {
        try {
            FileOutputStream fileOut = new FileOutputStream("./src/Pack/" + filename + ".txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(trianglesList);
            out.close();
            fileOut.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static TrianglesList loadNative(String fileName) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(fileName);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        TrianglesList trianglesList = (TrianglesList) objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();
        return trianglesList;
    }

    public static void autoSaveNative(TrianglesList trianglesList, String fileName) {
        try {
            FileOutputStream fileOut = new FileOutputStream("./src/Pack/" + fileName + LocalDate.now() + "-" + LocalDateTime.now().getHour() + "-" + LocalDateTime.now().getMinute() + "-" + LocalDateTime.now().getSecond() + ".txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(trianglesList);
            out.close();
            fileOut.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static TrianglesList autoLoadNative(String fileName) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(Objects.requireNonNull(new File("./src/Pack"+fileName).listFiles())[Objects.requireNonNull(new File("./src/Pack").listFiles()).length - 1]);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        TrianglesList trianglesList = (TrianglesList) objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();
        return trianglesList;
    }

    public static void saveJSON(TrianglesList trianglesList, String filename) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("./src/PackJSON/" + filename + ".json"), trianglesList);
    }

    public static TrianglesList loadJSON(String filename) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        TrianglesList trianglesList = objectMapper.readValue(new File(filename), TrianglesList.class);
        return  trianglesList;
    }

    public static void autoSaveJSON(TrianglesList trianglesList, String fileName) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("./src/PackJSON/" + fileName + LocalDate.now() + "-" + LocalDateTime.now().getHour() + "-" + LocalDateTime.now().getMinute() + "-" + LocalDateTime.now().getSecond() + ".json"), trianglesList);
    }

    public static TrianglesList autoLoadJSON(String fileName) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(Objects.requireNonNull(new File("./src/PackJSON").listFiles())[Objects.requireNonNull(new File("./src/PackJSON").listFiles()).length - 1], TrianglesList.class);
    }

}
