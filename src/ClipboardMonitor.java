import java.awt.Toolkit;
import java.io.IOException;
import java.awt.datatransfer.*;

class ClipboardMonitor {
    public static Thread monitorThread;
    static boolean running = false;


    public static boolean start() {
        monitorThread = new Thread(() -> {

            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            String previousText = null;
            try {
                previousText = (String) clipboard.getData(DataFlavor.stringFlavor);
            } catch (UnsupportedFlavorException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            while (running) {
                try {
                    try {
                        Thread.sleep(100);  // delay between checks
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                String copiedText = (String) clipboard.getData(DataFlavor.stringFlavor);
                    if (!copiedText.equals(previousText)) {
                        System.out.println("Copied text: " + copiedText);
                        Typer.type(copiedText);
                        Typer.type(" ");
                        previousText = copiedText;
                    }
                } catch (UnsupportedFlavorException | IOException e) {
                    e.printStackTrace();
                }
            }
        });
        running = true;
        monitorThread.start();
        return running;
    }

    public static boolean stop() {
        running = false;
        monitorThread.stop();
        return running;
    }
}
