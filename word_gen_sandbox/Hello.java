import java.util.Scanner; 
public class Hello {
    public static void main(String[] args) {
        String user_name = System.getProperty("user.name");
        user_name = user_name.substring(0, 1).toUpperCase() + user_name.substring(1);

        System.out.println("hello, " + user_name);
    }
}
