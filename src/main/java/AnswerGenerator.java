import java.util.Random;

/**
 * Created by wfsovereign on 15-3-13.
 */
public class AnswerGenerator {
    public String generare() {
        Random random = new Random();
        StringBuilder result = new StringBuilder();
        while (result.length()<4){
            String digit = String .valueOf(random.nextInt(10));
            if(result.indexOf(digit) == -1){
                result.append(digit);
            }
        }
        return result.toString();
    }
}
