package com.parthpatel.daggerhiltpractice.model

import com.google.gson.annotations.SerializedName

data class UserModel(
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("username")
    val username: String? = "",
    @SerializedName("email")
    val email: String? = "",
    @SerializedName("address")
    val address: Address? = Address(),
    @SerializedName("phone")
    val phone: String? = "",
    @SerializedName("website")
    val website: String? = "",
    @SerializedName("company")
    val company: Company? = Company()
) {
    data class Address(
        @SerializedName("street")
        val street: String? = "",
        @SerializedName("suite")
        val suite: String? = "",
        @SerializedName("city")
        val city: String? = "",
        @SerializedName("zipcode")
        val zipcode: String? = "",
        @SerializedName("geo")
        val geo: Geo? = Geo()
    ) {
        data class Geo(
            @SerializedName("lat")
            val lat: String? = "",
            @SerializedName("lng")
            val lng: String? = ""
        )
    }

    data class Company(
        @SerializedName("name")
        val name: String? = "",
        @SerializedName("catchPhrase")
        val catchPhrase: String? = "",
        @SerializedName("bs")
        val bs: String? = ""
    )
}