package com.company;


public class Main {

    public static void main(String[] args) {


        int weight[] = {0, 5, 4, 3, 2, 4};
        int value[] = {0, 4, 2, 4, 1, 5};
        int minWeight = FindMinWeight(weight);
        int maxValue;
        int space[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        int[][] nestedArray = new int[6][14];

        printJSpace(space);  //prints j spaces until ua

        for (int i = 1; i < weight.length; i++) {
            for (int j = 1; j < space.length; j++) {
                //if statement formats the table
                if (j == 1) {
                    System.out.println();
                    System.out.print("i=" + i + " ");
                }
                nestedArray[i][j] = FindValue(space, weight, value, j, i, minWeight, nestedArray);
                System.out.print(nestedArray[i][j] + " ");
            }

        }


        maxValue = getMaxValue(nestedArray);
        System.out.println();
        System.out.println("-------------------------------------------------");
        System.out.println("The largest value in this knapsack problem is: " + maxValue);

    }

    public static int FindValue(int[] space, int[] weight, int[] value, int j, int i, int minWeight, int[][] nestedArray) {

        if (space[j] < minWeight) {
            return 0;
        } else if (weight[i] > j) {

            return nestedArray[i - 1][j];
        } else {
            return Math.max(nestedArray[i - 1][j], nestedArray[i - 1][j - weight[i]] + value[i]);
        }
    }

    public static int FindMinWeight(int[] weight) {
        int min = weight[0];
        for (int i = 1; i < weight.length; i++) {
            if (weight[i] < min) {
                min = weight[i];
            }
        }
        return min;
    }

    public static int getMaxValue(int[][] numbers) {
        int maxValue = numbers[0][0];
        for (int j = 0; j < numbers.length; j++) {
            for (int i = 0; i < numbers[j].length; i++) {
                if (numbers[j][i] > maxValue) {
                    maxValue = numbers[j][i];
                }
            }
        }
        return maxValue;
    }

    public static void printJSpace(int[] space){
        System.out.print("j = ");
        for (int i=0;i <=space.length-1; i++){
            System.out.print(space[i] +" ");
        }
    }

}

