package com.parthpatel.daggerhiltpractice.di.module

import android.content.Context
import android.media.MediaPlayer
import android.provider.Settings
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ServiceComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ServiceScoped

@Module
@InstallIn(ServiceComponent::class)
object ServiceModule {

    @ServiceScoped
    @Provides
    fun provideMediaServiceInstance(
        @ApplicationContext context: Context
    ): MediaPlayer = MediaPlayer.create(
        context,
        Settings.System.DEFAULT_RINGTONE_URI
    )

}