package com.etomun.mobile.pokeapp.data.local.database.friend

import androidx.room.Dao
import androidx.room.Query
import com.etomun.mobile.pokeapp.data.local.base.BaseDao
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single

@Dao
interface FriendDao : BaseDao<FriendEntity> {
    @Query("select * from ${FriendEntity.TABLE_NAME}")
    fun getAllFriends(): Single<List<FriendEntity>>

    @Query("select * from ${FriendEntity.TABLE_NAME} where ${FriendEntity.C_ID} = :friendId")
    fun getFriend(friendId: Int): Observable<List<FriendEntity>>

    @Query("select * from ${FriendEntity.TABLE_NAME} where ${FriendEntity.C_NAME} like :query")
    fun searchFriends(query: String): Single<List<FriendEntity>>

    @Query("delete from ${FriendEntity.TABLE_NAME}")
    fun clearTable(): Maybe<Int>
}