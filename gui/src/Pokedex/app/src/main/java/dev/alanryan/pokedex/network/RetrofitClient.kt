//package dev.alanryan.pokedex.network
//
//import dev.alanryan.pokedex.utils.Constants
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//
//object RetrofitClient {
//    val retrofit: APIService by lazy {
//        Retrofit
//            .Builder()
//            .baseUrl(Constants.BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//            .create(APIService::class.java)
//    }
//}