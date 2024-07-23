package JavaTesting;

public class RandomPhoneNumber {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            int random = (int) (Math.random() * 10);
            String intToString = String.valueOf(random);
            sb.append(intToString);

        }
        System.out.println(sb.toString());

    }
}
