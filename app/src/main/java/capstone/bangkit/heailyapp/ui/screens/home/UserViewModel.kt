package capstone.bangkit.heailyapp.ui.screens.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import capstone.bangkit.heailyapp.data.Result
import capstone.bangkit.heailyapp.data.local.UserRepository
import capstone.bangkit.heailyapp.data.model.ChildrenItem
import capstone.bangkit.heailyapp.data.model.GrowthDataItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class UserViewModel(
    private val repository: UserRepository,
): ViewModel() {
    private val _uiStateChild: MutableStateFlow<Result<ChildrenItem>> = MutableStateFlow(Result.Loading)
    val uiStateChild: StateFlow<Result<ChildrenItem>>
        get() = _uiStateChild

    private val _uiStateGrowth: MutableStateFlow<Result<List<GrowthDataItem>>> = MutableStateFlow(Result.Loading)
    val uiStateGrowth: StateFlow<Result<List<GrowthDataItem>>>
        get() = _uiStateGrowth

    private val _uiStateForm: MutableStateFlow<Result<GrowthDataItem>> = MutableStateFlow(Result.Loading)
    val uiStateForm: StateFlow<Result<GrowthDataItem>>
        get() = _uiStateForm

    init {
        insertAllData()
    }

    private fun insertAllData() = viewModelScope.launch {
        repository.insertAllData()
    }

    fun getChild(childId: Int) {
        viewModelScope.launch {
            repository.getChild(childId)
                .catch {
                    Log.e("error", "view model home")
                    _uiStateChild.value = Result.Error(it.message.toString())
                }
                .collect() {
                    _uiStateChild.value = it
                    Log.e("succes", it.toString())
                }
        }
    }

    fun getGrowthData(childId: Int) {
        viewModelScope.launch {
            repository.getGrowthData(childId)
                .catch {
                    Log.e("error", "view model home")
                    _uiStateGrowth.value = Result.Error(it.message.toString())
                }
                .collect() {
                    _uiStateGrowth.value = it
                    Log.e("succes", it.toString())
                }
        }
    }

//    fun insertGrowthData(childrenItem: ChildrenItem, weight: String, height: String, measurementDate: String){
//        viewModelScope.launch{
//            repository.insertGrowthData(
//                childrenItem = childrenItem,
//                weight = weight.toInt(),
//                height = height.toInt(),
//                measurementDate =  measurementDate
//            )
//                .catch {
//                    Log.e("error", "view model home")
//                    _uiStateForm.value = Result.Error(it.message.toString())
//                }
//                .collect(){
//                    _uiStateForm.value = it
//                    Log.e("success", it.toString())
//                }
//        }
//    }
}