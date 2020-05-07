import java.awt.*;

public class Config {
    public static final int SIZE = 20;
    public static final int WIDTH = 20;
    public static final int HEIGHT = 20;
    public static final int SLEEP_MS = 100;

    public static Color getColor(Status status) {
        switch (status) {
            default:
            case NONE:
                return Color.BLACK;
            case BORN:
                return Color.GRAY;
            case LIVE:
                return Color.WHITE;
            case DIED:
                return Color.RED;
        }
    }
}