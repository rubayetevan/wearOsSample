package live.ebox.myapplication.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Test")
data class TestTable(
    @ColumnInfo(name = "employeeAge")
    var employeeAge: String? = "",
    @ColumnInfo(name = "employeeName")
    var employeeName: String? = "",
    @ColumnInfo(name = "employeeSalary")
    var employeeSalary: String? = "",
    @ColumnInfo(name = "profileImage")
    var profileImage: String? = "",
    @ColumnInfo(name = "employeeRating")
    var employeeRating: Int? = 0
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}