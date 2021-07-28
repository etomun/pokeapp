package com.etomun.mobile.pokeapp.common.di.module.data

import dagger.Module

@Module(includes = [LocalDataSourceModule::class])
internal abstract class LocalDataModule {
//    @ApplicationScope
//    @Binds
//    abstract fun authPref(authPreference: AuthPreference): AppPreference.AuthPref
//
//    companion object {
//        @ApplicationScope
//        @Provides
//        fun appDatabase(@ApplicationContext context: Context) =
//            Room.databaseBuilder(context, AppDatabase::class.java, AppDatabase.DB_NAME)
//                .allowMainThreadQueries()
//                .build()
}