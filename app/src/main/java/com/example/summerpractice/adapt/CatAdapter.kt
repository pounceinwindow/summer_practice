package com.example.summerpractice.adapt
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.summerpractice.databinding.ItemCatBinding
import com.example.summerpractice.model.CatModel
import com.example.summerpractice.util.CatGenerator

class CatAdapter(
    private val cats: List<CatModel>,
    private val onItemClicked: (CatModel) -> Unit,
    private val onImageClicked: (CatModel) -> Unit
) : RecyclerView.Adapter<CatAdapter.CatViewHolder>() {

    inner class CatViewHolder(val binding: ItemCatBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(cat: CatModel) {
            binding.titleText.text = cat.title
            binding.descText.text = cat.description
            binding.idshnik.text = cat.id.toString()
            binding.catImage.setImageResource(cat.imageResId)

            binding.root.setOnClickListener { onItemClicked(cat) }
            binding.catImage.setOnClickListener {
                cat.imageResId = CatGenerator.getRandomImage()
                notifyItemChanged(adapterPosition)
                onImageClicked(cat)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCatBinding.inflate(inflater, parent, false)
        return CatViewHolder(binding)
    }

    override fun getItemCount(): Int = cats.size

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        holder.bind(cats[position])
    }
}
