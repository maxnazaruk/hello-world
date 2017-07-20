package mainPack;

/**
 * Created by Max on 7/18/2017.
 */
public class secondary {
    public static void main(String[] args) {
        int[][] arr = {{3, 0, 2, 1},
                {5, 6, 7, 8},
                {9, 10, 13, 12},
                {3, 14, 15, 11}};

        navigation(arr, 3, 0, 2);

    }

    public static void navigation(int[][] a, int number, int targetRow, int targetPlace) {
        int rowNumber = findNumber(a, number)[0];
        int placeNumber = findNumber(a, number)[1];

        if (targetRow == rowNumber && targetPlace == placeNumber) {
            return;
        }

        if (targetRow == rowNumber) {

            onSameRow(a, number, targetRow, targetPlace);
            System.out.println("!@#!@#");
        }



    }

    public static int[] findZero(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] == 0) {
                    int[] result = {i, j};
                    return result;
                }
            }
        }
        return null;
    }

    public static int[] findNumber(int[][] a, int number) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] == number) {
                    int[] result = {i, j};
                    return result;
                }
            }
        }
        return null;
    }

    public static void showMatrix(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void onSameRow(int[][]a, int number, int targetRow, int targetPlace){

        int rowNumber = findNumber(a, number)[0];
        int placeNumber = findNumber(a, number)[1];
        while (rowNumber != targetRow || placeNumber != targetPlace) {


            int row = findZero(a)[0];
            int place = findZero(a)[1];

            if (row > targetRow + 1) {
                while (row != targetRow + 1) {
                    a[row][place] = a[row - 1][place];
                    a[row - 1][place] = 0;

                    showMatrix(a);

                    row = findZero(a)[0];
                    place = findZero(a)[1];
                }
            }

            showMatrix(a);

            if (row == targetRow) {
                while (place != targetPlace) {
                    System.out.println("!");
                    a[row][place] = a[row][place - 1];
                    a[row][place - 1] = 0;

                    showMatrix(a);

                    row = findZero(a)[0];
                    place = findZero(a)[1];

                }
            }

            if (row == targetRow && place == targetPlace) {
                a[row][place] = a[row + 1][place];
                a[row + 1][place] = 0;

                showMatrix(a);

                row = findZero(a)[0];
                place = findZero(a)[1];
            }

            rowNumber = findNumber(a, number)[0];
            placeNumber = findNumber(a, number)[1];

            if(rowNumber == targetRow && placeNumber == targetPlace){
                break;
            }

            if (row == targetRow + 1) {
                while (place != a[0].length - 1) {
                    a[row][place] = a[row][place + 1];
                    a[row][place + 1] = 0;

                    showMatrix(a);

                    row = findZero(a)[0];
                    place = findZero(a)[1];
                }
            }

            if (row == targetRow + 1 && place == a[0].length - 1) {
                a[row][place] = a[row - 1][place];
                a[row - 1][place] = 0;

                showMatrix(a);

                row = findZero(a)[0];
                place = findZero(a)[1];
            }

            rowNumber = findNumber(a, number)[0];
            placeNumber = findNumber(a, number)[1];

        }
    }

}
