package uz.turgunboyevjurabek.viewmodel_livedata.Network

import retrofit2.Call
import retrofit2.http.GET
import uz.turgunboyevjurabek.viewmodel_livedata.Madels.Valyuta

interface ApiSevis {

    @GET("json")
    fun getAllItem():Call<ArrayList<Valyuta>>

}