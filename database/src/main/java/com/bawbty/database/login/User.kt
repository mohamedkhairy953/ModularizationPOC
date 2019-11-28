package com.bawbty.database.login

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
* Created by Khairy at 8/20/2019
* mohamedsallam953@gmail.com
*/
@Entity
data class User(@PrimaryKey val id:Int, val name: String)