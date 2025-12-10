package es.mobiledev.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import es.mobiledev.data.local.article.dao.ArticleDao
import es.mobiledev.data.local.article.dbo.ArticleDbo

@Database(
    entities = [
        ArticleDbo::class,
    ],
    version = DATABASE_VERSION,
)
abstract class AppRoomDatabase : RoomDatabase() {
    abstract fun articleDao(): ArticleDao

    companion object {
        fun buildDatabase(context: Context): AppRoomDatabase =
            Room
                .databaseBuilder(
                    context = context.applicationContext,
                    klass = AppRoomDatabase::class.java,
                    name = DATABASE_NAME,
                ).build()
    }
}
