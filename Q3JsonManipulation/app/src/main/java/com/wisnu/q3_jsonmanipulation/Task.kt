package com.wisnu.q3_jsonmanipulation

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

//Your tasks to create functions:
//
//Find items in the Meeting Room.
//Find all electronic devices.
//Find all the furniture.
//Find all items were purchased on 16 Januari 2020.
//Find all items with brown color.

class Task {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
          running()
            convertLongToTime(201801102222)
        }
    }
}


fun running() {
    var ulang = true
    var pil: String
    val `in` = Scanner(System.`in`)

    while (ulang == true) {

        print("Enter the task you want to run : ")
    var input = readLine()!!.toInt()

    val gson = Gson()
    val json = JsonArray().jsonInventory
    var listType = object : TypeToken<List<JsonClass>>() {}.type
    var dataInventory: List<JsonClass> = gson.fromJson(json, listType)


    var listItem: ArrayList<Int> = arrayListOf()

    for (position in dataInventory.indices) {
        var data = dataInventory[position]
        when (input) {
            1 -> {
                var place = data.placement.name
                if (place == "Meeting Room") {
                    listItem.add(position)
                }
            }
            2 -> {
                var type = data.type
                if (type == "electronic") {
                    listItem.add(position)
                }
            }

            3 -> {
                var type = data.type
                if (type == "furniture") {
                    listItem.add(position)
                }
            }

            4 -> {
                var date = data.purchased_at
                if (date == "16012020") {
                    listItem.add(position)
                }
            }
            5 -> {
                var tags = data.tags
                for (tag in 0..tags.size - 1) {
                    if (tags[tag] == "brown") {
                        listItem.add(position)
                    }
                }
            }
            else -> if (position == dataInventory.size-1) println("Your number invalid")
        }
        if (position == dataInventory.size - 1 && input <= 5) {
            if (listItem.size != 0) {
                for (item in 0..listItem.size - 1) {
                    var dataList = dataInventory[listItem[item]]
                    when (input) {
                        1 -> println("Name : ${dataList.name} in Meeting Room")
                        2 -> {
                            println(" Name : ${dataList.name}")
                            if (item == listItem.size - 1) println("is Electronic Devices")
                        }
                        3 -> {
                            println("Name : ${dataList.name}")
                            if (item == listItem.size - 1) println("is Furniture")
                        }
                        4 -> {
                            println("Name : ${dataList.name}")
                            if (item == listItem.size - 1) println("was purchased at 16 Januari 2020")
                        }
                        5 -> {
                            println("Name : ${dataList.name}")
                            if (item == listItem.size - 1) println("is Brown Color")
                        }
                    }
                }
            }
            else {
                println("Item Not Found")
            }
        }

    }
        print("Again? (y/n): ")
        pil = `in`.next()
        if (pil == "n") {
            ulang = false
        }
    }
}

fun convertLongToTime(time: Long): String {
    val date = Date(time)
    val format = SimpleDateFormat("yyyy.MM.dd HH:mm")
    print(format.format(date))
    return format.format(date)
}

fun currentTimeToLong(): Long {
    return System.currentTimeMillis()
}

fun convertDateToLong(date: String): Long {
    val df = SimpleDateFormat("yyyy.MM.dd HH:mm")
    return df.parse(date).time
}