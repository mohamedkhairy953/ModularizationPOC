package com.bawbty.helper.utilities
import android.text.Editable
import android.text.Selection
import android.widget.EditText
import com.bawbty.helper.core.SharedPreferencesHelper
import log
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

/**
 * Created by khairy on خ, 23/ماي/2019 at 03:29 م.
 * mohamed.khairy@apptcom.com
 */
class PinCodeEntry(var ets: List<EditText>) : KoinComponent {
    val sharedPref by inject<SharedPreferencesHelper>()

    init {
        if (sharedPref.languageCode == "ar") {
            log("sharedPref.languageCode")
            ets = ets.asReversed()
        }
        ets.forEachIndexed { i, et ->
            et.addTextChangedListener(object : AbstractTextWatcher() {
                override fun afterTextChanged(s: Editable?) {
                    if (s!!.length == 1) {
                        if (i == ets.lastIndex) return
                        Selection.setSelection(ets[i + 1].text as Editable, ets[i + 1].selectionStart)
                        ets[i + 1].requestFocus()
                    } else {
                        if (i == 0) return
                        Selection.setSelection(ets[i - 1].text as Editable, ets[i - 1].selectionStart)
                        ets[i - 1].requestFocus()
                    }
                }

            })
        }

    }

    fun getPin(): String {
        var str = ""
        ets.forEach {
            str += it.text
        }
        return str
    }

    fun setPin(retrievePin: String) {
        for (i in 0..ets.lastIndex) {
            ets[i].setText(retrievePin[i].toString())
        }
    }
}