package za.co.mmagon.jwebswing.utilities;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.StringTokenizer;

/**
 * Provides default text functions
 *
 * @author MMagon
 * @since 08 May 2013
 * @version 1.0
 */
public class TextUtilities
{

    /**
     * Updates an attribute name by changing the enum to a clean format
     * @param buildStringSB
     * @return 
     */
    public static final synchronized StringBuilder cleanAttributeName(StringBuilder buildStringSB)
    {
        String buildString = buildStringSB.toString();
        buildString = buildString.replace('$', ' ');
        buildString = buildString.replace('_', '-');
        buildString = buildString.replace('-', ' ').trim();
        StringTokenizer st = new StringTokenizer(buildString);
        String outputString = "";
        while (st.hasMoreElements())
        {
            StringBuilder newSb = new StringBuilder(st.nextToken());
            Character firstChar = newSb.charAt(0);
            firstChar = firstChar.toString().toUpperCase().charAt(0);
            String restOfIt = newSb.substring(1, newSb.length()).toLowerCase();
            newSb = new StringBuilder();
            //newSb.deleteCharAt(0);
            newSb.append(firstChar);
            newSb.append(restOfIt);
            outputString += newSb + " ";
        }

        return new StringBuilder(outputString);
    }

    /**
     * Camel Case Replacement
     * @param hello
     * @return 
     */
    public static final synchronized StringBuilder cleanCamelCaseName(String hello)
    {
        return cleanCamelCaseName(new StringBuilder(hello));
    }

    /**
     * Camel Case Replacement
     * @param buildStringSB
     * @return 
     */
    public static final synchronized StringBuilder cleanCamelCaseName(StringBuilder buildStringSB)
    {
        String buildString = buildStringSB.toString();
        buildString = buildString.replace('$', ' ');
        buildString = buildString.replace('_', '-');
        buildString = buildString.replace('-', ' ');
        String firstChar = buildString.substring(0, 1).toUpperCase();
        buildString = firstChar + buildString.substring(1, buildString.length());

        String cleanCamelCase = "";
        char[] buildStringChars = buildString.toCharArray();
        char prevChar = '`';
        for (Character buildStringChar : buildStringChars)
        {
            if (prevChar == ' ' && !Character.isUpperCase(buildStringChar))
            {
                buildStringChar = Character.toUpperCase(buildStringChar);
                cleanCamelCase += " " + buildStringChar;
            }
            else if (Character.isUpperCase(buildStringChar))
            {
                cleanCamelCase += " " + buildStringChar;
            }
            else
            {
                cleanCamelCase += buildStringChar;
            }
        }

        return new StringBuilder(cleanCamelCase);
    }

    /**
     * Cleans the attribute name
     * @param s
     * @return 
     */
    public static final synchronized String cleanAttributeName(String s)
    {
        return TextUtilities.cleanAttributeName(new StringBuilder(s)).toString();
    }

    /**
     * Does the init cap
     * @param s
     * @return 
     */
    public static final synchronized String initCap(String s)
    {
        return TextUtilities.initCap(new StringBuilder(s)).toString();
    }

    /**
     * Performs an Init Cap
     * @param s
     * @return 
     */
    public static final synchronized StringBuilder initCap(StringBuilder s)
    {
        StringTokenizer st = new StringTokenizer(s.toString());
        String buildString = "";
        while (st.hasMoreElements())
        {
            StringBuilder newSb = new StringBuilder(st.nextToken());
            Character firstChar = newSb.charAt(0);
            firstChar = firstChar.toString().toUpperCase().charAt(0);
            newSb.deleteCharAt(0);
            newSb.insert(0, firstChar);
            buildString += newSb + " ";
        }
        return new StringBuilder(buildString);
    }

    /**
     * Returns a string of tabs the length of count
     *
     * @param tabCount Number of tabs to append
     * @return The output string of tabs
     */
    public static final synchronized StringBuilder getTabString(Integer tabCount)
    {
        Integer indentationDepth = tabCount;
        StringBuilder tabIndents = new StringBuilder("");
        for (int i = 0; i < indentationDepth; i++)
        {
            tabIndents.append("\t");
        }
        return tabIndents;
    }

    /**
     * Returns a stack trace as a string
     * <p>
     * @param e The Exception Object
     * @return The Stack Trace as a String
     */
    public static final synchronized String stackTraceToString(Throwable e)
    {
        String retValue = null;
        StringWriter sw = null;
        PrintWriter pw = null;
        try
        {
            sw = new StringWriter();
            pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            retValue = sw.toString();
        }
        finally
        {
            try
            {
                if (pw != null)
                {
                    pw.close();
                }
                if (sw != null)
                {
                    sw.close();
                }
            }
            catch (IOException ignore)
            {
            }
        }
        return retValue;
    }

    /**
     * Returns Enum instance from class type
     * <p>
     * @param <T>       Return type
     * @param value     The value to pass through
     * @param enumClass The Enum class
     * @return
     */
    public static <T extends Enum<T>> T getInstance(final String value, final Class<T> enumClass)
    {
        return Enum.valueOf(enumClass, value);
    }

    /**
     * Removes the last index of a group
     *
     * @param sb
     * @return
     */
    public static StringBuilder removeLastInstanceOf(StringBuilder sb)
    {
        if (sb.length() > 0)
        {
            if (sb.lastIndexOf(",") != -1)
            {
                sb = sb.deleteCharAt(sb.lastIndexOf(","));
            }
        }
        return sb;
    }
}
