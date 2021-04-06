package path;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MyPath {

    public static void main(String[] args) throws URISyntaxException, IOException {


        Path filePath = Paths.get("D:\\MYDEV\\SKILLFACTORY\\TEST\\file1.txt");
        Path filePath3 = Paths.get("\\TEMP\\test.txt");
        Path dirPath = Paths.get("C:\\SKILLFACTORY\\TEMP\\");


        URI uri = new URI("https://vk.com/text.html");
        Path urlPath = Paths.get(uri.getPath());


        File file = filePath.toFile();
        Path filePath2 = file.toPath();

        System.out.println(urlPath);
        System.out.println(filePath.getName(0));
        System.out.println(filePath.getName(1));
        System.out.println(filePath.getName(2));

        System.out.println(filePath.getParent());
        System.out.println(filePath.getRoot());

        while ((filePath = filePath.getParent()) != null) {
            System.out.println("Current parent is: " + filePath);
        }

        filePath = filePath2;

        while ((filePath2 = filePath2.getParent()) != null) {
            System.out.println("Current parent is: " + filePath2);
        }

        System.out.println(filePath.isAbsolute());
        System.out.println(filePath3.isAbsolute());
        System.out.println(filePath.toAbsolutePath());
        System.out.println(filePath3);
        System.out.println(filePath3.toAbsolutePath());

        System.out.println(filePath.subpath(2,3));


        try {
            System.out.println(filePath.toRealPath());
            System.out.println(Paths.get("..\\TEST\\file1.txt").toRealPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(Files.exists(filePath));

        if(Files.notExists(Paths.get("..\\TEST\\TMP"))) Files.createDirectory(Paths.get("..\\TEST\\TMP"));

        Files.createDirectories(Paths.get("..\\TEST\\TMP\\1\\2\\3"));

    }

}
