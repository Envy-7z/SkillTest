package com.wisnu.q1_story

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.text.NumberFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class smallRes {
    companion object {
        @JvmStatic fun main(args: Array<String>) {
            val input = BufferedReader(InputStreamReader(System.`in`))
            var data = 0
            var total = 0

            val nama = arrayOfNulls<String>(30)
            val harga = arrayOfNulls<Int>(15)
            var namaToko =""
            var namaKasir =""
            val current = LocalDateTime.now()
            val formatter = DateTimeFormatter.ofPattern("yyyy/MM/yyyy HH:mm:ss")
            val formatted = current.format(formatter)

            println("+===============INPUTAN============================+")
            println("Masukkan nama toko = ")

            namaToko = input.readLine()
            println("Masukkan nama kasir = ")

            namaKasir = input.readLine()
            try {
                println("Masukkan banyak data = ")
                data = input.readLine().toInt()
                for (a in 1..data) {
                    println("------Data ke-$a------")
                    println("Masukan Nama       = ")
                    nama[a] = input.readLine()
                    println("Masukan Harga    = ")
                    harga[a] = input.readLine().toInt()

                    if (nama[a]=="tes"){

                    }
                }
            } catch (e: IOException) {
                println("Error")
            }


            println("\t\t$namaToko\n")
            println("Tanggal : $formatted\n")
            println("Nama Kasir :\t\t $namaKasir\n")
            for (a in 1..data) {
                val str: String = NumberFormat.getNumberInstance(Locale.US).format(harga[a])
                println(String.format("%-20s Rp $str", nama[a]))

                total += harga[a]!!

            }
            val str: String = NumberFormat.getNumberInstance(Locale.US).format(total)
            println(String.format("\n\n%-20s Rp $str" , "Total :"))





        }
    }
}


