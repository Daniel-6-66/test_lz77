package org.example;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        LZ77 lz77 = new LZ77();

        // Чтение данных из input.txt
        StringBuilder inputData = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\BoSS JR\\OneDrive\\Рабочий стол\\Учёба\\LZ77_algoritm\\src\\input.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                inputData.append(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Сжатие данных
        ArrayList<LZ77.Trio> compressedData = lz77.compress(inputData.toString() , 500);
        for (int i = 0; i < compressedData.size();i++){
            System.out.println("<"+compressedData.get(i).length+","+compressedData.get(i).offset+","+compressedData.get(i).nextChar+">");
        }
        // Преобразование сжатых данных в байты и запись в архивный файл
        try {
            byte[] compressedBytes = lz77.convertToBytes(compressedData);
            FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\BoSS JR\\OneDrive\\Рабочий стол\\Учёба\\LZ77_algoritm\\src\\archive.txt");
            fileOutputStream.write(compressedBytes);
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Чтение сжатых данных из архивного файла
        try {
            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\BoSS JR\\OneDrive\\Рабочий стол\\Учёба\\LZ77_algoritm\\src\\archive.txt");
            byte[] readBytes = new byte[fileInputStream.available()];
            fileInputStream.read(readBytes);
            fileInputStream.close();

            // Обратное преобразование из байтов и распаковка данных
            ArrayList<LZ77.Trio> readCompressedData = lz77.convertFromBytes(readBytes);
            String decompressedData = lz77.decompress(readCompressedData);

            // Запись распакованных данных в output.txt
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\BoSS JR\\OneDrive\\Рабочий стол\\Учёба\\LZ77_algoritm\\src\\output.txt"));
            writer.write(decompressedData);
            writer.close();
        } catch (Exception e){
            System.out.println("erorr");
        }
    }
}