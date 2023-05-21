package org.d3if3086.tabunganku.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [TabunganEntity::class], version = 1, exportSchema = false)
abstract class TabunganDb  : RoomDatabase()  {
    abstract val dao: TabunganDao
    companion object {
        @Volatile
        private var INSTANCE: TabunganDb? = null
        fun getInstance(context: Context): TabunganDb {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        TabunganDb::class.java,
                        "tabungan.db"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

}