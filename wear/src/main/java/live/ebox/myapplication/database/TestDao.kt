package live.ebox.myapplication.database

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface TestDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEmployee(employee: TestTable)

    @Query("SELECT * FROM Test")
    fun getAllEmployees(): LiveData<List<TestTable>>

    @Query("SELECT * FROM Test WHERE employeeName LIKE '%' || :name || '%'")
    fun getEmployeesByName(name: String): LiveData<List<TestTable>>

    @Query("SELECT * FROM Test WHERE employeeName LIKE '%' || :name || '%' ORDER BY employeeRating DESC")
    fun getEmployeesByNameSortByRating(name: String): LiveData<List<TestTable>>

    @Query("SELECT * FROM Test WHERE id =:id")
    fun getEmployeesByID(id: Int): LiveData<List<TestTable>>

    @Update
    suspend fun updateEmployee(employee: TestTable)

    @Delete
    suspend fun deleteEmployee(employee: TestTable)

}
