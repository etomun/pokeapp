package com.etomun.mobile.pokeapp.data.local.database.friend

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = FriendEntity.TABLE_NAME,
    indices = [Index(value = [FriendEntity.C_NAME], unique = false)]
)
class FriendEntity(
    @ColumnInfo(name = C_NAME) var name: String,
    @ColumnInfo(name = C_AVATAR) var avatarRes: Int
) {
    @ColumnInfo(name = C_ID)
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null

    companion object {
        const val TABLE_NAME = "LJ9f6FkeWJIM7HDPkPRc3ZT0b4UnPe2Z"
        const val C_ID = "FsIPA4zx8t2yFQsjyLYDtVKZ3lM8U18N"
        const val C_NAME = "UnYRctHtplX5WInTWhUobAz1B2bYSm7x"
        const val C_AVATAR = "cZLZoGR6fDt6ZUOApzbtHVXaf6JVNpWF"
    }
}