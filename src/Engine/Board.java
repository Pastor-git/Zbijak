package Engine;

import java.util.Random;
import java.util.Scanner;


public class Board {
    public static void main(String[] args) {

        Object [][] planszapoziom = new Object[8][8];

        Random coordinates = new Random();
        Scanner move = new Scanner(System.in);


        int coordinate_x = coordinates.nextInt(7);
        int coordinate_y = coordinates.nextInt(7);
        System.out.println("losowa pozyjca gracza: " + coordinate_x + " " + coordinate_y);

        Player gracz = new Player (true, "X", coordinate_x, coordinate_y);

        planszapoziom[gracz.x][gracz.y] = gracz.name;


        for(int i = 0; i <planszapoziom.length; i++) {

            for (int j = 0; j< planszapoziom.length; j++) {

                if (planszapoziom[i][j] == null) {
                    planszapoziom[i][j] = "O";
                }
                System.out.print(planszapoziom[i][j] + " ");

            }
            System.out.println();
        }

    }
}

