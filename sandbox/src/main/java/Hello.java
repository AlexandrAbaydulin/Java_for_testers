import java.io.File;

public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        var configFile = new File("C:\\Users\\aabaydulin\\Documents\\GitHub\\Java_for_testers\\sandbox\\build.gradle");
        System.out.println(configFile.getAbsolutePath());
        System.out.println(configFile.exists());
    }
}
