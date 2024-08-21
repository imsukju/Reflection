package com.sj.Arrays.reflectionapi3;

import java.lang.reflect.Array;
import static java.lang.System.out;

public class CreateMatrix {
    public static void main(String... args) {
        Object matrix = Array.newInstance(int.class, 5, 5);
        Object row0 = Array.get(matrix, 0);
        Object row1 = Array.get(matrix, 1);
        
        Array.newInstance(String.class, 5,5);
        
        
        // 개별 row 값을 설정
        Array.setInt(row0, 0, 1);
        Array.setInt(row0, 1, 2);
        Array.setInt(row1, 0, 3);
        Array.setInt(row1, 1, 4);
        
        
        Array.set(matrix, 0, row1);
        Array.set(matrix, 1, row1);
        
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++)
                out.format("matrix[%d][%d] = %d%n", i, j, ((int[][])matrix)[i][j]);
    }
}