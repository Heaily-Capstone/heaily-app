package capstone.bangkit.heailyapp.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import capstone.bangkit.heailyapp.R
import capstone.bangkit.heailyapp.data.model.dummyTarget
import capstone.bangkit.heailyapp.data.model.mealPlansItemDummy
import capstone.bangkit.heailyapp.ui.components.MealBanner
import capstone.bangkit.heailyapp.ui.components.MealColumn
import capstone.bangkit.heailyapp.ui.components.MealSection
import capstone.bangkit.heailyapp.ui.components.TargetCard
import capstone.bangkit.heailyapp.ui.theme.Black
import capstone.bangkit.heailyapp.ui.theme.Poppins
import capstone.bangkit.heailyapp.ui.theme.blue1
import capstone.bangkit.heailyapp.utils.randomMeal

@Composable
fun Home(
    modifier: Modifier
){ Column(
    verticalArrangement = Arrangement.spacedBy(24.dp),
    modifier = Modifier
        .verticalScroll(rememberScrollState())
        .padding(16.dp, 0.dp)
){
    Row(){
        Image(
            painter = painterResource(id = R.drawable.avatar_boy),
            contentDescription = "",
            modifier = Modifier.size(20.dp)
        )

        Spacer(modifier.width(12.dp))
        Column(){

        }
    }
    Row(){

    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(blue1)
            .padding(16.dp, 16.dp)


    ){
        Text(
            text= "Target Hari Ini",
            style = TextStyle(
                fontFamily = Poppins,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
                color = Black
            ),
        )
        Row(){
            TargetCard(
                imageUrl = dummyTarget[0].urlImage,
                title = dummyTarget[0].value,
                value = dummyTarget[0].title,
                modifier = Modifier.weight(1f)
            )
            TargetCard(
                imageUrl = dummyTarget[1].urlImage,
                title = dummyTarget[1].value,
                value = dummyTarget[1].title,
                modifier = Modifier.weight(1f)
            )
        }
        Row(){
            TargetCard(
                imageUrl = dummyTarget[2].urlImage,
                title = dummyTarget[2].value,
                value = dummyTarget[2].title,
                modifier = Modifier.weight(1f)
            )
            TargetCard(
                imageUrl = dummyTarget[3].urlImage,
                title = dummyTarget[3].value,
                value = dummyTarget[3].title,
                modifier = Modifier.weight(1f)
            )
        }
    }
    MealBanner(
        "Bingung menentukan menu makan untuk anak Anda?",
        value = "Kami bantu pilihkan menu makanan terbaik",
        onClick = { }
    )
    MealSection(title = "Rekomendasi Menu") {
        MealColumn(listMeal = randomMeal(result = 8, listMealPlan = mealPlansItemDummy), modifier = Modifier)
    }
}
}

@Composable
@Preview(showBackground = true)
fun HomePreview(){
    Home(
        modifier = Modifier
    )
}