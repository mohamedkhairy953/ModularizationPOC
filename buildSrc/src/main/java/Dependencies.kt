object ApplicationId {
    val id = "com.bawbty.modularizationpoc"
}

object Modules {
    val app = ":app"
    val application = ":application"
    val helpers = ":helper"
    val login = ":login"
    val register = ":register"
    val database = ":database"
}

object Releases {
    val versionCode = 1
    val versionName = "1.0"
}

object Versions {
    val gradle = "3.3.2"
    val compileSdk = 29
    val minSdk = 21
    val targetSdk = 29
    val junit = "4.12"
    val timber = "4.7.1"
    val safeArgs = "2.1.0-alpha01"


}

object Koin {
    val koin = "org.koin:koin-android:1.0.2"
    val koinViewModel = "org.koin:koin-android-viewmodel:1.0.2"
    val koinTest = "org.koin:koin-test:1.0.2"
}

object Room {
    private const val room = "2.1.0-alpha06"
    val roomCompiler = "androidx.room:room-compiler:$room"
    val roomRunTime = "androidx.room:room-runtime:$room"
    val roomKtx = "androidx.room:room-ktx:$room"
}

object Retrofit {
    private const val retrofitCoroutines = "0.9.2"
    private const val gson_version = "2.8.5"
    private const val retrofit_version = "2.5.0"
    private const val retrofitGson = "2.4.0"
    private const val okHttp = "3.12.1"
    private const val retrofitScalarConverter_version = "2.6.1"

    val retrofitCoroutineAdapter =
        "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:$retrofitCoroutines"
    val gson = "com.google.code.gson:gson:$gson_version"
    val retrofit = "com.squareup.retrofit2:retrofit:$retrofit_version"
    val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:$retrofitGson"
    val httpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:$okHttp"
    val retrofitScalarConverter =
        "com.squareup.retrofit2:converter-scalars:$retrofitScalarConverter_version"
}

object Glide {
    private const val glide_version = "4.9.0"
    val glide = "com.github.bumptech.glide:glide:$glide_version"
}

object Kotlin {
    private const val kotlin_version = "1.3.41"
    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version"

}

object Coroutines {
    private const val coroutines_version = "1.1.1"
    val kotlinCoroutineCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutines_version"
    val kotlinCoroutineAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutines_version"
    val coroutineTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutines_version"
}

object Lifecycle {
    private const val lifecycle_viewmodel = "2.1.0-beta01"
    private const val lifecycle_livedata = "2.2.0-alpha01"
    private const val lifecycle_scope = "2.2.0-alpha01"
    private const val lifecycle = "2.1.0-alpha04"

    val lifecycleViewModel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_viewmodel"
    val lifecycleLiveData =
        "androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_livedata"
    val lifecycleScope = "androidx.lifecycle:lifecycle-runtime-ktx:$lifecycle_scope"
    val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:$lifecycle"
}

object AndroidLibraries {
    private const val appCompat_version = "1.1.0-beta01"
    private const val coreKtx_version = "1.1.0-alpha04"
    private const val constraintLayout_version = "1.1.3"
    private const val recyclerview_version = "1.0.0"

    const val appCompat = "androidx.appcompat:appcompat:$appCompat_version"
    const val coreKtx = "androidx.core:core-ktx:$coreKtx_version"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:$constraintLayout_version"
    const val recyclerView = "androidx.recyclerview:recyclerview:$recyclerview_version"
}

object NavigationUi {
    private const val nav = "2.0.0"
    val navigation = "androidx.navigation:navigation-ui-ktx:$nav"
    val navigationFrag = "androidx.navigation:navigation-fragment-ktx:$nav"
}

object Paging {
    private const val paging_version = "2.1.0"
    val paging = "androidx.paging:paging-runtime-ktx:$paging_version"
    val pagingTest = "androidx.paging:paging-common-ktx:$paging_version"
}

object TestLibraries {
    private const val archCoreTest_version = "2.0.0"
    private const val androidJunit_version = "1.1.0"
    private const val fragmentTest_version = "1.1.0-alpha06"
    private const val databinding_version = "3.3.2"
    private const val androidTestRunner_version = "1.1.2-alpha02"
    const val androidTestRunner = "androidx.test:runner:$androidTestRunner_version"
    const val archCoreTest = "androidx.arch.core:core-testing:$archCoreTest_version"
    const val junit = "androidx.test.ext:junit:$androidJunit_version"
    const val fragmentNav = "androidx.fragment:fragment-testing:$fragmentTest_version"
    const val databinding = "androidx.databinding:databinding-compiler:$databinding_version"

}

object Mocking {
    private const val mockwebserver_version = "2.7.5"
    private const val mockk_version = "1.9.2"
    const val mockWebServer = "com.squareup.okhttp:mockwebserver:$mockwebserver_version"
    const val mockkAndroid = "io.mockk:mockk-android:$mockk_version"
    const val mockk = "io.mockk:mockk:$mockk_version"
}

object Espresso {
    private const val espressoCore_version = "3.2.0-alpha02"
    const val espresso = "androidx.test.espresso:espresso-core:$espressoCore_version"
    const val espressoContrib = "androidx.test.espresso:espresso-contrib:$espressoCore_version"
}