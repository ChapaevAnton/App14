package path;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;

public class SaveFile {

    // TODO: 07.04.2021 14.6.4

    public static void main(String[] args) {

        final String FILE_NAME_READ = "C:\\MYDEV\\SKILLFACTORY\\TEST\\TMP\\fileToRead.txt";
        final String FILE_NAME_WRITE = "C:\\MYDEV\\SKILLFACTORY\\TEST\\TMP\\fileToWrite.txt";
        final Path fileRead = Paths.get(FILE_NAME_READ);
        final Path fileWrite = Paths.get(FILE_NAME_WRITE);


        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<String> buffered = new ArrayList<>();

//        1
//        12
//        123
//        1234
//        12345
//        123456
//        1234567
//        12345678
//        123456789

        //генерация данных для записи в буфер
        for (int i = 1; i < 10; i++) {
            stringBuilder.append(i).append("\n");
            buffered.add(stringBuilder.toString());
            stringBuilder.deleteCharAt(stringBuilder.lastIndexOf("\n"));
        }

        //записываем в файл изначальный буфер
        writeFile(fileRead, buffered);

        //читаем из файл в буфер
        buffered = readFile(fileRead);

        //выполняем операции с буфером
        Collections.reverse(buffered);

        //записываем в другой файл измененный буфер
        writeFile(fileWrite, buffered);

    }

    //чтение
    public static ArrayList<String> readFile(Path fileRead) {

        ArrayList<String> buffered = new ArrayList<>();
        BufferedReader readerFile = null;
        try {
            readerFile = Files.newBufferedReader(fileRead, StandardCharsets.UTF_8);
            String readLine;
            while ((readLine = readerFile.readLine()) != null) {
                buffered.add(readLine);
            }

        } catch (IOException err) {
            err.printStackTrace();
        } finally {
            if (readerFile != null) System.out.println(fileRead.getFileName() + " read ok");
        }
        return buffered;
    }

    //запись
    public static void writeFile(Path fileWrite, ArrayList<String> buffered) {

        final Path dir = fileWrite.getParent();
        BufferedWriter writerFile = null;

        try {

            Files.createDirectories(dir);

            if (Files.notExists(fileWrite) && Files.isDirectory(dir)) Files.createFile(fileWrite);
            writerFile = Files.newBufferedWriter(fileWrite, StandardCharsets.UTF_8, StandardOpenOption.WRITE);

            for (String item : buffered) {
                writerFile.write(item);
            }

        } catch (IOException err) {
            err.printStackTrace();
        } finally {
            try {
                if (writerFile != null) {
                    writerFile.close();
                    System.out.println(fileWrite.getFileName() + " write ok");
                }
            } catch (IOException err) {
                err.printStackTrace();
            }
        }
    }

}
