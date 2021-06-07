package com.parthpatel.daggerhiltpractice.di.module

import android.content.Context
import com.parthpatel.daggerhiltpractice.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Named

@Module
@InstallIn(ViewModelComponent::class)
object ViewModelModule {

    @ViewModelScoped
    @Provides
    @Named("StringTwo")
    fun provideTestStringTwo(
          @ApplicationContext  context: Context,
          @Named("StringOne") testStringOne: String
    ) = "$testStringOne - ${context.getString(R.string.string_to_inject)}"


}