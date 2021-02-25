package com.wisnu.q1_story

import java.util.*
//tes do while
class tes {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val `in` = Scanner(System.`in`)

            var ulang = true
            val index = 0
            var pil: String

            val nama = arrayOfNulls<String>(100)
            while (ulang == true) {
                print("Masukkan nama: ")
                nama[index] = `in`.next()
                print("lagi? (y/n): ")
                pil = `in`.next()
                if (pil == "n") {
                    ulang = false
                }
            }
        }
    }
}
