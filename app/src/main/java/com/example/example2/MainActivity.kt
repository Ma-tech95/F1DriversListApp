package com.example.example2

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.example2.databinding.ActivityMainBinding
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONException
import java.io.IOException
import java.nio.charset.Charset

lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* Binds ActivityMain Layout and inflate which creates an instance of the binding class
        for the activity to use.
         */

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        backgroundAnimation()


        // Instance of users list using the data model class.
        try {
            val jsonString = getJSONFromAssets()!!
            val drivers = Gson().fromJson(jsonString, Drivers::class.java)

            // Set the LayoutManager that this RecyclerView will use.
            rvUsersList.layoutManager = LinearLayoutManager(this)

            // Adapter class is initialized and list is passed in the param.
            val itemAdapter = DriverAdapter(this, drivers.drivers)

            // adapter instance is set to the recyclerview to inflate the items.
            rvUsersList.adapter = itemAdapter
        } catch (e: JSONException) {

            //exception
            e.printStackTrace()
        }
    }


     //Method to load the JSON from the Assets file and return the object

    private fun getJSONFromAssets(): String? {

        var json: String? = null
        val charset: Charset = Charsets.UTF_8
        try {
            val myDriversJSONFile = assets.open("Drivers.json")
            val size = myDriversJSONFile.available()
            val buffer = ByteArray(size)
            myDriversJSONFile.read(buffer)
            myDriversJSONFile.close()
            json = String(buffer, charset)
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
        return json
    }

    //Method to add background animation from drawable using binding
    private fun backgroundAnimation(){

        val animationDrawable: AnimationDrawable = binding.back.background as AnimationDrawable

        animationDrawable.apply {
            setEnterFadeDuration(1000)
            setExitFadeDuration(3000)
            start()
        }
    }
}