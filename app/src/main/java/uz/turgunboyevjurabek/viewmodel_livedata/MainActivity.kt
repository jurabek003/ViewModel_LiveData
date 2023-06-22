package uz.turgunboyevjurabek.viewmodel_livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import uz.turgunboyevjurabek.viewmodel_livedata.ViewMadel.ViewModel
import uz.turgunboyevjurabek.viewmodel_livedata.adapter.RvAdapter
import uz.turgunboyevjurabek.viewmodel_livedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var viewModel: ViewModel
    private lateinit var rvAdapter: RvAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModel= ViewModelProvider(this).get(ViewModel::class.java)
        viewModel.getAllValyuta().observe(this){
            binding.gifView.visibility= View.GONE
            rvAdapter=RvAdapter(it)
            Log.e("tagg",it.toString())
            binding.rvAdapter.adapter=rvAdapter
        }
    }
}