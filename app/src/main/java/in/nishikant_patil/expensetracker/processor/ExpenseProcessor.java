package in.nishikant_patil.expensetracker.processor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import in.nishikant_patil.expensetracker.model.Message;

/**
 * Created by Nishikant on 7/12/2015.
 */
public class ExpenseProcessor {
    private static final ThreadLocal<Pattern> expensePattern = new ThreadLocal<Pattern>(){
        @Override
        public Pattern get(){
            return Pattern.compile("^.*(debited|purchase).*INR.*$");
        }
    };

    public static boolean process(Message message){
        String content = message.getContent();
        Matcher patternMatcher = expensePattern.get().matcher(content);
        return patternMatcher.find();
    }
}
