package GB1;

public class Main {

    public static void main(String[] args) {

// 1.
        numWork(1);

        int [] mas = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < mas.length; i++) mas [i]=(mas[i]==0)?1:0;

        for (int r: mas) System.out.print(r + " ");

        line();

// 2.
        numWork(2);
        int [] masTwo = new int [8];
        for (int i = 0; i < masTwo.length; i++) masTwo[i]=i*3;

        for (int t : masTwo) System.out.print(t + " ");
        line();
// 3.
        numWork(3);
        int [] masThree = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i <masThree.length ; i++) if (masThree[i]<6)masThree[i]*=2;

        for (int t : masThree) System.out.print(t + " ");

        line();

// 4.
        numWork(4);
        int k = 10;
        int [][] masFour= new int [k][k];

        for (int i = 0; i < masFour.length; i++) {
             System.out.println();
            for (int j = 0; j < masFour[i].length; j++) {
                masFour[i][j] = (i==j||masFour.length-i-1==j)?1:0;
                   System.out.print(masFour[i][j] + " ");
            }
        }

        line();
// 5.
        numWork(5);
        int [] masFive = {5, 1, 5, 7, 1, 7, 0, 0};

        int max= masFive[0];
        int min= masFive[0];

        for (int j : masFive) {
            if (max <= j) max = j;
            if (min >= j) min = j;
        }

        System.out.print ("Максимальный элемент имеет значение: "+ max + ", в массиве под номерами: ");
        for (int i = 0; i <masFive.length ; i++) if (masFive[i] == max) System.out.print(i + " ");
        System.out.println();
        System.out.print ("Минимальный элемент имеет значение: "+ min + ", в массиве под номерами: ");
        for (int i = 0; i <masFive.length ; i++) if (masFive[i] == min) System.out.print(i + " ");

        line();

// 6.
        numWork(6);
        int [] masSix = {4, 5, 9};

        System.out.println(metSix(masSix));
        line();
// 7.
        numWork(7);
        int [] masSeven = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int step = -1;

        System.out.println("Массив до: ");
        for (int t : masSeven) System.out.print(t);
        System.out.println();
        System.out.println("Смещение на " + step);

        metSeven(masSeven, step);
        for (int t : masSeven) System.out.print(t);

        line();

    }


    public static int [] metSeven (int [] ar, int b) {

        if (b<0)b=ar.length - b;

        while (b>0) {
            int buffer = ar[0];
            for (int i = 0; i < ar.length - 1; i++) {
                int n = (i < ar.length - 1) ? i + 1 : 0;
                ar[i] = ar[n];
                ar[n] = buffer;
            }
            b--;
        }
        return ar;
    }


    public static boolean metSix (int[] mas) {

        int sumL = 0;
        int sumR = 0;
        for (int t : mas) sumR += t;
        for (int ma : mas) {
            sumL = sumL + ma;
            if (sumL == sumR - sumL) return true;
        }
        return false;
    }

    public static void numWork(int q){
        System.out.println("Задание № " + q);
    }

    public static void line(){
        System.out.println();
        System.out.println("--------------------------------------------------------------------------");
    }
}



