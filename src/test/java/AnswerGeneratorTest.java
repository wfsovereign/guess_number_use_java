import org.junit.Test;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.fest.assertions.api.Assertions.fail;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

/**
 * Created by wfsovereign on 15-3-13.
 */
public class AnswerGeneratorTest {
    @Test
    public void should_generate_4_digits_string(){
        String result = new AnswerGenerator(new Random()).generate();

        assertThat(result.length()).isEqualTo(4);

    }

    @Test
    public void should_generate_number(){
        String result = new AnswerGenerator(new Random()).generate();

        try {
            Integer.parseInt(result);
        } catch (NumberFormatException e) {
            fail("should be number");
        }
    }

    @Test
    public void should_generate_no_duplicated_digits_string(){
        String result = new AnswerGenerator(new Random()).generate();

        for (int i = 0; i < result.length(); i++) {
            assertThat(result.indexOf(result.charAt(i))).isEqualTo(result.lastIndexOf(result.charAt(i)));
        }
    }

    @Test
    public void should_not_repeat_in_3_times(){
        Random random = mock(Random.class) ;
        given(random.nextInt(10))
                .willReturn(1,2,3,4)
                .willReturn(1,2,3,4)
                .willReturn(2,3,4,5)
                .willReturn(3,4,5,6);
        AnswerGenerator answerGenerator = new AnswerGenerator(random);
        Set<String > results = new HashSet<String >();


        results.add(answerGenerator.generate());
        results.add(answerGenerator.generate());
        results.add(answerGenerator.generate());

        assertThat(results.size()).isEqualTo(3);

    }


    @Test
    public void should_result_repeatable_out_of_3_times(){
        Random random = mock(Random.class) ;
        given(random.nextInt(10))
                .willReturn(1,2,3,4)
                .willReturn(1,4,6,7)
                .willReturn(2,3,4,5)
                .willReturn(1,2,3,4);
        AnswerGenerator answerGenerator = new AnswerGenerator(random);
        Set<String > results = new HashSet<String >();


        results.add(answerGenerator.generate());
        results.add(answerGenerator.generate());
        results.add(answerGenerator.generate());

        assertThat(results.size()).isEqualTo(3);

    }


}
