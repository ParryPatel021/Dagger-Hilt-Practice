package com.parthpatel.daggerhiltpractice.di.module

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.parthpatel.daggerhiltpractice.R
import com.parthpatel.daggerhiltpractice.api.RetrofitService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    @Named("StringOne")
    fun provideTestStringOne() = "This is a string we will inject One"

    /* @Singleton
     @Provides
     @Named("StringTwo")
     fun provideTestStringTwo() = "This is a string we will inject Two"*/

    @Singleton
    @Provides
    @Named("ROProfile")
    fun provideProfileRequestOption() = RequestOptions()
        .placeholder(R.drawable.profile_placeholder)
        .error(R.drawable.profile_placeholder)

    @Singleton
    @Provides
    @Named("ROCover")
    fun provideCoverRequestOption() = RequestOptions()
        .placeholder(R.drawable.header_small)
        .error(R.drawable.header_small)

    @Singleton
    @Provides
    @Named("glideCover")
    fun provideGlideCoverInstance(
        @ApplicationContext context: Context,
        @Named("ROCover") requestOptions: RequestOptions
    ) = Glide.with(context)
    /*.applyDefaultRequestOptions(requestOptions)*/

    @Singleton
    @Provides
    @Named("glidePerson")
    fun provideGlidePersonInstance(
        @ApplicationContext context: Context,
        @Named("ROProfile") requestOptions: RequestOptions
    ) = Glide.with(context)
    /*.applyDefaultRequestOptions(requestOptions)*/

    //Retrofit
    @Singleton
    @Provides
    fun provideRetrofitInstance(
        client: OkHttpClient
    ): RetrofitService {

        val BASE_URL = "https://jsonplaceholder.typicode.com/"

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitService::class.java)
    }

    @Singleton
    @Provides
    fun provideOkHttpClientBuilder(): OkHttpClient {
        val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }

        return OkHttpClient.Builder()
            .addInterceptor(logger)
            .build()
    }


}