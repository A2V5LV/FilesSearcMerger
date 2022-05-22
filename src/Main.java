import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) throws IOException {

        List<Path> pathFiles = new ArrayList<>();

        try (Stream<Path> paths = Files.walk(Paths.get(".\\Source"))) {
            paths
                    .filter(Files::isRegularFile)
                    .filter(Files -> Files.toString().toLowerCase().endsWith(".txt"))
                    .forEach(pathFiles::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        pathFiles.forEach(System.out::println);
    }
}
