import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Encoder {

    private static final String REFERENCE_CHAR = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789()*+,-./";
    private static final int TABLE_SIZE = REFERENCE_CHAR.length();
    private final Map<Character, Integer> CHAR_TABLE = new HashMap<>();
    private final Map<Integer, Character> INDEX_TABLE = new HashMap<>();

    public Encoder() {
        for (int i = 0; i < TABLE_SIZE; i++) {
            CHAR_TABLE.put(REFERENCE_CHAR.charAt(i), i);
            INDEX_TABLE.put(i, REFERENCE_CHAR.charAt(i));
        }
    }

    public String encode(String plainText) {
        int offset = ThreadLocalRandom.current().nextInt(0, TABLE_SIZE);
        return encodeAtOffset(offset, plainText);
    }
    

    private String encodeAtOffset(int offset, String plainText) {
        StringBuilder encodedText = new StringBuilder(String.valueOf(INDEX_TABLE.get(offset)));
        char currChar;
        int newCharIndex;

        for (int i = 0; i < plainText.length(); i++) {
            currChar = plainText.charAt(i);
            if (currChar == ' ') {
                encodedText.append(' ');
                continue;
            }

            newCharIndex = CHAR_TABLE.get(currChar) - offset;
            if (newCharIndex < 0) newCharIndex += TABLE_SIZE;

            encodedText.append(INDEX_TABLE.get(newCharIndex));
        }

        return encodedText.toString();
    }
}
