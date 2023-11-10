package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Получение путей до файлов
        System.out.println("Введите путь до файла , который хотите сжать :");
        String input_file_path = readFromConsole();
        System.out.println("Введите путь до файла , в который хотите записать сжатый файл :");
        String archive_file_path = readFromConsole();
        System.out.println("Введите путь до файла , в который хотите расжать файл :");
        String output_file_path = readFromConsole();

        //Логика
        LZ77 lz77 = new LZ77();
        lz77.compress(input_file_path,archive_file_path);
        lz77.decompress(output_file_path,archive_file_path);



    }

    public static String readFromConsole() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}