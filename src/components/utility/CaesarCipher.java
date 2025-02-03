package components.utility;

public class CaesarCipher {
    public static String encrypt(String text, int shift) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : text.toCharArray()) {
            if(c == ',') {
                encrypted.append(c);
            } else {
                encrypted.append((char) (c + shift));
            }
        }
        return encrypted.toString();
    }

    public static String decrypt(String text, int shift) {
        StringBuilder decrypted = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (c == ',') {
                decrypted.append(c);
            } else {
                decrypted.append((char) (c - shift));
            }
        }
        return decrypted.toString();
    }

    public static int getShiftValue(char[] password) {
        int shift = 0;
        for (char c : password) {
            shift += (int) c;
        }
        return shift;
    }
}
