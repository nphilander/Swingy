package folder1.View;

import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Scanner;

public class InputHandler {
    public Scanner scanner;

    /**GUI constructor*/
    public InputHandler(PipedOutputStream out) throws IOException {
        InputStream in = new PipedInputStream(out);
        scanner = new Scanner(in);
    }

}
