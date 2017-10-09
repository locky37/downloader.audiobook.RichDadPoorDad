package downloader.audiobook.RichDadPoorDad;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class Main {

    private static final String BOOK = "https://knigaaudio.online/uploads/books/book202/rus/reader107/128/";
    private static final String EXT = ".mp3";
    private static final String FOLDER = "download/";

    public static void main(String[] args) throws IOException, InterruptedException {
        int num = 1;

        for (int i = 1; i < 32; i++) {
            String link;
            if (String.valueOf(i).length() == 1) {
                link = BOOK + "00" + i + EXT;
            } else {
                link = BOOK + "0" + i + EXT;
            }
            System.out.println(link);
            Thread.sleep(1000);
            URL book = new URL(link);
            ReadableByteChannel rbc = Channels.newChannel(book.openStream());
            FileOutputStream fos = new FileOutputStream(FOLDER + num++ + EXT);
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        }
    }

}
