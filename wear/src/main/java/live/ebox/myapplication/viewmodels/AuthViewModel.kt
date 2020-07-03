package live.ebox.myapplication.viewmodels
import android.app.Application
import android.util.Log
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import live.ebox.myapplication.database.DemoDatabase
import live.ebox.myapplication.database.TestTable
import live.ebox.myapplication.listeners.AuthListeners

val TAG: String? = AuthViewModel::class.simpleName

class AuthViewModel(application: Application) : AndroidViewModel(application) {

    var username: String? = null
    var password: String? = null
    var authListeners: AuthListeners? = null

    private val db: DemoDatabase = DemoDatabase.getInstance(application.applicationContext)

    fun submitButtonOnclick(view: View) {

        authListeners?.onStarted()
        Log.d(TAG, "onClick pressed : $username")
        val tempModel = TestTable(
            employeeSalary = "20000",
            employeeRating = 0,
            employeeName = username,
            employeeAge = "23",
            profileImage = "ted"
        )

        viewModelScope.launch {
            db.testDAO().insertEmployee(tempModel)
            authListeners?.onSuccess()
        }

    }

    fun getData(): LiveData<List<TestTable>> = db.testDAO().getAllEmployees()


}