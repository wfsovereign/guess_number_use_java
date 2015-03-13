import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by wfsovereign on 15-3-13.
 */
public class GameProcess {
    private PrintStream out;
    private final BufferedReader reader;
    private final CompareNumber compareNumber;
    private final AnswerGenerator answerGenerator;

    public GameProcess(PrintStream out, BufferedReader reader, CompareNumber compareNumber, AnswerGenerator answerGenerator) {
        this.out = out;
        this.reader = reader;
        this.compareNumber = compareNumber;
        this.answerGenerator = answerGenerator;
    }

    public void start() throws IOException {
        out.println("welcome!");
        int roundCount = 6;
        String answer = answerGenerator.generate();
        String tips = "";
        while (roundCount > 0){
            out.println("Please input your number("+roundCount+"): ");

            String input = reader.readLine();
            tips = compareNumber.getTips(input,answer);
            if("4A0B".equals(tips)){
                break;
            }
            out.println(tips);
            roundCount--;
        }
        if("4A0B".equals(tips)){
            out.println("Congratulation!!");
            return;
        }
        out.println("Game Over");

    }
}
