package chucknorris;

import java.util.Scanner;

public class Main {
    public static class NotValidValueException extends Exception {
        public NotValidValueException(String errorMessage) {
            super(errorMessage);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Please input operation (encode/decode/exit):");
            String choice = scanner.nextLine();

            if(choice.equals("encode")) {

                System.out.println("Input string:");
                String msg = scanner.nextLine();

                String encodedMsg = encode(msg);

                System.out.println("Encoded string:");
                System.out.println(encodedMsg);

            } else if (choice.equals("decode")) {

                System.out.println("Input encoded string:");
                String msg = scanner.nextLine();

                try {
                    String encodedMsg = decode(msg);

                    System.out.println("Decoded string:");
                    System.out.println(encodedMsg);
                } catch (NotValidValueException e) {
                    System.out.println("Encoded string is not valid.");
                }

            } else if (choice.equals("exit")) break;
            else System.out.format("There is no '%s' operation\n", choice);

            System.out.println("");
        } while (true);
        System.out.println("Bye!");

        scanner.close();
    }

    public static String encode(String msg) {
        StringBuilder sb = new StringBuilder();

        char[] charMsg = msg.toCharArray();
        for (int i = 0; i < charMsg.length; i++) {
            String bString = "0000000" + Integer.toBinaryString(charMsg[i]);
            bString = bString.substring(bString.length() - 7);

            sb.append(bString);
        }
        String bString = sb.toString();

        sb.setLength(0);

        int j = 0;
        while (j < bString.length()) {
            char ch = bString.charAt(j);
            sb.append(ch == '0' ? "00" : "0").append(" ");

            while ( j < bString.length() && bString.charAt(j) == ch) {
                sb.append("0");

                j++;
            }

            sb.append(" ");
        }

        return sb.toString();
    }

    public static String decode (String msg) throws NotValidValueException {
        for (int i = 0; i < msg.length(); i++)
            if(msg.charAt(i) != '0' && msg.charAt(i) != ' ') throw new NotValidValueException("The encoded message includes characters other than 0 or spaces");

        String[] tocken = msg.split(" ");

        if(tocken.length % 2 != 0) throw new NotValidValueException("The number of blocks is odd");

        StringBuilder sb = new StringBuilder();

        int i = 0;
        while (i < tocken.length) {
            char ch = '\u0000';

            if (tocken[i].equals("0")) ch = '1';
            else if (tocken[i].equals("00")) ch = '0';
            else throw new NotValidValueException("The first block of each sequence is not 0 or 00");
            i++;

            sb.repeat(ch, tocken[i].length());
            i++;
        }
        String bString = sb.toString();

        if (bString.length() % 7 != 0) throw new NotValidValueException("The length of the decoded binary string is not a multiple of 7");

        sb.setLength(0);

        for (i = 0; i < bString.length(); i += 7) {
            char ch = (char)Integer.parseInt(bString.substring(i, i + 7), 2);
            sb.append(ch);
        }

        return sb.toString();
    }
}