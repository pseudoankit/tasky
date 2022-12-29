package pseudoankit.droid.dbmanager

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import pseudoankit.droid.agendamanger.data.local.dao.ReminderDao
import pseudoankit.droid.agendamanger.data.local.entity.ReminderEntity
import pseudoankit.droid.dbmanager.typeconvertor.DateTimeTypeConvertor

@Database(
    entities = [ReminderEntity::class],
    version = 1
)
@TypeConverters(
    DateTimeTypeConvertor::class
)
abstract class TaskyDataBase : RoomDatabase() {

    abstract val reminderDao: ReminderDao

    companion object {

        @Volatile
        private var instance: TaskyDataBase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                TaskyDataBase::class.java,
                "tasky_manager"
            ).build()
    }
}