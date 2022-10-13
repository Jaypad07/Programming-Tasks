package com.codegym.task.task08.task0824;

/* 
Make a family

*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {

        ArrayList<Object> family = new ArrayList<>();
        ArrayList<Human> children = new ArrayList<>();
        ArrayList<Human> children1 = new ArrayList<>();
        ArrayList<Human> children2 = new ArrayList<>();
        ArrayList<Human> children3 = new ArrayList<>();

        Human grandFather1 = new Human("Cherri", true, 65, children1);
        Human grandFather2 = new Human("Camarino", true, 67, children);

        Human grandMother1 = new Human("Ana", false, 79, children1);
        Human grandMother2 = new Human("Ketty", false, 89, children);

        Human father = new Human("Jaime", true, 64, children2);
        Human mother = new Human("Sandra", false, 63, children2);

        Human child3 = new Human("Jay", true, 36, children3);
        Human child2 = new Human("Valerie", false, 39, children3);
        Human child1 = new Human("Erica", false, 42, children3);

        family.add(grandFather1);
        family.add(grandFather2);
        family.add(grandMother1);
        family.add(grandMother2);
        family.add(father);
        family.add(mother);
        family.add(child1);
        family.add(child2);
        family.add(child3);

        children.add(father);
        children1.add(mother);

        children2.add(child1);
        children2.add(child2);
        children2.add(child3);


        for (Object x : family) {
            System.out.println(x.toString());
        }

    }

    public static class Human {
        public String name;
        public boolean sex;
        public int age;
        public ArrayList<Human> children;

        public Human(String name, boolean sex, int age, ArrayList<Human> children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
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
