import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Map;
import java.util.HashMap;

public class Typer {
    private static final int KEY_PRESS_DELAY = 5; //typing delay (lower = faster key strokes)
    private static final Map<Character, Integer> CHAR_MAP = new HashMap<>();

    static {
        CHAR_MAP.put(' ', KeyEvent.VK_SPACE);
        CHAR_MAP.put('\n', KeyEvent.VK_ENTER);
        CHAR_MAP.put('\t', KeyEvent.VK_TAB);
        CHAR_MAP.put('!', KeyEvent.VK_EXCLAMATION_MARK);
        CHAR_MAP.put('@', KeyEvent.VK_AT);
        CHAR_MAP.put('#', KeyEvent.VK_NUMBER_SIGN);
        CHAR_MAP.put('$', KeyEvent.VK_DOLLAR);
        CHAR_MAP.put('%', KeyEvent.VK_5);
        CHAR_MAP.put('^', KeyEvent.VK_6);
        CHAR_MAP.put('&', KeyEvent.VK_AMPERSAND);
        CHAR_MAP.put('*', KeyEvent.VK_ASTERISK);
        CHAR_MAP.put('(', KeyEvent.VK_LEFT_PARENTHESIS);
        CHAR_MAP.put(')', KeyEvent.VK_RIGHT_PARENTHESIS);
        CHAR_MAP.put('-', KeyEvent.VK_MINUS);
        CHAR_MAP.put('_', KeyEvent.VK_UNDERSCORE);
        CHAR_MAP.put('+', KeyEvent.VK_PLUS);
        CHAR_MAP.put('=', KeyEvent.VK_EQUALS);
        CHAR_MAP.put('{', KeyEvent.VK_BRACELEFT);
        CHAR_MAP.put('}', KeyEvent.VK_BRACERIGHT);
        CHAR_MAP.put('|', KeyEvent.VK_BACK_SLASH);
        CHAR_MAP.put(';', KeyEvent.VK_SEMICOLON);
        CHAR_MAP.put(':', KeyEvent.VK_COLON);
        CHAR_MAP.put('\'', KeyEvent.VK_QUOTE);
        CHAR_MAP.put('"', KeyEvent.VK_QUOTEDBL);
        CHAR_MAP.put('<', KeyEvent.VK_LESS);
        CHAR_MAP.put(',', KeyEvent.VK_COMMA);
        CHAR_MAP.put('>', KeyEvent.VK_GREATER);
        CHAR_MAP.put('.', KeyEvent.VK_PERIOD);
        CHAR_MAP.put('?', KeyEvent.VK_SLASH);
        CHAR_MAP.put('/', KeyEvent.VK_SLASH);
    }

    public static void type(String text) {
        try {
            Robot robot = new Robot();
            for (char c : text.toCharArray()) {
                int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
                if (Character.isUpperCase(c)) {
                    keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
                    robot.keyPress(KeyEvent.VK_SHIFT);
                }
                robot.keyPress(keyCode);
                robot.keyRelease(keyCode);
                robot.keyRelease(KeyEvent.VK_SHIFT);
                robot.delay(KEY_PRESS_DELAY);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}