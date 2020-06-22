package gaur.himanshu.mynotes.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import gaur.himanshu.mynotes.repo.Repo
import gaur.himanshu.mynotes.room.MyNote

class MyViewModel(application: Application):AndroidViewModel(application) {

    var list:LiveData<List<MyNote>>
    val repo= Repo(application)

    init {
        list=repo.list
    }

    fun insert(myNote: MyNote){
        repo.insert(myNote)
    }
    fun update(myNote: MyNote){
        repo.update(myNote)
    }
    fun delete(myNote: MyNote){
        repo.delete(myNote)
    }
    fun getAllNotes():LiveData<List<MyNote>>{
        list=repo.getAllMyNotes()
        return list
    }
}