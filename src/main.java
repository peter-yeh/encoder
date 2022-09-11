public class main {

    public static void main(String[] args) {
        Encoder e = new Encoder();
        String encodedText = e.encode("HELLO WORLD");
        System.out.println("The encoded text: " + encodedText);
        System.out.println("The decoded text: " + e.decode(encodedText) + "\n");

        String encodedText1 = e.encode("CXO3WBWKZ9");
        System.out.println("The encoded text: " + encodedText1);
        System.out.println("The decoded text: " + e.decode(encodedText1) + "\n");

        String encodedText2 = e.encode("THE LAZY FOX JUMP OVER THE SLEEPING DOG THAT IS GUNN");
        System.out.println("The encoded text: " + encodedText2);
        System.out.println("The decoded text: " + e.decode(encodedText2));
    }

}
