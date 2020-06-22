package gaur.himanshu.mynotes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import gaur.himanshu.mynotes.adapter.MyAdapter
import gaur.himanshu.mynotes.viewmodel.MyViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var myAdapter:MyAdapter
    lateinit var myViewModel: MyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myViewModel=ViewModelProvider(this)[MyViewModel::class.java]

        myAdapter= MyAdapter()

        add_note.setOnClickListener {
            startActivity(Intent(this,DetailActivity::class.java))
        }

        val data=myViewModel.getAllNotes()
        data.observe(this, Observer {
            myAdapter.setContentList(it)
            myAdapter.notifyDataSetChanged()
            recycler.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
            recycler.adapter=myAdapter
        })


    }

    override fun onResume() {
        myViewModel.getAllNotes().value?.let { myAdapter.setContentList(it) }
        myAdapter.notifyDataSetChanged()

        super.onResume()
    }


}