import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * ----------------------------------------------------------------------------  <br>
 * ProblemInput.java created byTheo Dimopoulos on 09-01-2017.                                <br>
 * Email:   dimopoulosth.td@gmail.com | td41@st-andrews.ac.uk                             <br>
 * ----------------------------------------------------------------------------  <br>
 *
 * @author Theo Dimopoulos
 * @version 09-01-2017
 */
public class ProblemInput {

    private File file;
    private BufferedReader bufferedReader;

    private int R, C;    //Pizza rows columns
    private int L;      //Min number of ingredients in slice
    private int H;      //Max number of cells in slice

    public ProblemInput(String uri) {

        try {
            file = new File(uri);
            bufferedReader = new BufferedReader(new FileReader(file));

            String[] constraints = bufferedReader.readLine().split(" ");
            initializeValues(constraints);

            char[][] pizza = new char[R][C];
            char c;
            for (int row = 0; row < R; row++) {
                for (int col = 0; col < C; col++) {
                    c = (char) bufferedReader.read();
                    if (c != 'T' && c != 'M')
                        c = (char) bufferedReader.read();

                    pizza[row][col] = c;
                }
            }


            for (int i = 0; i < R; i++) {
                System.out.println(i + " " + Arrays.toString(pizza[i]));
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void initializeValues(String[] line) {
        R = Integer.parseInt(line[0]);
        C = Integer.parseInt(line[1]);
        L = Integer.parseInt(line[2]);
        H = Integer.parseInt(line[3]);
    }
}
