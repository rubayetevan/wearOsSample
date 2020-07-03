package live.ebox.myapplication.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


@Database(entities = [TestTable::class], version = 1, exportSchema = false)
@TypeConverters(Converter::class)
abstract class DemoDatabase : RoomDatabase() {

    abstract fun testDAO(): TestDAO

    companion object {
        @Volatile
        private var INSTANCE: DemoDatabase? = null

        fun getInstance(context: Context): DemoDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext, DemoDatabase::class.java, "DemoDB")
                .build()
    }
}