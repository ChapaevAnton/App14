package path;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class SaveFile {


    public static void main(String[] args) {

        final String FILE_NAME = "D:\\MYDEV\\SKILLFACTORY\\TEST\\TMP\\fileToCreate.txt";
        Path file = Paths.get(FILE_NAME);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            if (Files.notExists(file)) Files.createFile(file);
            BufferedWriter writerFile = Files
                    .newBufferedWriter(file, StandardCharsets.UTF_8, StandardOpenOption.WRITE);

            for (int i = 1; i < 10; i++) {
                stringBuilder.append(i).append("\n");
                writerFile.write(stringBuilder.toString());
                stringBuilder.deleteCharAt(stringBuilder.lastIndexOf("\n"));
            }
            writerFile.close();

        } catch (IOException err) {
            System.err.println("Файл уже создан...");
        }


    }

}
