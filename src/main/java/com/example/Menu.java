package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Menu {

    private final String name;
    private final ArrayList<String> options;

    public Menu(String name, ArrayList<String> options) {
        this.name = name;
        this.options = options;
    }

    public Menu(String name, String[] options) {
        this(name, new ArrayList<String>(Arrays.asList(options)));
    }

    public int ask() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(this);
        int answer = -1;
        while (answer == -1) {
            answer = scanner.nextInt() - 1;
            if (answer < 0 || answer > options.size() - 1) {
                System.out.println("Cette option n'existe pas.");
                answer = -1;
            }
        }
        return answer;
    }

    @Override
    public String toString() {
        StringBuilder menu = new StringBuilder();
        menu.append(name);
        menu.append("\n");
        for (String option : options) {
            menu.append(Integer.toString(options.indexOf(option) + 1));
            menu.append("| ");
            menu.append(option);
            menu.append("\n");
        }
        return menu.toString();
    }

}
