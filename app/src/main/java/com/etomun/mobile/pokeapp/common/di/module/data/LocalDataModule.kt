package com.etomun.mobile.pokeapp.common.di.module.data

import android.content.Context
import androidx.room.Room
import com.etomun.mobile.pokeapp.common.di.qualifier.android.ApplicationContext
import com.etomun.mobile.pokeapp.common.di.scope.ApplicationScope
import com.etomun.mobile.pokeapp.data.local.database.AppDatabase
import com.etomun.mobile.pokeapp.data.local.preference.AppPreference
import com.etomun.mobile.pokeapp.data.local.preference.AuthPreference
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module(includes = [LocalDataSourceModule::class])
internal abstract class LocalDataModule {
    @ApplicationScope
    @Binds
    abstract fun authPref(authPreference: AuthPreference): AppPreference.AuthPref

    companion object {
        @ApplicationScope
        @Provides
        fun appDatabase(@ApplicationContext context: Context) =
            Room.databaseBuilder(context, AppDatabase::class.java, AppDatabase.DB_NAME)
                .allowMainThreadQueries()
                .build()
    }
}