package com.parthpatel.daggerhiltpractice.di.module

import android.content.Context
import com.parthpatel.daggerhiltpractice.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Named

@Module
@InstallIn(ActivityComponent::class)
object MainModule {

    @ActivityScoped
    @Provides
    @Named("StringTwo")
    fun provideTestStringTwo(
          @ApplicationContext  context: Context,
          @Named("StringOne") testStringOne: String
    ) = "$testStringOne - ${context.getString(R.string.string_to_inject)}"

}