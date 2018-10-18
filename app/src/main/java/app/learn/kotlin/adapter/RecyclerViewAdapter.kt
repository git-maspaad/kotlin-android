package app.learn.kotlin.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import app.learn.kotlin.R
import app.learn.kotlin.model.Item
import app.learn.kotlin.ui.ItemView
import com.bumptech.glide.Glide
import kotlinx.android.extensions.LayoutContainer
import org.jetbrains.anko.AnkoContext

class RecyclerViewAdapter(
        private val context: Context,
        private val items: List<Item>,
        private val listener: (Item) -> Unit)
    : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(ItemView().createView(AnkoContext.create(context, parent)), null)

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bindItem(items[position], listener)

    class ViewHolder(view: View, override val containerView: View?) : RecyclerView.ViewHolder(view), LayoutContainer {

        val name = itemView.findViewById<TextView>(R.id.name_id)
        val image = itemView.findViewById<ImageView>(R.id.image_id)

        fun bindItem(items : Item, listener: (Item) -> Unit) {
            name.text = items.name
            Glide.with(itemView.context).load(items.image).into(image)

            itemView.setOnClickListener {
                listener(items)
            }

        }
    }

}