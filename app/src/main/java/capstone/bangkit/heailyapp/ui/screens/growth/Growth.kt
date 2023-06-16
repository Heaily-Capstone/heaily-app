package capstone.bangkit.heailyapp.ui.screens.growth

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import capstone.bangkit.heailyapp.R
import capstone.bangkit.heailyapp.data.Result
import capstone.bangkit.heailyapp.data.model.ChildrenItem
import capstone.bangkit.heailyapp.data.model.GrowthDataItem
import capstone.bangkit.heailyapp.ui.components.GrowthCard
import capstone.bangkit.heailyapp.ui.components.PrimaryButton
import capstone.bangkit.heailyapp.ui.screens.home.HomeContent
import capstone.bangkit.heailyapp.ui.screens.home.UserViewModel
import capstone.bangkit.heailyapp.ui.theme.Poppins
import java.util.*

@Composable
fun Growth(modifier: Modifier,
           viewModel: UserViewModel,
           navigateToAddForm: (Int) -> Unit,
){
    var child: ChildrenItem? = null
    viewModel.uiStateChild.collectAsState(initial = Result.Loading).value.let {
        when(it){
            is Result.Loading ->{
                Log.e("Loading", "loading home")
                viewModel.getChild(1)
            }
            is Result.Success ->{
                Log.e("Success", it.toString())
                child = it.data
            }

            is Result.Error -> {
                Log.e("Error", "error home")
            }
        }
    }

    if (child != null){
        viewModel.uiStateGrowth.collectAsState(initial = Result.Loading).value.let {
            when(it){
                is Result.Loading ->{
                    Log.e("Loading", "loading home")
                    viewModel.getGrowthData(child!!.childrenId!!)
                }
                is Result.Success ->{
                    Log.e("Success", it.toString())
                    GrowthContent(
                        modifier = modifier,
                        child= child!!,
                        navigateToAddForm = navigateToAddForm,
                        growthData = it.data
                    )
                }

                is Result.Error -> {
                    Log.e("Error", "error home")
                }
            }
        }
    }
}


@Composable
fun GrowthContent(
    modifier: Modifier,
    child: ChildrenItem,
    growthData: List<GrowthDataItem>,
    navigateToAddForm:(Int) -> Unit,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(24.dp),
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(16.dp, 0.dp)
    ){
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically

        ){
            Image(
                painter = painterResource(id = R.drawable.avatar_boy),
                contentDescription = "",
                modifier = Modifier
                    .padding(0.dp, 16.dp)
                    .size(60.dp)
            )
            Spacer(modifier.width(12.dp))
            Column(
                verticalArrangement = Arrangement.Center,

            ){
                Text(
                    text = child.name,
                    style= TextStyle(
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                )
                Text(
                    text = (Calendar.getInstance().get(Calendar.YEAR) - (child.dob.substring(child.dob.length-4)).toInt()).toString() + " "  + "tahun",
                    style= TextStyle(
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp
                    )
                )
            }
        }

        PrimaryButton(
            text = "Add Data",
            onClick={
                child.childrenId?.let { navigateToAddForm(it) }
            }
        )
        
        for (i in growthData){
            GrowthCard(growthData = i)
        }

        Spacer(Modifier.height(16.dp))


}}