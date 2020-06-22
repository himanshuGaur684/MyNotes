package gaur.himanshu.mynotes.room

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(version = 1,entities = [MyNote::class])
abstract class MyNoteDatabase :RoomDatabase(){

    companion object{
        fun get(application: Application):MyNoteDatabase{
            return  Room.databaseBuilder(application,MyNoteDatabase::class.java,"MyNote").build()
        }
    }

    abstract fun getMyNoteDao():MyNoteDao
}