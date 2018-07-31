/*1. Есть строка вида: "1 3 1 2\n2 3 2 2\n5 6 7 1\n3 3 1 0"; (другими словами матрица 4x4)
 1 3 1 2
 2 3 2 2
 5 6 7 1
 3 3 1 0
 Написать метод, на вход которого подаётся такая строка, метод должен преобразовать строку в двумерный массив типа String[][];
 2. Преобразовать все элементы массива в числа типа int, просуммировать, поделить полученную сумму на 2, и вернуть результат;
 3. Ваш метод должен бросить исключения в случаях:
    Если размер матрицы, полученной из строки, не равен 4x4;
    Если в одной из ячеек полученной матрицы не число; (например символ или слово)
 4. В методе main необходимо вызвать полученный метод, обработать возможные исключения и вывести результат расчета.*/

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String numbers = "1 3 1 2\n2 3 2 2\n5 6 7 1\n3 3 1 0";
        try {
            System.out.print(func(numbers));
        }
        catch (RuntimeException e) {
        System.out.print(e.getMessage());

        }
        }



    public static int func(String numbers){
        String arrNum[] = numbers.split("\\n");
        String[][] matrix = new String[arrNum.length][arrNum.length];
        int summ = 0;
        int k = 0;
        for (String row : arrNum) {
            matrix[k++] = row.split(" ");
        }

        if (matrix.length != 4)
            throw new RuntimeException("Матрица не 4х4");
        int arr[][] = new int[matrix.length][matrix.length];


        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix.length ; j++){
                if (matrix[i][j].getClass().getTypeName() == "int[][]")
                    throw new RuntimeException("В массиве буква");
                arr[i][j] = Integer.parseInt(matrix[i][j]);

                summ += arr[i][j];
            }

        }

        return  summ/2;
    }

    }

