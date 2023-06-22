package uz.turgunboyevjurabek.viewmodel_livedata.Network


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClinet {
    const val BASE_URL="https://cbu.uz/uz/arkhiv-kursov-valyut/"
  private  fun getRetrofit(): Retrofit{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    fun getRetrofitServis():ApiSevis{
        return getRetrofit().create(ApiSevis::class.java)
    }


}