package com.mvvm.kot.Kotlin_Retrofit_Room_Data_Binding.Repository

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.NonNull
import com.google.gson.annotations.SerializedName

@Entity(tableName = "post_info_bind")
class ResultModel {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    @SerializedName("id")
    private var id: Int = 0
    @NonNull
    @ColumnInfo(name = "body")
    @SerializedName("body")
    private var body: String? = null
    @NonNull
    @ColumnInfo(name = "title")
    @SerializedName("title")
    private var title: String? = null
    @NonNull
    @ColumnInfo(name = "imageUrl")
    @SerializedName("imageUrl")
    private var imageUrl: String? = null


    fun getId(): Int {
        return id
    }

    fun setId(id: Int) {
        this.id = id
    }

    fun getBody(): String? {
        return body
    }

    fun setBody(body: String) {
        this.body = body
    }

    fun getTitle(): String? {
        return title
    }

    fun setTitle(title: String) {
        this.title = title
    }

    fun getImageUrl(): String? {
        return imageUrl
    }

    fun setImageUrl(imageUrl: String) {
        this.imageUrl = imageUrl
    }
    override fun toString(): String {
        return "ClassPojo [id = $id, body = $body, title = $title,imageUrl=$imageUrl]"
    }
}