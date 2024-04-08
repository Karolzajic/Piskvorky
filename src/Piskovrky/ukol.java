package Piskovrky;

import java.util.Scanner;

public class ukol {
    public static Scanner scanner = new Scanner(System.in);
    public static char[][] herniPole = new char[3][3];
    public static int radek;
    public static int sloupec;
    public static int pozice = 0;
    public static char hrac = 'X';
    public static char vyherce;
    public static boolean konecHry;

    public static void main(String[] args) {

        System.out.println("Vitejte ve hre Piskvorky !");
        for (int i = 0; i < herniPole.length; i++) {
            for (int j = 0; j < herniPole.length; j++) {
                herniPole[i][j] = ' ';
            }
        }
        boolean vyhra = false;
        while (!konecHry) {
            hra();
            vyhra = kontrola();
            kontrolaRemiza();
        }

        System.out.println("Vytezne pole");
        System.out.println("|" + herniPole[0][0] + "|" + herniPole[0][1] + "|" + herniPole[0][2] + "|");
        System.out.println("_ _ _");
        System.out.println("|" + herniPole[1][0] + "|" + herniPole[1][1] + "|" + herniPole[1][2] + "|");
        System.out.println("_ _ _");
        System.out.println("|" + herniPole[2][0] + "|" + herniPole[2][1] + "|" + herniPole[2][2] + "|");

        if(konecHry && !vyhra){
            System.out.println("Remiza");
        }
        else {
            System.out.println("Vyhrava hrac " + vyherce);
        }
    }

    public static int poziceSloupce() {
        System.out.println("Zadejte cislo sloupce 1-3:");

        while (!scanner.hasNextInt()) {
            System.out.print("Spatny vstup, zadejte souradnice od 1-3");
            scanner.next();
        }

        int pozice = scanner.nextInt() - 1;

        while (pozice < 0 || pozice > 2) {
            System.out.println("Spatne cislo. Cislo musi byt od 1-3");
        }

        return pozice;
    }

    public static int poziceRadku() {
        System.out.println("Zadejte cislo radku 1-3:");

        while (!scanner.hasNextInt()) {
            System.out.println("Spatny vstup, zadejte souradnice od 1-3");
        }

        int pozice = scanner.nextInt() - 1;

        while (pozice < 0 || pozice > 2) {
            System.out.println("Spatne cislo. Cislo musi byt od 1-3");

            pozice = scanner.nextInt() - 1;
        }

        return pozice;
    }

    public static void hra() {

        boolean platnePole = false;

        System.out.println("Hraje hrac " + hrac);
        System.out.println("|" + herniPole[0][0] + "|" + herniPole[0][1] + "|" + herniPole[0][2] + "|");
        System.out.println("_ _ _");
        System.out.println("|" + herniPole[1][0] + "|" + herniPole[1][1] + "|" + herniPole[1][2] + "|");
        System.out.println("_ _ _");
        System.out.println("|" + herniPole[2][0] + "|" + herniPole[2][1] + "|" + herniPole[2][2] + "|");

        while (!platnePole) {

            radek = poziceRadku();
            sloupec = poziceSloupce();

            if (herniPole[radek][sloupec] != ' ') {
                System.out.println("Toto pole je uz obsazene");
            } else {
                platnePole = true;
            }
        }
        herniPole[radek][sloupec] = hrac;
        if (hrac == 'X') {
            hrac = 'O';
        } else {
            hrac = 'X';
        }
        System.out.println();
    }

    public static boolean kontrola() {
        boolean vyhra = false;

        //kontrola výhry v řádku
        for (int i = 0; i < 3; i++) {
            if (herniPole[i][0] == herniPole[i][1] && herniPole[i][2] == herniPole[i][1] && herniPole[i][0] != ' ') {
                vyhra = true;
                vyherce = herniPole[i][0];
                break;
            }
        }

        // kontrola pro sloupce
        for (int i = 0; i < 3; i++) {
            if (herniPole[0][i] == herniPole[1][i] && herniPole[2][i] == herniPole[1][i] && herniPole[0][i] != ' ') {
                vyhra = true;
                vyherce = herniPole[0][i];
                break;
            }
        }

        // kontrola pro diagonály
        if (herniPole[0][0] == herniPole[1][1] && herniPole[2][2] == herniPole[1][1] & herniPole[0][0] != ' ') {
            vyhra = true;
            vyherce = herniPole[0][0];
        }

        if (herniPole[0][2] == herniPole[1][1] && herniPole[2][0] == herniPole[1][1] & herniPole[0][2] != ' ') {
            vyhra = true;
            vyherce = herniPole[0][0];
        }

        return vyhra;
    }

    public static void kontrolaRemiza() {
        for (int i = 0; i < herniPole.length; i++) {
            for (int j = 0; j < herniPole.length; j++) {
                if (herniPole[i][j] == ' ') {
                    konecHry = false;
                    break;
                }
                else{
                    konecHry = true;
                }
            }
        }
    }
}
