package other.itsk;

@SuppressWarnings("unused")
public class Encryption implements DEScrypt, RSAcrypt, GOSTcrypt {

    private String key = null;
    Encryption(String key) {
        super();
        this.key = key;
    }

    @Override
    public String desCrypt(String text) {
        String cryptedString = null;
        // тело алгоритма
        return desCryptImpl(text, key);
    }

    private static String desCryptImpl(String text, String key) {
        String cryptedString = null;
        // тело алгоритма
        //noinspection ConstantConditions
        return cryptedString;
    }

    @Override
    public String rsaСrypt(String text) {
        return rsaСryptImpl(text, key);
    }

    private static String rsaСryptImpl(String text, String key) {
        String cryptedString = null;
        // тело алгоритма
        //noinspection ConstantConditions
        return cryptedString;
    }

    @Override
    public String gostCrypt(String text) {
        return gostCryptImpl(text, key);
    }

    private static String gostCryptImpl(String text, String key) {
        String cryptedString = null;
        // тело алгоритма
        //noinspection ConstantConditions
        return cryptedString;
    }

    public static class Test {
        public static void main(String[] args) {
            String key = "key";
            String text = "text";

            Encryption encryption = new Encryption("abc");
            String cryptedText = encryption.desCrypt(text);
            System.out.println(cryptedText);

        }
    }
}


