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


        int coordinate_K2x;
        int coordinate_K2y;

        do {
            coordinate_K2x = coordinates.nextInt(8);
        } while (coordinate_K2x == gracz.x || coordinate_K2x == coordinate_K1x);
        do {
            coordinate_K2y = coordinates.nextInt(8);
        } while (coordinate_K2y == gracz.y || coordinate_K2y == coordinate_K1y);
        Player komputer2 = new Player(true, "K", coordinate_K2x, coordinate_K2y);

        int coordinate_K3x;
        int coordinate_K3y;

        do {
            coordinate_K3x = coordinates.nextInt(8);
        } while (coordinate_K3x == gracz.x || coordinate_K3x == coordinate_K1x || coordinate_K3x == coordinate_K2x);
        do {
            coordinate_K3y = coordinates.nextInt(8);
        } while (coordinate_K3y == gracz.y || coordinate_K3y == coordinate_K1y || coordinate_K3y == coordinate_K2y);
        Player komputer3 = new Player(true, "K", coordinate_K3x, coordinate_K3y);


        planszapoziom[komputer1.x][komputer1.y] = komputer1.name;
        planszapoziom[komputer2.x][komputer2.y] = komputer1.name;
        planszapoziom[komputer3.x][komputer3.y] = komputer1.name;
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
        int komputer2_ruch;
        int komputer3_ruch;
        int decyzja;

        while (komputer1.life || komputer2.life || komputer3.life) {

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
                komputer1_ruch = coordinates.nextInt(4);
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
                else if (komputer1_ruch == 0) {
                    planszapoziom[komputer1.x][komputer1.y] = null;
                    komputer1.right();
                    if (komputer1.x < 0 || komputer1.x > 7 || komputer1.y < 0 || komputer1.y > 7) {
                        komputer1.left();
                    }

                }
                else {
                    System.out.println("komputer1 umarł");
                }
                planszapoziom[komputer1.x][komputer1.y] = komputer1.name;
                }

            }


            if (komputer2.x == gracz.x && komputer2.y == gracz.y) {
                komputer2.death();
                System.out.println("zabiłeś komuter2");
                planszapoziom[komputer2.x][komputer2.y] = gracz.name;
            }
            else {



                if (komputer2.life) {
                    komputer2_ruch = coordinates.nextInt(4);
                    System.out.println(komputer2_ruch);


                    if (komputer2_ruch == 1) {

                        planszapoziom[komputer2.x][komputer2.y] = null;
                        komputer2.up();
                        if (komputer2.x < 0 || komputer2.x > 7 || komputer2.y < 0 || komputer2.y > 7) {
                            komputer2.down();
                        }
                    }

                    else if (komputer2_ruch == 2) {
                        planszapoziom[komputer2.x][komputer2.y] = null;
                        komputer2.down();
                        if (komputer2.x < 0 || komputer2.x > 7 || komputer2.y < 0 || komputer2.y > 7) {
                            komputer2.up();
                        }
                    }
                    else if (komputer2_ruch == 3) {
                        planszapoziom[komputer2.x][komputer2.y] = null;
                        komputer2.left();
                        if (komputer2.x < 0 || komputer2.x > 7 || komputer2.y < 0 || komputer2.y > 7) {
                            komputer2.right();
                        }
                    }
                    else if (komputer2_ruch == 0) {
                        planszapoziom[komputer2.x][komputer2.y] = null;
                        komputer2.right();
                        if (komputer2.x < 0 || komputer2.x > 7 || komputer2.y < 0 || komputer2.y > 7) {
                            komputer2.left();
                        }

                    }
                    else {
                        System.out.println("komputer2 umarł");
                    }
                    planszapoziom[komputer2.x][komputer2.y] = komputer2.name;
                }

            }
            ///////////////////////////////////////////////////////
            if (komputer3.x == gracz.x && komputer3.y == gracz.y) {
                komputer3.death();
                System.out.println("zabiłeś komuter3");

            }
            else {



                if (komputer3.life) {
                    komputer3_ruch = coordinates.nextInt(4);
                    System.out.println(komputer3_ruch);


                    if (komputer3_ruch == 1) {

                        planszapoziom[komputer3.x][komputer3.y] = null;
                        komputer3.up();
                        if (komputer3.x < 0 || komputer3.x > 7 || komputer3.y < 0 || komputer3.y > 7) {
                            komputer3.down();
                        }
                    }

                    else if (komputer3_ruch == 2) {
                        planszapoziom[komputer3.x][komputer3.y] = null;
                        komputer3.down();
                        if (komputer3.x < 0 || komputer3.x > 7 || komputer3.y < 0 || komputer3.y > 7) {
                            komputer3.up();
                        }
                    }
                    else if (komputer3_ruch == 3) {
                        planszapoziom[komputer3.x][komputer3.y] = null;
                        komputer3.left();
                        if (komputer3.x < 0 || komputer3.x > 7 || komputer3.y < 0 || komputer3.y > 7) {
                            komputer3.right();
                        }
                    }
                    else if (komputer3_ruch == 0) {
                        planszapoziom[komputer3.x][komputer3.y] = null;
                        komputer3.right();
                        if (komputer3.x < 0 || komputer3.x > 7 || komputer3.y < 0 || komputer3.y > 7) {
                            komputer3.left();
                        }

                    }
                    else {
                        System.out.println("komputer3 umarł");
                    }
                    planszapoziom[komputer3.x][komputer3.y] = komputer3.name;
                }

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
                System.out.println("test pozycja gracza " + gracz.x + " " + gracz.y);
                System.out.println("test pozycja komputera1 lub miejsce śmierci " + komputer1.x + " " + komputer1.y);
                System.out.println("test pozycja komputera2 lub miejsce śmierci " + komputer2.x + " " + komputer2.y);
                System.out.println("test pozycja komputera3 lub miejsce śmierci " + komputer3.x + " " + komputer3.y);


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
