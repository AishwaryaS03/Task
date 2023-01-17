package com.example.task2

import android.content.Intent
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment


class MainActivity : AppCompatActivity() {
    val KEY_NAME = "name"
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btnsignup = findViewById<Button>(R.id.signup)
        val personName = findViewById<EditText>(R.id.etName)

        val password = findViewById<EditText>(R.id.etPassword)
        val checkBox = findViewById<CheckBox>(R.id.checkBox)
        password.transformationMethod = PasswordTransformationMethod.getInstance()

        val sharedPreferences = getSharedPreferences("LoginPrefs", MODE_PRIVATE);
        val editor = sharedPreferences.edit();
        val name = sharedPreferences.getString(KEY_NAME, "")
        val passwords = sharedPreferences.getString("passowrd", "")
        password.setText(passwords)
        personName.setText(name)

        btnsignup.setOnClickListener {

            if (checkBox.isChecked) {
                editor.putString(KEY_NAME, personName.getText().toString());
                editor.putString("passowrd", password.getText().toString());
                editor.commit();
            } else {
                editor.putString("email", "");
                editor.putString("name", "");
                editor.putString("passowrd", "");
                editor.commit();
            }

            val mFragment = loginpage()
            val mBundle = Bundle()
            mBundle.putString(KEY_NAME , personName.text.toString())
            mFragment.arguments = mBundle
            supportFragmentManager.beginTransaction().replace(R.id.frameLayout, mFragment)
                .commit()
            personName.setVisibility(View.INVISIBLE)
            password.setVisibility(View.INVISIBLE)
            btnsignup.setVisibility(View.INVISIBLE)
            checkBox.setVisibility(View.INVISIBLE)
            val name = personName.text.toString()




        }
        Log.d("Aishwarya","== $personName")
        if(sharedPreferences.getString("name" ," ")?.equals(personName)== true){
            Toast.makeText(this,"Already Exists",Toast.LENGTH_SHORT).show();
        }


    }
}