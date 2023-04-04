package com.example.intentsevensolution

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.intentsevensolution.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding:ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1단계 엑티비티 전환
        // 2단계 데이터 받기 id, pwd
        if(intent.hasExtra("no")){
            when (intent.getIntExtra("no",0)) {
                // 2단계 데이터 보내기
                0 -> {
                    if(intent.hasExtra("id").equals("") && intent.hasExtra("pwd").equals("") ){
                        Toast.makeText(this,"id와 pwd가 없습니다.",Toast.LENGTH_SHORT).show()
                        finish()
                    }else{
                        val id = intent.getStringExtra("id")
                        val pwd = intent.getStringExtra("pwd")
                        Toast.makeText(this,"${id},${pwd}",Toast.LENGTH_SHORT).show()
                    }
                }
                // 3단계 데이터객체로 보내기(serializable)
                3 -> {
                    val loginData = intent.getSerializableExtra("loginData") as LoginData
                    Toast.makeText(this,"${loginData.id},${loginData.pwd}",Toast.LENGTH_SHORT).show()
                }
                4 -> {
                    val loginDataParcel = intent.getParcelableExtra<LoginDataParcel>("loginDataParcel")
                    Toast.makeText(this,"${loginDataParcel?.id},${loginDataParcel?.pwd}",Toast.LENGTH_SHORT).show()
                }
                5 -> {
                    val loginDataParcelList = intent.getParcelableArrayListExtra<LoginDataParcel>("loginDataParcelList")
                    Toast.makeText(this,"${loginDataParcelList?.get(3)?.id},${loginDataParcelList?.get(3)?.pwd}",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }//end of onCreate
}