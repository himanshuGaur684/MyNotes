package gaur.himanshu.mynotes.repo

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.MutableLiveData
import gaur.himanshu.mynotes.room.MyNote
import gaur.himanshu.mynotes.room.MyNoteDatabase
import gaur.himanshu.mynotes.room.MyNoteDatabase.Companion.get

class Repo(val application: Application) {

    val list=MutableLiveData<List<MyNote>>()

    fun insert(myNote: MyNote){
        Insert(application,myNote).execute()
    }

    fun update(myNote: MyNote){
        Update(application,myNote).execute()
    }

    fun delete(myNote: MyNote){
        Delete(application,myNote).execute()
    }

    fun getAllMyNotes():MutableLiveData<List<MyNote>>{
        list.value=GetMyAllNotes(application).execute().get()
        return list
    }

    private class Insert(val application: Application,val myNote: MyNote):AsyncTask<Void,Void,Void>(){
        override fun doInBackground(vararg params: Void?): Void? {

            get(application).getMyNoteDao().insert(myNote)
            return null
        }

    }
    private class Update(val application: Application,val myNote: MyNote):AsyncTask<Void,Void,Void>(){
        override fun doInBackground(vararg params: Void?): Void? {

            get(application).getMyNoteDao().update(myNote)
            return null
        }

    }
    private class Delete(val application: Application,val myNote: MyNote):AsyncTask<Void,Void,Void>(){
        override fun doInBackground(vararg params: Void?): Void? {

            get(application).getMyNoteDao().delete(myNote)
            return null
        }

    }
    private class GetMyAllNotes(val application: Application):AsyncTask<Void,Void,List<MyNote>>(){
        override fun doInBackground(vararg params: Void?): List<MyNote>? {

        return   get(application).getMyNoteDao().getAllMyNotes()

        }

    }

}