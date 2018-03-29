package eu.afse.daggermixedproject

import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Retrofit
import javax.inject.Inject

/**
 * Created by antonis on 3/29/18.
 */

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    @Inject
    lateinit var retrofit: Retrofit

    @Inject
    lateinit var javaInfo: JavaInfo

    @Inject
    lateinit var kotlinInfo: KotlinInfo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MyApp.getMyComponent(this).inject(this)

        textField.text = kotlinInfo.info + " " + javaInfo.info

        Log.d(getString(R.string.app_name), sharedPreferences.toString())

        retrofit.baseUrl()
    }
}
