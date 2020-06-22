package gaur.himanshu.mynotes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import gaur.himanshu.mynotes.room.MyNote
import gaur.himanshu.mynotes.viewmodel.MyViewModel
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    lateinit var myViewModel: MyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        myViewModel=ViewModelProvider(this)[MyViewModel::class.java]

        save.setOnClickListener {
            if (desc.text.isEmpty() || title_editText.text.isEmpty()) {
               return@setOnClickListener
            } else {


                val myNote =
                    MyNote(title_editText.text.trim().toString(), desc.text.trim().toString())
                myViewModel.insert(myNote)
                finish()
            }
        }

    }
}