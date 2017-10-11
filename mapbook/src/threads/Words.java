package threads;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Words extends Thread{
    /**
     * total number of words in the file.
     */
    private int words = 0;
    /**
     * list of lines from the file.
     */
    private List<String> lines = new ArrayList<>();
    /**
     * constructor.
     * @param lines -
     */
    public Words(List<String> lines) {
        this.lines = lines;
    }
    /**
     * getWords.
     * @return words.
     */
    public int getWords() {
        return words;
    }
    /**
     * counting the total number of words in a line.
     */
    @Override
    public void run() {
        for (String line : this.lines) {
            int buffer = readWords(line);
            this.words += buffer;
            System.out.format("%d number of words \n", buffer);
            try {
                Thread.sleep(200);
            } catch (InterruptedException ie) {
                break;
            }
        }
    }
    /**
     * counting the number of words in a line.
     * @param line - from method "run"
     * @return the number of words in a line.
     */
    private int readWords(final String line) {
        int index = 1;

        for (int i = 0; i < line.length() - 2; i++) {
            if (line.charAt(i) != ' ' & line.charAt(i + 1) == ' ' & line.charAt(i + 2) != ' ') {
                index++;
            }
        }
        return index;
    }
}
/**
 * Spaces.
 * reading the number of spaces in the text
 * @author Aleksundrr Vahheedofv (mailto:arbuzz333@hotmail.com)
 * @version $Id$
 * @since 0.1
 */
class Spaces {
    /**
     * total number of spaces in the file.
     */
    private int spaces = 0;
    /**
     * path of the file.
     */
    private String file;
    /**
     * constructor.
     * @param file -
     */
    Spaces(String file) {
        this.file = file;
    }
    /**
     * counting the total number of spaces in a line, not more than 1 second.
     * @throws IOException - "file not find".
     * @throws InterruptedException - thread interruption
     */
    public void numberSpaces() throws InterruptedException, IOException {
        long start;
        start = System.nanoTime();

        System.out.println("The program for the counting of words and "
                + "spaces begins to function");

        List<String> lines = readLne();

        Words secondThreads = new Words(lines);
        secondThreads.start();

        for (String line : lines) {
            if (secondThreads.isInterrupted()) {
                break;
            }
            int buffer = readSpaces(line);
            this.spaces += buffer;
            System.out.format("%d number of spaces  \n", buffer);

            Thread.sleep(200);

            long end = System.nanoTime();
            int time = (int) (end - start) / 1000000;
            System.out.format("program execution time %d \n", time);
            if (time > 1000) {
                secondThreads.interrupt();
            }
        }

        secondThreads.join();

        System.out.format("total number of counted words %d; "
                        + "total number of counted spaces %d. \n",
                secondThreads.getWords(), this.spaces);
    }
    /**
     * reading lines from a file.
     * @return ArrayList<String>
     * @throws IOException - "file not find".
     */
    private List<String> readLne() throws IOException {
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(Paths.get(this.file), StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println("file not find");
        }
        return lines;
    }
    /**
     * counting the number of spaces in a line.
     * @param line - from method "numberSpaces"
     * @return the number of spaces in a line.
     */
    private int readSpaces(final String line) {
        int index = 0;

        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == ' ') {
                index++;
            }
        }
        return index;
    }
}
