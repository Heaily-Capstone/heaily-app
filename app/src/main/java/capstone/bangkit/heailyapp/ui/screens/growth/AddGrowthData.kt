package capstone.bangkit.heailyapp.ui.screens.growth

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import capstone.bangkit.heailyapp.data.Result
import capstone.bangkit.heailyapp.data.model.ChildrenItem
import capstone.bangkit.heailyapp.ui.ViewModelFactory
import capstone.bangkit.heailyapp.ui.components.Input
import capstone.bangkit.heailyapp.ui.components.PrimaryButton
import capstone.bangkit.heailyapp.ui.navigation.Screen
import capstone.bangkit.heailyapp.ui.screens.home.UserViewModel
import capstone.bangkit.heailyapp.ui.theme.HeailyAppTheme

@Composable
fun AddGrowthData(
    childId: Int,
    modifier: Modifier,
    viewModel: UserViewModel,
    navigateBack: () -> Unit,
){
    viewModel.uiStateChild.collectAsState(initial = Result.Loading).value.let {
        when(it){
            is Result.Loading ->{
                Log.e("Loading", "loading home")
                viewModel.getChild(childId)
            }
            is Result.Success ->{
                Log.e("Success", it.toString())
                AddGrowthDataContent(
                    children = it.data,
                    viewModel = viewModel
                ) {
                }
            }

            is Result.Error -> {
                Log.e("Error", "error home")
            }
        }
    }
}

@Composable
fun AddGrowthDataContent(
    children: ChildrenItem,
    modifier: Modifier = Modifier,
    viewModel: UserViewModel,
    onBackClick: () -> Unit
){
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier
            .padding(16.dp)
    ){
        val weight = remember { mutableStateOf("") }
        val height = remember { mutableStateOf("") }
        val measurementDate = remember { mutableStateOf("") }

        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back",
            modifier = Modifier
                .padding(16.dp)
                .clickable { onBackClick() }
        )

        Text(
            text="Tambah Data Pertumbuhan",
            style=MaterialTheme.typography.h3
        )
        Spacer(Modifier.padding(8.dp))
        Input(
            icon = null,
            placeholder = "Masukkan Berat",
            label = "Berat(kg)",
            value = weight.value,
            onValueChange = { weight.value = it }
        )
        Input(
            icon = null,
            placeholder = "Masukkan Berat",
            label = "Berat(kg)",
            value = height.value,
            onValueChange = { weight.value = it }
        )
        Input(
            icon = null,
            placeholder = "Masukkan Berat",
            label = "Berat(kg)",
            value = measurementDate.value,
            onValueChange = { measurementDate.value = it }
        )

        PrimaryButton(
            text = "Tambah Data",
            onClick = {
//                viewModel.insertGrowthData(
//                    weight = weight.value,
//                    height = height.value,
//                    measurementDate = measurementDate.value,
//                    childrenItem = children
//                )
            }
        )
    }
}

@Composable
@Preview(showBackground = true)
fun AddGrowthDataPreview(){
    HeailyAppTheme() {
        AddGrowthData(
            childId = 1,
            modifier = Modifier,
            viewModel = viewModel(
                factory = ViewModelFactory.getInstance(LocalContext.current)
            )
        ) {
        }
    }
}