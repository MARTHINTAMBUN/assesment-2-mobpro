package org.d3if3086.tabunganku.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://raw.githubusercontent.com/"+
        "MARTHINTAMBUN/assesment-2-mobpro/master/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface TabunganApiService {
    @GET("copyright.json")
    suspend fun getCopyright(): String
}
object TabunganApi {
    val service: TabunganApiService by lazy {
        retrofit.create(TabunganApiService::class.java)
    }
}

enum class ApiStatus { LOADING, SUCCESS, FAILED }
