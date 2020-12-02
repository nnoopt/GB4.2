package GB1;

public class Main {

    
//1
    public static void main(String[] args) {

//2
    byte b1 = 1;
    short s1 = 1;
    int i1 = 1;
    long l1 = 1L;

    float f1 = 1.1f;
    double d1 = 1.1;

    char c1 = 'a';

    boolean bo1 = true;

    String str = "String";

//3
    System.out.println(metOne (1, 1, 1, 1));

//4
    System.out.println(metTwo(5,15));

//5
    metThree(-1);

//6
    System.out.println(metFour(-6));

//7
    metFive("Пётр");

//8
    metSix(2020);
    }

    public static int metOne (int a, int b, int c, int d){
        return a * (b + (c / d));
    }

    public static boolean metTwo (int a, int b){
        return a + b >= 10 && a + b <= 20;
    }

    public static void metThree (int a){
        if (a>=0) System.out.println("Положительное число");
        else System.out.println("Отрицательное число");
    }

    public static boolean metFour (int a){
        return a<0;
    }

    public static void metFive (String a){
        System.out.println("Привет, "+ a +"!");
    }

    public static void metSix (int a){
        String b = " не ";
        if (a%4==0 && a%100!=0 || a%400==0) b = " ";
        System.out.println(a + " год" + b + "високосный!");
    }
}
