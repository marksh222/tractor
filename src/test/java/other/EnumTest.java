package other;

/**
 *
 */
public class EnumTest {
    public static void main(String[] args) {
        System.out.print(Values.A);
    }
    enum Values {
        A(1), B(2), C(3);
        Values (int i) {
            System.out.print(i);
        }
        static {
            System.out.print("static");
        }
    }
}
