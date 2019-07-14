package com.stuffshuf.okhttp_with_gson

import android.content.ClipData
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.GridLayout
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnData.setOnClickListener {

      val client=OkHttpClient()

            val request=Request.Builder()
                .url("https://api.github.com/search/users?q=Pulkit%20Aggarwal")
                .build()
                val response=client.newCall(request).enqueue(object :Callback{
                    override fun onFailure(call: Call, e: IOException) {

                    }

                    override fun onResponse(call: Call, response: Response) {
                        if (response.isSuccessful) {
                            val data =

                                Gson().fromJson(response.body?.string(), Example::class.java)
                            Log.d("HH", "data $data")


                            runOnUiThread {


                                tvResult.layoutManager = GridLayoutManager(
                                    this@MainActivity,
                                    2,
                                    GridLayoutManager.VERTICAL,
                                    false)

                                tvResult.adapter = UsersAdapter(data.items)


                            }
                        }


                        else {
                          runOnUiThread{
                              Toast.makeText(
                                  this@MainActivity,
                                  "" + response.code,
                                  Toast.LENGTH_LONG
                              ).show()
                          }


                      }
                    }

                })

        }
    }
}