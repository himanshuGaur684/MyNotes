package gaur.himanshu.mynotes.room

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
class MyNote(
    val title:String,
    val desc:String
) {
    @PrimaryKey(autoGenerate = true)
    var key:Int=0
}