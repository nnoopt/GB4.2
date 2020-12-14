package GB1;

import java.util.Random;
import java.util.Scanner;

public class Main {


    static int X = 5;
    static int Y = 5;
    static int L = 4;

    static char[][] field = new char[Y][X];

    static char human = '+';
    static char computer = 'o';
    static char emptiness = '.';

    public static void goMass() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = emptiness;
            }
        }
    }


    public static void printField() {
        for (int i = 0; i < field.length; i++) {
            System.out.println();
            for (int j = 0; j < field[i].length; j++) {
                System.out.print("| " + field[i][j] + " ");
                if (j == field[i].length - 1) System.out.println("|");
            }
        }
        System.out.println("=======================================");
    }

    public static void go(char c) {
        System.out.println("Введи координаты");

        int x;
        int y;

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Веди X:");
            x = scanner.nextInt() - 1;
            System.out.println("Веди Y:");
            y = scanner.nextInt() - 1;

            if (isCorrectGo(y, x)) {
                field[y][x] = c;
                break;
            } else System.out.println("Ошибка. Введи корректные координаты.");

        }
    }

    public static void goAI() {
        Random random = new Random();

        int manager = 0;

            for (int i = 0; i <= field.length - L; i++) {

                if (manager>=1)break;
                for (int j = 0; j <= field[i].length - L; j++) {

                    if (manager>=1)break;
                    for (int k = 0; k < L; k++) {

                        if (manager>0)break;

                        for (int l = 0; l < L; l++) {
                            if (field[k + i][l + j] == computer) {
                                    if ((k + i+1) <= field.length-1 && field[k + i + 1][l + j] == emptiness) {
                                        field[k + i + 1][l + j] = computer;
                                        manager++;
                                        break;
                                   }
                                    if ((k + i-1) >= 0 && field[k + i - 1][l + j] == emptiness) {
                                        field[k + i - 1][l + j] = computer;
                                        manager++;
                                        break;
                                    }
                                }
                            }
                        }
                    }

            }

            while (true) {
                if (manager>=1)break;
                int y = random.nextInt(Y);
                int x = random.nextInt(X);

                if (isCorrectGo(y, x)) {
                    field[y][x] = computer;
                    break;
                }
            }

    }


    public static boolean isCorrectGo(int y, int x) {
        if (x < X && x >= 0 && y < Y && y >= 0 && field[y][x] == emptiness) return true;
        return false;
    }

    public static boolean emptyDots(char c[][]) {
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[i].length; j++) {
                if (c[i][j] == emptiness) return true;
            }
        }
        return false;
    }

    public static boolean win(char c, char[][] mass) {

        int countX = 0;
        int countY = 0;
        int countD1 = 0;
        int countD2 = 0;

        for (int i = 0; i <= mass.length-L; i++) {
            for (int j = 0; j <= mass[i].length-L; j++) {
                for (int k = 0; k < L; k++) {
                    countX = 0;
                    countY = 0;
                    for (int l = 0; l < L; l++) {
                        if (field[k+i][l+j]==c)countX++;
                        else countX=0;

                        if (field[l+j][k+i]==c)countY++;
                        else countY=0;

                        if ((k==l) && field [k+i][l+j]==c)countD1++;
                        if ((k==l) && field [k+i][l+j]!=c)countD1=0;

                        if (k == ((L-1-l)) && field [k+i][l+j]==c) countD2++;
                        if (k == ((L-1-l)) && field [k+i][l+j]!=c) countD2=0;

                        if (countD1==L||countD2==L||countX==L||countY==L)return true;
                    }
                }
            }
        }
        return false;
    }



    public static void main(String[] args) {
        goMass();

        while (true) {

            printField();
            go(human);

            if (win(human, field)) {
                System.out.println("Ура! Человек победил!");
                printField();
                break;
            }


            if (!emptyDots(field)) {
                System.out.println("Ничья!");
                printField();
                break;
            }

            goAI();
            if (win(computer, field)) {
                System.out.println("Ура! ИИ победил!");
                printField();
                break;
            }

            if (!emptyDots(field)) {
                System.out.println("Ничья!");
                printField();
                break;
            }
        }
    }
}


// не длоделал(

