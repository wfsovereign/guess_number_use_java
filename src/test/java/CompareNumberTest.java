import com.mycompany.iamcoacher.guessnumber.CompareNumber;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;


/**
 * Created by wfsovereign on 15-3-12.
 */
public class CompareNumberTest {
    @Test
    public void should_return_4A0B_when_input_is_1234(){

        String input = "1234";
        String answer = "1234";

        CompareNumber compareNumber = new CompareNumber();
        String result = compareNumber.getTips(input,answer);

        assertThat(result).isEqualTo("4A0B");
    }

    @Test
    public void shoul_return_4A0B_when_input_1234_and_answer_is_5678(){
        String input = "1234";
        String answer = "5678";

        String result = new CompareNumber().getTips(input,answer);

        assertThat(result).isEqualTo("0A0B");
    }

}
