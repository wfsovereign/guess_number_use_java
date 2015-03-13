import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.fest.assertions.api.Assertions.fail;

/**
 * Created by wfsovereign on 15-3-13.
 */
public class AnswerGeneratorTest {
    @Test
    public void should_generate_4_digits_string(){
        String result = new AnswerGenerator().generare();

        assertThat(result.length()).isEqualTo(4);

    }

    @Test
    public void should_generate_number(){
        String result = new AnswerGenerator().generare();

        try {
            Integer.parseInt(result);
        } catch (NumberFormatException e) {
            fail("should be number");
        }
    }

    @Test
    public void should_generate_no_duplicated_digits_string(){
        String result = new AnswerGenerator().generare();

        for (int i = 0; i < result.length(); i++) {
            assertThat(result.indexOf(result.charAt(i))).isEqualTo(result.lastIndexOf(result.charAt(i)));
        }
    }


}
