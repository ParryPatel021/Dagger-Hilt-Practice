package com.parthpatel.daggerhiltpractice.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.scopes.FragmentScoped
import javax.inject.Named

@Module
@InstallIn(FragmentComponent::class)
object FragmentModule {

    @FragmentScoped
    @Provides
    @Named("StringFrg")
    fun provideTestStringFrg(
        @Named("StringOne") testStringOne: String
    ) = "$testStringOne - Fragment Injection"

}