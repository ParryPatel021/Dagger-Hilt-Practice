package com.parthpatel.daggerhiltpractice.activity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.parthpatel.daggerhiltpractice.R
import com.parthpatel.daggerhiltpractice.api.RetrofitService
import com.parthpatel.daggerhiltpractice.databinding.ActivityMainBinding
import com.parthpatel.daggerhiltpractice.model.UserModel
import com.parthpatel.daggerhiltpractice.view_model.TestViewModel
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    @Named("StringTwo")
    lateinit var testString: String

    @Inject
    @Named("glideCover")
    lateinit var glideCover: RequestManager

    @Inject
    @Named("glidePerson")
    lateinit var glidePerson: RequestManager

    @Inject
    lateinit var retrofitService: RetrofitService

    private lateinit var mainBinding: ActivityMainBinding

    private val viewModel: TestViewModel by viewModels()

    /**
     * Injection testing
     * //Log.e("MainActivity", "Injected String is:  $testString")
    //viewModel
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        loadImages()
        fetchUserData()
    }

    private fun fetchUserData() {
        val userModel = retrofitService.getUserById(1)
        userModel.enqueue(object : Callback<UserModel> {
            override fun onResponse(call: Call<UserModel>, response: Response<UserModel>) {
                response.body().let {
                    mainBinding.tvName.text = "Name: ${it?.name}"
                    mainBinding.tvUsername.text = "Username: ${it?.username}"
                    mainBinding.tvEmail.text = "Email: ${it?.email}"
                    mainBinding.tvWebsite.text = "Website: ${it?.website}"
                }
            }

            override fun onFailure(call: Call<UserModel>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_SHORT).show()
            }

        })

    }

    private fun loadImages() {
        //https://cdn.icon-icons.com/icons2/2643/PNG/512/male_boy_person_people_avatar_icon_159358.png
        glidePerson
            .applyDefaultRequestOptions(
                RequestOptions()
                    .placeholder(R.drawable.profile_placeholder)
                    .error(R.drawable.profile_placeholder)
            )
            .load("https://cdn.icon-icons.com/icons2/2643/PNG/512/male_boy_person_people_avatar_icon_159358.png")
            .into(mainBinding.imgPerson)

        //https://mammothtech.io/wp-content/uploads/2018/02/header-bg.png
        glideCover
            .applyDefaultRequestOptions(
                RequestOptions()
                    .placeholder(R.drawable.header_small)
                    .error(R.drawable.header_small)
            )
            .load("https://mammothtech.io/wp-content/uploads/2018/02/header-bg.png")
            .into(mainBinding.imgCover)
    }
}