import com.mycompany.iamcoacher.guessnumber.GameProcess;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import java.io.PrintStream;

import static org.mockito.Mockito.*;

/**
 * Created by wfsovereign on 15-3-13.
 */
public class GameProcessTest {

    private PrintStream out;
    private GameProcess game;

    @Before
    public void setUp(){
        out = mock(PrintStream.class);
        game = new GameProcess(out);

    }

    @Test
    public void should_print_wellcome_when_game_start(){


        verify(out,never()).println("welcome!");
        game.start();
        verify(out).println("welcome!");


    }

    @Test
    public void should_print_please_input_after_game_start(){
        PrintStream out = mock(PrintStream.class);
        GameProcess game = new GameProcess(out);

        game.start();
        InOrder inOrder = inOrder(out);
        inOrder.verify(out).println("welcome!");
        inOrder.verify(out).println("Please input your number(6): ");

    }


}
