package Engine;

import java.util.Random;
import java.util.Scanner;


public class Board {
    public static void main(String[] args) {

        Object[][] planszapoziom = new Object[8][8];

        Random coordinates = new Random();
        Scanner move = new Scanner(System.in);


        int coordinate_x = coordinates.nextInt(7);
        int coordinate_y = coordinates.nextInt(7);
        System.out.println("startowa pozyjca gracza: " + coordinate_x + " " + coordinate_y);

        Player gracz = new Player(true, "X", coordinate_x, coordinate_y);

        System.out.println("Zbij wszystkich przeciwników: ");
        System.out.println("1 - up, 2 - down, 3 - left, 4 - right");

        planszapoziom[gracz.x][gracz.y] = gracz.name;

        for (int i = 0; i < planszapoziom.length; i++) {

            for (int j = 0; j < planszapoziom.length; j++) {

                if (planszapoziom[i][j] == null) {
                    planszapoziom[i][j] = "O";
                }
                System.out.print(planszapoziom[i][j] + " ");

            }
            System.out.println();
        }

        do {
            int decyzja = move.nextInt();

            switch (decyzja) {
                case 1:
                    planszapoziom[gracz.x][gracz.y] = null;
                    gracz.up();
                    if (gracz.x < 0 || gracz.x > 7 || gracz.y < 0 || gracz.y > 7) {
                    gracz.down();
                    System.out.println("Wyszedłeś poza planszę - straciłeś ruch");
                    }
                    planszapoziom[gracz.x][gracz.y] = gracz.name;
                    break;
                case 2:
                    planszapoziom[gracz.x][gracz.y] = null;
                    gracz.down();
                    if (gracz.x < 0 || gracz.x > 7 || gracz.y < 0 || gracz.y > 7) {
                        gracz.up();
                        System.out.println("Wyszedłeś poza planszę - straciłeś ruch");
                    }
                    planszapoziom[gracz.x][gracz.y] = gracz.name;
                    break;
                case 3:
                    planszapoziom[gracz.x][gracz.y] = null;
                    gracz.left();
                    if (gracz.x < 0 || gracz.x > 7 || gracz.y < 0 || gracz.y > 7) {
                        gracz.right();
                        System.out.println("Wyszedłeś poza planszę - straciłeś ruch");
                    }
                    planszapoziom[gracz.x][gracz.y] = gracz.name;
                    break;
                case 4:
                    planszapoziom[gracz.x][gracz.y] = null;
                    gracz.right();
                    if (gracz.x < 0 || gracz.x > 7 || gracz.y < 0 || gracz.y > 7) {
                        gracz.left();
                        System.out.println("Wyszedłeś poza planszę - straciłeś ruch");
                    }
                    planszapoziom[gracz.x][gracz.y] = gracz.name;
                    break;
                default:
                    System.out.println("zła liczba wybierz jescze raz");
                    break;
            }

                for (int i = 0; i < planszapoziom.length; i++) {

                    for (int j = 0; j < planszapoziom.length; j++) {

                        if (planszapoziom[i][j] == null) {
                            planszapoziom[i][j] = "O";
                        }
                        System.out.print(planszapoziom[i][j] + " ");

                    }
                    System.out.println();
                }


            }
            while (gracz.life = true) ;
        }
    }
