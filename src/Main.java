import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        System.out.println(isSumBetween10And20(5, 15)); // true
        System.out.println(isSumBetween10And20(7, 15)); // false

        System.out.println(isPositive(5));

        printString("abcd", 5); // abcdabcdabcdabcdabcd

        System.out.println(isLeapYear(2020));

        System.out.println(Arrays.toString(createArray(5, 10)));

        String[] stringArray = {"aaa", "aab", "aa"};
        System.out.println(findCommonPrefix(stringArray)); // aa
        String[] stringArray2 = {"abc", "bca", "cda"};
        System.out.println(findCommonPrefix(stringArray2)); // ""


        /* Задать целочисленный массив, состоящий из элементов 0 и 1.
           Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
           С помощью цикла и условия заменить 0 на 1, 1 на 0. */
        int[] someArray = new int[]{0, 1, 1, 0, 1};
        System.out.println(Arrays.toString(swap0and1InArray(someArray)));

        /* Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
           пройти по нему циклом, и числа меньшие 6 умножить на 2. */
        int[] someArray2 = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(itemLess6Mult2(someArray2)));

        /* Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
           и с помощью цикла(-ов) заполнить его диагональные элементы единицами
           (можно только одну из диагоналей, если обе сложно).
           Определить элементы одной из диагоналей можно по следующему принципу:
           индексы таких элементов равны, то есть [0][0], [1][1], [2][2], …, [n][n]. */
        int lenMatrix = 5; // Длина сторон матрицы
        createXMatrix(lenMatrix, 1);

        /* Задать одномерный массив и найти в нем минимальный и максимальный элементы */
        int sizeArray = 10; // Длина массива
        int[] rndArray = createRandomArray(sizeArray);
        System.out.println("В массиве " + Arrays.toString(rndArray) +
                            " минимальный элемент: " + getMinValue(rndArray) + ", а " +
                            " максимальный элемент: " + getMaxValue(rndArray) + ".");




    }

    /**
     * 1. Написать метод, принимающий на вход два целых числа и проверяющий,
     * что их сумма лежит в пределах от 10 до 20 (включительно),
     * если да – вернуть true, в противном случае – false.
     */
    private static boolean isSumBetween10And20(int a, int b) {
        // проверить, что сумма a и b лежит между 10 и 20
        return ((a + b) >= 10) && ((a + b) <= 20);
    }

    private static boolean isPositive(int x) {
        // проверить, что х положительное
        return x > 0;
    }

    private static void printString(String source, int repeat) {
        // напечатать строку source repeat раз
        for (int i = 0; i < repeat; i++) {
            System.out.print(source);
        }
        System.out.println(); // переход на новую строку для вывода остальных задач
    }

    private static boolean isLeapYear(int year) {
        // проверить, является ли год високосным. если да - return true
        return (year % 4 == 0 && year % 100 != 0) ^ (year % 400 == 0 && year % 100 == 0);
    }

    private static int[] createArray(int len, int initalValue) {
        // должен вернуть массив длины len, каждое значение которого равно initialValue
        int newArray[] = new int[len];
        for (int i = 0; i < len; i++) {
            newArray[i] = initalValue;
        }
        return newArray;
    }

    private static String findCommonPrefix(String[] source) {
        /** Найти общий префикс среди слов из одного массива.
         * ["aaa", "aab", "aa"] -> "aa", ["abc", "bca", "cda"] -> ""
         */
        String prefix = source[0];
        for (String item : source) {
            while (item.indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "\"\"";
            }
        }
        return prefix;
    }

    private static int[] swap0and1InArray(int[] inputArray) {
        for (int i = 0; i < inputArray.length; i++) {
            inputArray[i] = inputArray[i] == 0 ? 1 : 0;
        }
        return inputArray;
    }

    private static int[] itemLess6Mult2(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) array[i] *= 2;
        }
        return array;
    }

    private static void createXMatrix(int size, int item) {
        int[][] matrix = new int[size][size];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == j) matrix[i][j] = item;
            }
        }

        int ind = matrix.length - 1;
        for (int i = 0; i < size; i++) {
            matrix[i][ind] = item;
            ind--;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private static int[] createRandomArray(int lenArray) {
        Random r = new Random();
        int[] rndArray = new int[lenArray];
        for (int i = 0; i < rndArray.length; i++) {
            rndArray[i] = r.nextInt(10, 100);
        }
        return rndArray;
    }

    private static int getMaxValue(int[] array) {
        int maxValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maxValue) maxValue = array[i];
        }
        return maxValue;
    }

    private static int getMinValue(int[] array) {
        int minValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < minValue) minValue = array[i];
        }
        return minValue;
    }

}

