package com.bawbty.helper.utilities;

import android.text.Html;
import android.text.Spanned;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtils {

    public static boolean isEmail(String email) {
        Pattern pattern = Pattern
                .compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean isMobileNumber(String data) {
        String expr = "(^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$)|([0-9]{10}$)";
        // TODO : Check mobile number regex
        return data.length() == 11;
    }

    public static boolean isCaptialLetter(String data) {
        String expr = ".*[A-Z]+.*";
        return data.matches(expr);
    }

    public static boolean isNumberLetter(String data) {
        String expr = "^[A-Za-z0-9]+$";
        return data.matches(expr);
    }

    public static boolean isStartsWithLetterAndHasNoSpeciaChars(String data) {
        String expr = "^[\\p{L} .'-]+$";
        return data.matches(expr);
    }

    public static boolean isStartsWithLetter(String data) {
        String expr = "^[A-Za-z].*$";
        return data.matches(expr);
    }

    public static boolean isStrongPassword(String data) {
        //todo add more conditions
        String PASSWORD_PATTERN = "((?=.*[a-z])(?=.*\\d)(?=.*[A-Z]).{8,40})";
        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(data);
        return matcher.matches();
    }

    public static boolean isNumber(String data) {
        String expr = "^[0-9]+$";
        return data.matches(expr);
    }

    public static boolean isLetter(String data) {
        String expr = "^[A-Za-z]+$";
        return data.matches(expr);
    }

    public static boolean isPostCode(String data) {
        String expr = "^[0-9]{6,10}";
        return data.matches(expr);
    }

    public static boolean isFacebookProfileLink(String data) {
        String expr = "(?:(?:http|https):\\/\\/)?(?:www.)?facebook.com\\/(?:(?:\\w)*#!\\/)?(?:pages\\/)?(?:[?\\w\\-]*\\/)?(?:profile.php\\?id=(?=\\d.*))?([\\w\\-]*)?";
        return data.matches(expr);
    }

    public static boolean isGooglePlusLink(String data) {
        String expr = "((http|https):\\/\\/)?(www[.])?plus\\.google\\.com\\/.?\\/?.?\\/?([0-9]*)";
        return data.matches(expr);
    }

    // Try to acheive this with a better way
    public static boolean isLinkedinLink(String data) {
        String expr = "^https://[a-z]{2,3}[.]linkedin[.]com/.*$";
        return data.matches(expr);
    }

    /**
     * <p>Checks if a CharSequence is empty ("") or null.</p>
     * <p>
     * <pre>
     * StringUtils.isEmpty(null)      = true
     * StringUtils.isEmpty("")        = true
     * StringUtils.isEmpty(" ")       = false
     * StringUtils.isEmpty("bob")     = false
     * StringUtils.isEmpty("  bob  ") = false
     * </pre>
     *
     * @return {@code true} if the CharSequence is empty or null
     */
    public static boolean isEmpty(final CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

    public static boolean isEmptyAndSpace(final String cs) {
        return cs == null || cs.length() == 0 || cs.equals(" ");
    }

    public static boolean htmlMesageIsEmpty(final String cs) {
        if (cs == null) return true;
        String fromHtml = Html.fromHtml((cs),
                null, new ATCHtmlTagHandler()).toString();
        return fromHtml == null || fromHtml.trim().length() == 0;
    }

    public static Spanned makeStringBold(String s) {
        String habitnumber = "<b>" + s + "</b>" + "";
        return Html.fromHtml(habitnumber);
    }

}
