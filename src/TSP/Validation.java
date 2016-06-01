package TSP;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class           Validation 
 * File            Validation.java
 * Description     Validate the input to appropriate type
 * Environment     
 * @author 955311412
 */
public class Validation 
{
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * </pre>
     * Method       isInteger
     * Description  Validate input if it is an Integer
     * @return      boolean 
     * @param       String, input 
     * @author      Henry 
     * @see         java.util.regex.Matcher
     * @see         java.util.regex.Pattern
     * </pre> 
     */
    
    public static boolean isInteger(String fieldValue)
    {
        Pattern pat = Pattern.compile("\\d+"); 
        Matcher match = pat.matcher(fieldValue);
        
        return match.matches(); 
    } 
}
