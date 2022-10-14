package com.codegym.task.task09.task0902;

/* 
Stack trace revisited

My note: array[0] is always the StackTrace element, then array[1] will be the method that calls the element,
and so forth.

For instance, if Main calls Stack Trace, then Main becomes array[1]. Everything continuously
gets shifted to the right when a new method is called.

Or down if you're thinking in the form of a stack.

*/

public class Solution {
    public static void main(String[] args) throws Exception {
        method1();
    }

    public static String method1() {
        method2();
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }

    public static String method2() {
        method3();
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }

    public static String method3() {
        method4();
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }

    public static String method4() {
        method5();
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }

    public static String method5() {
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }

}
