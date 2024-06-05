package ru.vsu.cs.baturin_v_a.cli;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private static Scanner scn = new Scanner(System.in);
    private static Command[] commands = new Command[]{
            new Add(),
            new Edit(),
            new PrintInv(),
            new PrintSales(),
            new Sell(),
    };

    public static void run() {
        while (true){
            System.out.println();
            for (int i = 1; i <= commands.length; i++) {
                System.out.println(i + " " + commands[i - 1].getCommandName());
            }
            System.out.println("0 Exit");
            int inputCommand = 0;
            try {
                inputCommand = scn.nextInt();
            } catch (InputMismatchException ime){
                System.out.println("wrong command");
                continue;
            }

            if(inputCommand == -1){
                System.out.println("Program execute with exit code 130");
                return;
            }

            if(inputCommand > commands.length){
                System.out.println("Wrong command");
                continue;
            }

            if (inputCommand == 0)
                return;

            commands[inputCommand - 1].execute();

        }
    }
}