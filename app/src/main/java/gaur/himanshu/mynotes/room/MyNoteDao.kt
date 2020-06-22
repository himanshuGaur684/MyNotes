package gaur.himanshu.mynotes.room

import androidx.room.*

@Dao
interface MyNoteDao {

    @Insert
    fun insert(myNote: MyNote)

    @Update
    fun update(myNote: MyNote)

    @Delete
    fun delete(myNote: MyNote)

    @Query("SELECT * FROM MyNote")
    fun getAllMyNotes(): List<MyNote>
}