package gaur.himanshu.mynotes.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import gaur.himanshu.mynotes.R
import gaur.himanshu.mynotes.room.MyNote
import kotlinx.android.synthetic.main.activity_detail.view.*

class MyAdapter():RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    lateinit var list:List<MyNote>

    fun setContentList(list:List<MyNote>){
        this.list=list
        notifyDataSetChanged()
    }

    inner class MyViewHolder(view: View):RecyclerView.ViewHolder(view){
        var title=itemView.findViewById<TextView>(R.id.textview_title)
        var desc=itemView.findViewById<TextView>(R.id.textview_desc)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
       holder.title.text=list[position].title
        holder.desc.text=list[position].desc
    }
}