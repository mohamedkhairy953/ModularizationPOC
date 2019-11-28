package com.bawbty.database.login

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.bawbty.helper.base.BaseDao

/**
* Created by Khairy at 8/20/2019
* mohamedsallam953@gmail.com
*/
@Dao
interface UserDao : BaseDao<User> {
    @Query("SELECT * FROM User WHERE User.id=:id")
    fun retrieveUser(id: String): LiveData<User>
}