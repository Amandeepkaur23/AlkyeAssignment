package com.example.alkyeassignment

import android.content.Context
import com.example.alkyeassignment.model.DetailData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.InputStreamReader

// Method to read data from myData.json file
fun loadJsonFromAssets(context: Context, fileName: String): String? {
    return try {
        context.assets.open(fileName).use { inputStream ->
            InputStreamReader(inputStream).use { reader ->
                reader.readText()
            }
        }
    } catch (ex: Exception) {
        ex.printStackTrace()
        null
    }
}

//Parse Json Data to string
fun parseJson(json: String): List<DetailData> {
    val gson = Gson()
    val listType = object : TypeToken<List<DetailData>>() {}.type
    return gson.fromJson(json, listType)
}