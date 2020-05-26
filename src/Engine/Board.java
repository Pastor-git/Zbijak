package Engine;

import java.util.Random;
import java.util.Scanner;


public class Board {
    public static void main(String[] args) {

        Object[][] planszapoziom = new Object[8][8];

        Random coordinates = new Random();
        Scanner move = new Scanner(System.in);

        System.out.println("Zbij wszystkich przeciwników: ");
        System.out.println("1 - up, 2 - down, 3 - left, 4 - right");

        int coordinate_x = coordinates.nextInt(8);
        int coordinate_y = coordinates.nextInt(8);
        System.out.println("startowa pozyjca gracza: " + coordinate_x + " " + coordinate_y);
        Player gracz = new Player(true, "X", coordinate_x, coordinate_y);

        int coordinate_K1x;
        int coordinate_K1y;

        do {
            coordinate_K1x = coordinates.nextInt(8);
        } while (coordinate_K1x == gracz.x);
        do {
            coordinate_K1y = coordinates.nextInt(8);
        } while (coordinate_K1y == gracz.y);
        Player komputer1 = new Player(true, "K", coordinate_K1x, coordinate_K1y);




        planszapoziom[komputer1.x][komputer1.y] = komputer1.name;
        planszapoziom[gracz.x][gracz.y] = gracz.name;

//        TEST
//        komputer1.death();
//        System.out.println(komputer1.life + " zabiłeś komuter1");

        for (int i = 0; i < planszapoziom.length; i++) {

            for (int j = 0; j < planszapoziom.length; j++) {

                if (planszapoziom[i][j] == null) {
                    planszapoziom[i][j] = "O";
                }
                System.out.print(planszapoziom[i][j] + " ");

            }
            System.out.println();
        }

        int komputer1_ruch;
        int decyzja;

        while (komputer1.life) {

            decyzja = move.nextInt();

            switch (decyzja) {
                case 1:
                    planszapoziom[gracz.x][gracz.y] = null;
                    gracz.up();
                    if (gracz.x < 0 || gracz.x > 7 || gracz.y < 0 || gracz.y > 7) {
                    gracz.down();
                    System.out.println("Wyszedłeś poza planszę - straciłeś ruch");
                    }
                    break;
                case 2:
                    planszapoziom[gracz.x][gracz.y] = null;
                    gracz.down();
                    if (gracz.x < 0 || gracz.x > 7 || gracz.y < 0 || gracz.y > 7) {
                        gracz.up();
                        System.out.println("Wyszedłeś poza planszę - straciłeś ruch");
                    }
                    break;
                case 3:
                    planszapoziom[gracz.x][gracz.y] = null;
                    gracz.left();
                    if (gracz.x < 0 || gracz.x > 7 || gracz.y < 0 || gracz.y > 7) {
                        gracz.right();
                        System.out.println("Wyszedłeś poza planszę - straciłeś ruch");
                    }
                    break;
                case 4:
                    planszapoziom[gracz.x][gracz.y] = null;
                    gracz.right();
                    if (gracz.x < 0 || gracz.x > 7 || gracz.y < 0 || gracz.y > 7) {
                        gracz.left();
                        System.out.println("Wyszedłeś poza planszę - straciłeś ruch");
                    }
                    break;
                default:
                    System.out.println("zła liczba wybierz jescze raz");
                    break;
            }
            if (komputer1.x == gracz.x && komputer1.y == gracz.y) {
                komputer1.death();
                System.out.println("zabiłeś komuter1");
            }
            else {



            if (komputer1.life) {
                komputer1_ruch = coordinates.nextInt(5);
                System.out.println(komputer1_ruch);


                if (komputer1_ruch == 1) {

                    planszapoziom[komputer1.x][komputer1.y] = null;
                    komputer1.up();
                    if (komputer1.x < 0 || komputer1.x > 7 || komputer1.y < 0 || komputer1.y > 7) {
                        komputer1.down();
                    }
                }

                 else if (komputer1_ruch == 2) {
                    planszapoziom[komputer1.x][komputer1.y] = null;
                    komputer1.down();
                    if (komputer1.x < 0 || komputer1.x > 7 || komputer1.y < 0 || komputer1.y > 7) {
                        komputer1.up();
                    }
                }
                else if (komputer1_ruch == 3) {
                    planszapoziom[komputer1.x][komputer1.y] = null;
                    komputer1.left();
                    if (komputer1.x < 0 || komputer1.x > 7 || komputer1.y < 0 || komputer1.y > 7) {
                        komputer1.right();
                    }
                }
                else if (komputer1_ruch == 4) {
                    planszapoziom[komputer1.x][komputer1.y] = null;
                    komputer1.right();
                    if (komputer1.x < 0 || komputer1.x > 7 || komputer1.y < 0 || komputer1.y > 7) {
                        komputer1.left();
                    }

                }
                else {
                    System.out.println("komputer1 umarł");
                }

                }
                planszapoziom[komputer1.x][komputer1.y] = komputer1.name;
            }
                ///////TEST
//                for (int i = 0; i < planszapoziom.length; i++) {
//
//                    for (int j = 0; j < planszapoziom.length; j++) {
//
//                        if (planszapoziom[i][j] == null) {
//                            planszapoziom[i][j] = "O";
//                        }
//                        System.out.print(planszapoziom[i][j] + " ");
//
//                    }
//                    System.out.println();
//                }
                ////////TEST
                System.out.println("pozycja gracza " + gracz.x + " " + gracz.y);
                System.out.println("pozycja komputera " + komputer1.x + " " + komputer1.y);



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


            }

            System.out.println("Koniec Gry");
        }
    }
