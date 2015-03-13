import java.util.*;

/**
 * Created by wfsovereign on 15-3-13.
 */



public class AnswerGenerator {
    private final List<String> historyGenerateString;
    private Random random;

    public AnswerGenerator(Random random) {

        this.random = random;
        this.historyGenerateString = new ArrayList<String >();
    }

    public String generate() {
        String result = generateAnswerOnce();
        while (historyGenerateString.contains(result)){
            result = generateAnswerOnce();
        }
        if (historyGenerateString.size() == 2){
            historyGenerateString.remove(0);
        }
        historyGenerateString.add(result);
//        System.out.println("==============");
//        System.out.println(historyGenerateString);
        return result;
    }

    private String generateAnswerOnce() {
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
