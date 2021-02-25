package com.wisnu.q3_jsonmanipulation

data class JsonClass(
    val inventory_id : Int,
    val name : String,
    val type : String,
    val tags : List<String>,
    val purchased_at : String,
    val placement : Place
) {
    data class Place(
        val room_id : Int,
        val name : String
    )
}