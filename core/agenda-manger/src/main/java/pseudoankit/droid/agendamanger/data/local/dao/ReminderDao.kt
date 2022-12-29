package pseudoankit.droid.agendamanger.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import pseudoankit.droid.agendamanger.data.local.entity.ReminderEntity

@Dao
interface ReminderDao {

    @Insert
    fun insert(item: ReminderEntity)
}