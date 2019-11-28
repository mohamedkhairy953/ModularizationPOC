package com.bawbty.helper.utilities;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;

/**
 * Created by khairy on ر, 08/ماي/2019 at 12:25 م.
 * mohamed.khairy@apptcom.com
 */
public class StringUtilities {

    public static Spannable getUnderLinedText(String text) {
        SpannableString content = new SpannableString(text);
        content.setSpan(new UnderlineSpan(), 0, text.length(), 0);
        return content;
    }
}
