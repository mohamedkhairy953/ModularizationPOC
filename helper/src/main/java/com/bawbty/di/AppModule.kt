import android.content.Context
import android.content.SharedPreferences
import com.bawbty.helper.core.SharedPreferencesHelper
import com.bawbty.helper.core.SharedPreferencesHelper.PREF_NAME
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module

/**
 * Created by khairy on ح, 19/ماي/2019 at 09:19 م.
 * mohamed.khairy@apptcom.com
 */
val sharedPrefModule = module {
    single { provideSharedPref(androidContext()) }
    single { provideSharedPrefHelper(get()) }
}



fun provideSharedPrefHelper(sharedPref: SharedPreferences): SharedPreferencesHelper {
    return SharedPreferencesHelper(sharedPref)
}

fun provideSharedPref(context: Context): SharedPreferences {
    return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
}
