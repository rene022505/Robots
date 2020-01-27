import java.awt.*;
import java.awt.event.InputEvent;

public class mainClass {

    static private Robot robot = null;

    static {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    static final private int maxX = 1006;
    static final private int maxY = 1012;
    static final private int minX = 12;
    static final private int minY = 120;

    static final private int knopfFarbeX = 1512;
    static final private int knopfFarbeY = 988;
    static final private int knopfOkFarbeX = 43;
    static final private int knopfOkFarbeY = 308;

    // Farben
    static final private int rotX = 25;
    static final private int rotY = 83;
    static final private int gelbX = 50;
    static final private int gelbY = 80;
    static final private int schwarzX = 25;
    static final private int schwarzY = 170;
    static final private int weißX = 205;
    static final private int weißY = 170;

    static private void allesNeu() {
        robot.mouseMove(minX, minY);
        robot.mouseMove(minX, minY);

        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);

        int y = minY;

        for (int i = 0; i < ((maxY - minY) / 12) + 1; i++) {
            if (i % 2 == 0) {
                robot.delay(20);
                robot.mouseMove(maxX, y);
                y += 12;
                robot.delay(20);
                robot.mouseMove(maxX, y);
            } else {
                robot.delay(20);
                robot.mouseMove(minX, y);
                y += 12;
                robot.delay(20);
                robot.mouseMove(minX, y);
            }
        }
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

    static private void kreisAusgefüllt(int inX, int inY, int r) {
        robot.mouseMove(inX, inY);
        robot.mouseMove(inX, inY);

        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        for (int i = 1; i < 361; i++) {
            double y = Math.sin((Math.toDegrees((double) i) * Math.PI) / Math.toDegrees(180)) * r;
            double x = y / Math.tan((Math.toDegrees((double) i) * Math.PI) / Math.toDegrees(180));
            robot.delay(20);
            robot.mouseMove(inX + (int) x, inY + ((int) y * -1) );
            robot.delay(20);
            robot.mouseMove(inX, inY);
        }
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

    static private void kreisRand(int inX, int inY, int r) {
        double y = Math.sin((Math.toDegrees((double) 1) * Math.PI) / Math.toDegrees(180)) * r;
        double x = y / Math.tan((Math.toDegrees((double) 1) * Math.PI) / Math.toDegrees(180));
        robot.mouseMove(inX + (int) x, inY + ((int) y * -1));
        robot.mouseMove(inX + (int) x, inY + ((int) y * -1));
        robot.delay(20);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        for (int i = 1; i < 361; i++) {
            y = Math.sin((Math.toDegrees((double) i) * Math.PI) / Math.toDegrees(180)) * r;
            x = y / Math.tan((Math.toDegrees((double) i) * Math.PI) / Math.toDegrees(180));
            robot.delay(20);
            robot.mouseMove(inX + (int) x, inY + ((int) y * -1) );
        }
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

    private static void linksKlick() {
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(20);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

    private static void muster1() {
        boolean farbe = true;

        robot.mouseMove((maxX + minX) / 2, (maxY + minY) / 2);
        robot.mouseMove((maxX + minX) / 2, (maxY + minY) / 2);
        linksKlick();

        for (int i = 10; i < 480; i += 10) {
            if (farbe) {
                robot.mouseMove(knopfFarbeX, knopfFarbeY);
                linksKlick();
                robot.mouseMove(weißX, weißY);
                robot.delay(250);
                linksKlick();
                robot.mouseMove(knopfOkFarbeX, knopfOkFarbeY);
                robot.delay(250);
                linksKlick();
                kreisRand((maxX + minX) / 2, (maxY + minY) / 2, i);
                farbe = false;
            } else {
                robot.mouseMove(knopfFarbeX, knopfFarbeY);
                linksKlick();
                robot.mouseMove(schwarzX, schwarzY);
                robot.delay(250);
                linksKlick();
                robot.mouseMove(knopfOkFarbeX, knopfOkFarbeY);
                robot.delay(250);
                linksKlick();
                kreisRand((maxX + minX) / 2, (maxY + minY) / 2, i);
                farbe = true;
            }
        }
    }

    public static void main(String[] args) {

    }

}
