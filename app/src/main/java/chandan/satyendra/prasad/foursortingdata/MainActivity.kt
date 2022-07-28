package chandan.satyendra.prasad.foursortingdata

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences
    var ageFromPreferences: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView = findViewById<TextView>(R.id.textView)
        val editage = findViewById<EditText>(R.id.editTextTextPersonName)
        val savebtn = findViewById<Button>(R.id.button)
        val deletebtn = findViewById<Button>(R.id.button2)

        //SharedPrefences Initialize
        sharedPreferences = this.getSharedPreferences(
            "chandan.satyendra.prasad.foursortingdata",
            Context.MODE_PRIVATE
        )
        //var age = 30
        ageFromPreferences = sharedPreferences.getInt("age", -1)
        if (ageFromPreferences == -1) {
            textView.text = "Your Age: "
        } else {
            textView.text = "Your Age: $ageFromPreferences"
        }

        savebtn.setOnClickListener() {
            val myAge = editage.text.toString().toIntOrNull()

            if (myAge != null) {
                textView.text = "Your Age: " + myAge
                sharedPreferences.edit().putInt("age", myAge).apply()
            }
        }
        deletebtn.setOnClickListener() {
            ageFromPreferences = sharedPreferences.getInt("age",-1)

            if (ageFromPreferences != -1) {
                sharedPreferences.edit().remove("age").apply()
                textView.text = "Your Age: "
            }
        }
    }
}