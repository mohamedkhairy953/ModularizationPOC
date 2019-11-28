import com.bawbty.helper.BuildConfig
import com.bawbty.helper.retrofit.LiveDataCallAdapterFactory
import com.bawbty.helper.retrofit.NullOnEmptyConverterFactory
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

/**
 * Created by khairy on ح, 19/ماي/2019 at 09:03 م.
 * mohamed.khairy@apptcom.com

 */

val networkModule = module {
    single { provideHttpLoggingInterceptor() }
    single { provideServiceInterceptor() }
    single { provideOkHttpClient(get(), get()) }
    single { provideGson() }
    single { provideRetrofit(get(), get()) }
}

fun provideServiceInterceptor(): MyServiceInterceptor {
    return MyServiceInterceptor()
}


fun provideOkHttpClient(myServiceInterceptor: MyServiceInterceptor, interceptor: HttpLoggingInterceptor): OkHttpClient {
    val builder = OkHttpClient.Builder()
    builder.addInterceptor(myServiceInterceptor)
    builder.addNetworkInterceptor(interceptor)
    return builder.build()
}

fun provideGson(): Gson {
    val gsonBuilder = GsonBuilder()
    gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .setDateFormat("yyyy-MM-dd HH:mm:ss")
        .setPrettyPrinting()
    return gsonBuilder.create()
}

fun provideRetrofit(client: OkHttpClient, gson: Gson): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .client(client)
        .addConverterFactory(NullOnEmptyConverterFactory())
        .addConverterFactory(ScalarsConverterFactory.create()) //the ordering is importing, we must but ScalersConverter before Gson
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(LiveDataCallAdapterFactory())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
    return if (BuildConfig.DEBUG)
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    else
        HttpLoggingInterceptor()
}
