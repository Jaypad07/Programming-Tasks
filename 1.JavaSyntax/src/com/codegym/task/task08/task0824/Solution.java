package com.codegym.task.task08.task0824;

/* 
Make a family

*/

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) {

        ArrayList<Object> family = new ArrayList<>();

        Human child3 = new Human("Jay", true, 36);
        Human child2 = new Human("Valerie", false, 39);
        Human child1 = new Human("Erica", false, 42);


        Human father = new Human("Jaime", true, 64, child1, child2, child3);
        Human mother = new Human("Sandra", false, 63, child1, child2, child3);

        Human grandMother1 = new Human("Ana", false, 79, mother);
        Human grandFather1 = new Human("Welito", true, 65, mother);

        Human grandMother2 = new Human("Ketty", false, 89, father);
        Human grandFather2 = new Human("Camarino", true, 67, father);

        family.add(grandFather2);
        family.add(grandMother2);
        family.add(grandFather1);
        family.add(grandMother1);

        family.add(father);
        family.add(mother);
        family.add(child1);
        family.add(child2);
        family.add(child3);

        for (Object x : family) {
            System.out.println(x.toString());
        }

    }

    public static class Human {
        public String name;
        public boolean sex;
        public int age;
        public ArrayList<Human> children = new ArrayList<>();

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human... children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            Collections.addAll(this.children, children);
        }

        public String toString() {
            String text = "";
            text += "Name: " + this.name;
            text += ", sex: " + (this.sex ? "male" : "female");
            text += ", age: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", children: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
