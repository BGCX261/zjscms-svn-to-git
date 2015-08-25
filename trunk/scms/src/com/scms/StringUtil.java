package com.scms;

import java.util.List;
import java.io.File;
import org.apache.commons.lang.SystemUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.output.FileWriterWithEncoding;

/**
 * String handling class
 * @author Zhujing
 */
public class StringUtil {

    /**
     * To determine whether the string is empty,If it is empty to return true, otherwise returns false.
     * @param parStr To determine the string
     * @return Back to validate the results
     */
    public static boolean isNull(String parStr) {
        return StringUtils.isBlank(parStr);
    }

    /**
     * Remove spaces before and after the string
     * @param parStr String handling
     * @return Clean-up string
     */
    public static String trim(String parStr) {
        return StringUtils.trimToEmpty(parStr);
    }

    /**
     * Back to the current project path
     * @return Path string
     */
    public static String getUserDir() {
        return SystemUtils.getUserDir().getPath();
    }

    /**
     * Given the length of the string in the middle of a particular show
     * @param parStr Center displayed characters
     * @param parSize Length
     * @param parPadChar Fill character
     * @return string
     */
    public static String center(String parStr, int parSize, String parPadChar) {
        return StringUtils.center(parStr, parSize, parPadChar);
    }

    /**
     * Over a specified length of the string will display ellipsis
     * @param parStr String handling
     * @param parMaxSize Set the maximum string length of
     * @return The string after treatment
     */
    public static String abbreviate(String parStr, int parMaxSize) {
        return StringUtils.abbreviate(parStr, parMaxSize);
    }

    /**
     * Read the file information into the List of
     * @param parTableName Data File Name
     * @return Returns a list of data
     */
    public static List<String> getDataListFromFile(String parTableName) {
        List<String> dataList = null;
        try {
            dataList = FileUtils.readLines(new File(parTableName), "GB2312");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return dataList;
    }

    /**
     * write data
     * @param parFile file
     * @param parRow Write string
     */
    public static void writeLines(String parFile, String parRow) {
        try {
            FileWriterWithEncoding fwwe = new FileWriterWithEncoding(new File(parFile), "GB2312", true);
            fwwe.write(parRow);
            fwwe.flush();
            fwwe.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
