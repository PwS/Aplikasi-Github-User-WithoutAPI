package com.pws.dicodingsubmission

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by PwS
 */

@Parcelize
data class User(
    var avatar: Int,
    var username: String,
    var name: String,
    var location: String,
    val repository: String,
    val company: String,
    val followers: String,
    val following: String
) : Parcelable