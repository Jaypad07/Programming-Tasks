package com.codegym.task.task21.task2101;

/* 
Determine the network address

*/

public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        byte[] netWork = new byte[ip.length];

        for (int i = 0; i < ip.length; i++) {
            netWork[i] = (byte) (ip[i] & mask[i]);
        }
        return netWork;
    }

    public static void print(byte[] bytes) {
        for (byte x : bytes) {
            int num = Byte.toUnsignedInt(x);
            String bits = Integer.toBinaryString(num);
            String bit = String.format("%8s", bits).replace(' ', '0');
            System.out.print(bit);
            System.out.print(" ");
        }
        System.out.println();
    }
}
