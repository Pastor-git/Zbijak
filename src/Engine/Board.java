package Engine;

public class Board {
    public static void main(String[] args) {
        Object [][] planszapoziom = new Object[8][8];


        planszapoziom [2][2] = "a kuku";


        for(int i = 0; i <planszapoziom.length; i++) {
            Object [] planszapion = planszapoziom[i];
            for (int j = 0; j< planszapion.length; j++) {

//                planszapoziom[i][j] = "O";
                System.out.print(planszapoziom[i][j] + " ");

            }
            System.out.println();
        }

    }
}

