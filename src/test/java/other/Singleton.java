package other;

/**
 * + TreadSave, (обеспечивает JVM (механизм инициализации статических переменных))
 * + Lazy (INSTANCE = new Singleton() срабатывает только если будет обращение к getInstance)
 */
public class Singleton {
    private Singleton() {
        super();
    }

    private static class Holder {
        private final static Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return Holder.INSTANCE;
    }
    public static void main(String[] args) {
        System.out.println(Singleton.getInstance());
    }
}
