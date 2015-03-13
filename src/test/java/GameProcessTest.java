import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

/**
 * Created by wfsovereign on 15-3-13.
 */
public class GameProcessTest {

    private PrintStream out;
    private GameProcess game;
    private AnswerGenerator answerGenerator;
    private BufferedReader reader;

    @Before
    public void setUp() throws IOException {
        out = mock(PrintStream.class);
        reader = mock(BufferedReader.class);
        CompareNumber compareNumber = new CompareNumber();
        answerGenerator = mock(AnswerGenerator.class);
        given(reader.readLine()).willReturn("1234");
        given(answerGenerator.generate()).willReturn("4321");
        game = new GameProcess(out, reader,compareNumber, answerGenerator);


    }

    @Test
    public void should_print_wellcome_when_game_start() throws IOException {


        verify(out,never()).println("welcome!");
        game.start();
        verify(out).println("welcome!");


    }

    @Test
    public void should_print_please_input_after_game_start() throws IOException {


        game.start();
        InOrder inOrder = inOrder(out);
        inOrder.verify(out).println("welcome!");
        inOrder.verify(out).println("Please input your number(6): ");

    }

    @Test
    public void should_reduce_one_chance_when_guess_wrong() throws IOException {


        game.start();
        InOrder inOrder = inOrder(out);

        inOrder.verify(out).println("welcome!");
        inOrder.verify(out).println("Please input your number(6): ");
        inOrder.verify(out).println("0A4B");
        inOrder.verify(out).println("Please input your number(5): ");
    }

}
