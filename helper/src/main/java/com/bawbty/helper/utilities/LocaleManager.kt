import android.content.Context
import android.content.res.Configuration
import com.bawbty.helper.core.SharedPreferencesHelper
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject
import java.util.*

object LocaleManager : KoinComponent {

    private val mSharedPreference: SharedPreferencesHelper by inject()

    var mEnglishFlag = "en"
    var mArabicFlag = "ar"

    fun setLocale(context: Context?): Context {
        return updateResources(context!!, getCurrentLanguage()!!)
    }

    fun setNewLocale(context: Context, language: String) {

        persistLanguagePreference(language)
        updateResources(context, language)
    }

    fun getCurrentLanguage(): String? {
        return mSharedPreference.languageCode
    }

    private fun persistLanguagePreference(language: String) {

        mSharedPreference.languageCode = language

    }

    private fun updateResources(context: Context, language: String): Context {

        var contextFun = context

        val locale = Locale(language)
        Locale.setDefault(locale)

        val resources = context.resources
        val configuration = Configuration(resources.configuration)

        configuration.setLocale(locale)
        contextFun = context.createConfigurationContext(configuration)

        return contextFun
    }

}