package com.etomun.mobile.pokeapp.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.etomun.mobile.pokeapp.BuildConfig
import com.etomun.mobile.pokeapp.data.local.database.friend.FriendDao
import com.etomun.mobile.pokeapp.data.local.database.friend.FriendEntity

@Database(
    version = AppDatabase.DB_VERSION,
    entities = [
        FriendEntity::class
    ],
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun friendDao(): FriendDao

    companion object {
        const val DB_NAME =
            "PEnBkH7e32qZn0MvQKV3vNZaFFizJiQu" + BuildConfig.FLAVOR + BuildConfig.BUILD_TYPE
        const val DB_VERSION = 1
    }

}