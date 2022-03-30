public class App {
    public static void main(String[] args) {
        System.out.println(reverseSentence("I missed the bus"));

        Node<Integer> root = new Node<>(
                100,
                new Node<>(
                        50,
                        new Node<>(25),
                        new Node<>(75)
                ),
                new Node<>(
                        200,
                        null,
                        new Node<>(350)
                )
        );
        System.out.println(root.printTree());
    }

    private static String reverseSentence(String s) {
        StringBuilder builder = new StringBuilder();
        String[] words = s.split("\\s+");
        for (int i = words.length - 1; i >= 0; i--) {
            builder.append(words[i]).append(" ");
        }
        return builder.toString().trim();
    }
}