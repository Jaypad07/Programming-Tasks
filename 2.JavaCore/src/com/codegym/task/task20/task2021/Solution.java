package com.codegym.task.task20.task2021;

import java.io.*;

/* 
Serialization is prohibited

*/

public class Solution implements Serializable {
    public static class SubSolution extends Solution {
        public SubSolution() throws NotSerializableException {
            throw new NotSerializableException();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        objectOutputStream.writeObject(new SubSolution());

        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

        SubSolution Acopy = (SubSolution) objectInputStream.readObject();

        System.out.println(Acopy);
    }
}
