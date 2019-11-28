import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.annotation.NonNull
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.navigation.NavOptions
import androidx.navigation.fragment.NavHostFragment
import com.bawbty.helper.alerts.UiMessagesUtils
import com.bawbty.helper.utilities.NetworkUtils

/**
 * Created by khairy on ث, 21/ماي/2019 at 07:00 م.
 * mohamed.khairy@apptcom.com
 */
fun Fragment.navigate(@IdRes actionId: Int, bundle: Bundle = bundleOf("" to true)) {
    try {
        NavHostFragment.findNavController(this).navigate(actionId, bundle)
    } catch (e: Exception) {
    }
}

fun Fragment.navigate(@IdRes actionId: Int, navOption: NavOptions) {
    try {
        NavHostFragment.findNavController(this).navigate(actionId, null, navOption)
    } catch (e: Exception) {
    }
}

fun Fragment.checkNetwork() = NetworkUtils.isNetworkAvailable(context)

fun View.onClick(func: () -> Unit) = setOnClickListener { func() }

fun TextView.setTextWithValue(
    @NonNull originalString: String, strToReplace: String,
    value: String?
) {
    if (value == null) return
    val replaced = originalString.replace(strToReplace, value, true)
    text = replaced
}

fun View.makeVisibleWhen(b: Boolean) {
    visibility = if (b)
        View.VISIBLE
    else
        View.GONE
}

fun Fragment.showErrorToastWhen(b: Boolean, throwable: Throwable?) {
    if (b)
        UiMessagesUtils().showToast(context, throwable?.message)
}

fun Fragment.observeNoNetworkToast(ml: MutableLiveData<Boolean>, strIdRes: Int) {
    ml.observe(viewLifecycleOwner, Observer {
        UiMessagesUtils().showToast(context, strIdRes)
    })

}

fun TextView.replaceHshWithValue(@NonNull originalString: String, value: String?) {
    if (value == null) return
    val replaced = originalString.replace("##", value, true)
    text = replaced
}

fun Any.log(str: String) {
    Log.d("LOGD", str)
}
