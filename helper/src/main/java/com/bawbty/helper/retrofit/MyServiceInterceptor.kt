
import com.bawbty.helper.core.SharedPreferencesHelper
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject
import java.io.IOException

/**
 * Interceptor which adds headers from shared preferences according to the added custom headers,
 * Authentication, languageCode and level headers by default.
 * <br></br>
 * when No-Authentication or Single-Language header is set to true add Authentication and multi
 * language headers from prefs
 */
class MyServiceInterceptor
internal constructor() : Interceptor, KoinComponent {

    private val sharedPreferencesHelper: SharedPreferencesHelper by inject()
    private var userToken: String? = null
    private var requestBuilder: Request.Builder? = null

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        requestBuilder = request.newBuilder()

        addAuthenticationHeader()
        requestBuilder!!.addHeader("Content-Type", "application/json")
        requestBuilder!!.addHeader("Accept", "application/json")
        requestBuilder!!.addHeader("content-language", sharedPreferencesHelper.languageCode!!)

        return chain.proceed(requestBuilder!!.build())
    }

    private fun addAuthenticationHeader() {
            userToken = sharedPreferencesHelper.userToken
            if (userToken == ""){
                //log("Null user token in API call that requires authentication")
               //todo userToken=HawelUtil.token
            }
                requestBuilder?.addHeader("Authorization", "Bearer $userToken")
    }
}