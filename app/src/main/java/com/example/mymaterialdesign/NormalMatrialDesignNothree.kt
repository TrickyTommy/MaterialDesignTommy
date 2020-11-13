package com.example.mymaterialdesign

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mymaterialdesign.model.ProductModel

import androidx.appcompat.app.ActionBarDrawerToggle
//import kotlinx.android.synthetic.main.activity_main.*
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.widget.Toast
import androidx.drawerlayout.widget.DrawerLayout
import com.example.mymaterialdesign.databinding.ActivityNormalMatrialDesignNothreeBinding
import com.example.mymaterialdesign.adapter.AdapterProduct
import com.example.mymaterialdesign.clients.ProductClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class NormalMatrialDesignNothree : AppCompatActivity() {

    private val binding by lazy { ActivityNormalMatrialDesignNothreeBinding.inflate(layoutInflater) }
    private val adapter by lazy { AdapterProduct(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_normal_matrial_design_nothree)

        binding.rvProduct.adapter = adapter

        ProductClient.apiService.getAllProduct().enqueue(object : Callback<MutableList<ProductModel>> {
            override fun onResponse(
                call: Call<MutableList<ProductModel>>,
                response: Response<MutableList<ProductModel>>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let { adapter.setData(it) }
                } else {
                    Toast.makeText(this@NormalMatrialDesignNothree, response.message(), Toast.LENGTH_SHORT)
                        .show()
                }
            }

            override fun onFailure(call: Call<MutableList<ProductModel>>, t: Throwable) {
                t.printStackTrace()

                Toast.makeText(this@NormalMatrialDesignNothree, t.message, Toast.LENGTH_SHORT).show()
            }
        })

}
}