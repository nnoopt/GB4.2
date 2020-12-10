package GB1;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

            String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
            String s = " Предложение один     Теперь предложение  два    Тут предложение   три";

            one(3, 10);
            two(words);
            three (s);
    }


    public static void one(int attempts, int variants) {

        System.out.println("Задание 1");

        while (true) {

        System.out.println("Угадай число от 0 до " + (variants-1) + "!");
            Random random = new Random();
            Scanner sc = new Scanner(System.in);
            int r = random.nextInt(10);

            for (int i = attempts; i > 0; i--) {

                System.out.println("У тебя осталось попыток: " + i);
                System.out.println("Введи число ...");

                int s = sc.nextInt();

                if (s == r) {
                    System.out.println("Ура, ты угодал!");
                    break;
                } else {
                    System.out.println("Ты не угодал");
                    if (s > r) System.out.println("Твое число сшишком большое ..");
                    else System.out.println("Твое число сшишком маленькое .. ");
                }
            }
            int res;

            while (true) {
                System.out.println("Повторить игру? 1 - если НЕТ, 0 - если ДА");
                res = sc.nextInt();
                if (res == 1) break;
                if (res == 0) break;
            }

            if (res == 1) {
                System.out.println("Конец игры!");
                System.out.println("===================================");
                break;
            }

        }
    }


    public static void two (String [] words){
        Random random = new Random();
        String wordComputer = words[random.nextInt(words.length)];
        System.out.println("Угадай слово!");
        Scanner scn = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder("###############");
        while (true) {

            String wordPeople = scn.nextLine();

            for (int i = 0; i < wordComputer.length() && i<wordPeople.length(); i++) {
                if (wordComputer.charAt(i) == wordPeople.charAt(i)) stringBuilder.setCharAt(i, wordComputer.charAt(i));
            }
            System.out.println(stringBuilder);
            if (wordPeople.equalsIgnoreCase(wordComputer)) break;
        }
        System.out.println("Ура, ты угадал слово!");
        System.out.println("===================================");
    }

    public static void three (String s){
        System.out.println(s);
        String s1 = s.replaceAll(" +", " ");

        StringBuilder s2 = new StringBuilder(s1);

        for (int  i = s1.length()-1; i>= 0 ; i--) {
            if (s1.charAt(i)>= 'А' && s1.charAt(i)<= 'Я'){
                s2.setCharAt(i-1, '.');
                s2.insert(i, ' ');
            }
        }

        s2.delete(0, 2);
        if (s2.charAt(s2.length()-1)!='.') s2.append('.');
        System.out.println(s2);
        System.out.println("===================================");
    }
}