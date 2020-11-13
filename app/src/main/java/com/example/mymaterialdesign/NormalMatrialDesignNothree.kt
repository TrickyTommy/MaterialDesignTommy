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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
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
        setContentView(binding.root)

        binding.rvProduct.apply {
            this.layoutManager =  StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
            this.adapter = adapter
        }

        ProductClient.service.getAllProduct().enqueue(object : Callback<List<ProductModel>> {
            override fun onResponse(
                call: Call<List<ProductModel>>,
                response: Response<List<ProductModel>>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        it.forEach { x -> println(x.toString()) }
                        val data = it as MutableList<ProductModel>
                        adapter.setData(data) }
                    Toast.makeText(this@NormalMatrialDesignNothree, "berhasil", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    Toast.makeText(this@NormalMatrialDesignNothree, "gagal rekl", Toast.LENGTH_SHORT)
                        .show()
                }
            }

            override fun onFailure(call: Call<List<ProductModel>>, t: Throwable) {
                t.printStackTrace()

                Toast.makeText(this@NormalMatrialDesignNothree, t.message, Toast.LENGTH_SHORT).show()
            }
        })

}
}