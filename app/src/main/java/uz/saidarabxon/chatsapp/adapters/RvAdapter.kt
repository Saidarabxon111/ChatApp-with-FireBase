package uz.saidarabxon.chatsapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import uz.saidarabxon.chatsapp.databinding.ItemRvBinding
import uz.saidarabxon.chatsapp.models.User

class RvAdapter(var list: ArrayList<User> =ArrayList()) : RecyclerView.Adapter<RvAdapter.Vh>() {

    inner class Vh(var itemRvBinding: ItemRvBinding):RecyclerView.ViewHolder(itemRvBinding.root){
        fun onBind(user: User, position: Int ){

            itemRvBinding.tvName.text =user.displayName
            Picasso.get().load(user.imageLink).into(itemRvBinding.image)


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context) , parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int = list.size

}