package uz.turgunboyevjurabek.viewmodel_livedata.ViewMadel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import uz.turgunboyevjurabek.viewmodel_livedata.Madels.Valyuta
import uz.turgunboyevjurabek.viewmodel_livedata.Network.ApiClinet
private const val TAG = "MyViewModel"

class ViewModel:ViewModel() {

    private val liveData=MutableLiveData<ArrayList<Valyuta>>()
    init {
        ApiClinet.getRetrofitServis().getAllItem()
            .enqueue(object :Callback<ArrayList<Valyuta>>{
                override fun onResponse(
                    call: Call<ArrayList<Valyuta>>,
                    response: Response<ArrayList<Valyuta>>,
                ){
                    if (response.isSuccessful){
                        liveData.postValue(response.body())
                        Log.d(TAG, "onResponse: ${response.body()}")
                    }
                }
                override fun onFailure(call: Call<ArrayList<Valyuta>>, t: Throwable) {
                    Log.d(TAG, "onFailure: ${t.message}")
                }
            })
    }

    fun getAllValyuta():MutableLiveData<ArrayList<Valyuta>>{
        return liveData
    }

}