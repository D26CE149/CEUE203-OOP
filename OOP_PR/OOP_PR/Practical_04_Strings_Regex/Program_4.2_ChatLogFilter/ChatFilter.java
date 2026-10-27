public class ChatFilter {
    public static boolean messageContainsKeyword(String message, String keyword) {
        return message.toLowerCase().contains(keyword.toLowerCase());
    }
}
