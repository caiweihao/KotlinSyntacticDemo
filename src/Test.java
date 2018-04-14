import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();

        instanceOf(123);
        instanceOf("1234");
        strings.stream();
    }

    public static void instanceOf(Object object) {
        if (object instanceof String) {
            System.out.println("string length is " + ((String )object).length());
        } else {
            System.out.println("is not String");
        }
    }
}
