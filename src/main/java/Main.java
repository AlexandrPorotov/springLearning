class Application {
//Тестовое задание. На вход получаем строку, переворачиваем порядок букв в словах, но не порядок слов в строке.

    public static String reverseWords(String input) {
        StringBuilder result = new StringBuilder();
        String[] inputArray = input.split(" ");
        for (String s : inputArray) {
            char[] charArray = s.toCharArray();
            for (int j = charArray.length - 1; j >= 0; j--) {
                result.append(charArray[j]);
            }
            result.append(" ");
        }

        return result.toString();
    }

    public static void main(String[] args) {
        final String test = "A quick brown fox jumps over a lazy dog";
        System.out.println(reverseWords(test));
        System.out.println(reverseWords(reverseWords(test)));
    }

}