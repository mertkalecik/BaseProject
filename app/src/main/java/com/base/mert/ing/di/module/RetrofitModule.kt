package com.base.mert.ing.di.module

import com.base.mert.ing.BuildConfig
import com.base.mert.ing.api.GithubApi
import com.base.mert.ing.ui.data.home.GithubRepository
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class RetrofitModule {
companion object {
    private const val BASE_URL = "https://api.github.com/"
    private const val API_KEY = "apikey"
}
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        val okHttpBuilder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            okHttpBuilder.addInterceptor(httpLoggingInterceptor)
        }
        okHttpBuilder.addInterceptor {
            val request = it.request()
            val url = request.url().newBuilder()
                    .build()

            it.proceed(request.newBuilder().url(url).build())
        }

        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpBuilder.build())
                .build()
    }

    @Provides
    @Singleton
    fun provideRepository(
            retrofit: Retrofit
    ) =  GithubRepository(
            retrofit.create(GithubApi::class.java)
    )
}