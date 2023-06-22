package uz.turgunboyevjurabek.viewmodel_livedata.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import uz.turgunboyevjurabek.viewmodel_livedata.Madels.Valyuta
import uz.turgunboyevjurabek.viewmodel_livedata.databinding.ItemRvBinding

class RvAdapter(val list: ArrayList<Valyuta>):RecyclerView.Adapter<RvAdapter.Vh>() {
    inner class  Vh(val itemRvBinding: ItemRvBinding):ViewHolder(itemRvBinding.root){
        fun onBind(valyuta: Valyuta){
            itemRvBinding.itemCcy.text=valyuta.ccy.toString()
            itemRvBinding.itemCcyNmEN.text=valyuta.ccyNmEN
            itemRvBinding.itemId.text=valyuta.id.toString()
            itemRvBinding.itemCcyNmRU.text=valyuta.ccyNmRU
            itemRvBinding.itemCcyNmUZ.text=valyuta.ccyNmUZ
            itemRvBinding.itemCcyNmUZC.text=valyuta.ccyNmUZC
            itemRvBinding.itemCode.text=valyuta.code
            itemRvBinding.itemDate.text=valyuta.date
            itemRvBinding.itemDiff.text=valyuta.diff
            itemRvBinding.itemNominal.text=valyuta.nominal
            itemRvBinding.itemRate.text=valyuta.rate
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }
}
