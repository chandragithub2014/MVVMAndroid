package com.mvvm.kot.Kotlin_Retrofit.Repository

import com.google.gson.annotations.SerializedName

class ResultModel {
    @SerializedName("id")
    private var id: Int = 0
    @SerializedName("body")
    private var body: String? = null
    @SerializedName("title")
    private var title: String? = null
    @SerializedName("userId")
    private var userId: String? = null

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

    fun getUserId(): String? {
        return userId
    }

    fun setUserId(userId: String) {
        this.userId = userId
    }

    override fun toString(): String {
        return "ClassPojo [id = $id, body = $body, title = $title, userId = $userId]"
    }
}