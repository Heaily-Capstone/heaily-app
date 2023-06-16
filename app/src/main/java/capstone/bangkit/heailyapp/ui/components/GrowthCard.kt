package capstone.bangkit.heailyapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import capstone.bangkit.heailyapp.data.model.GrowthDataItem

@Composable
fun GrowthCard(
    growthData: GrowthDataItem,
    modifier: Modifier = Modifier
){
    Card(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
    ){
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),


            ) {
                Column(){
                    Text(
                        text="Measurement Date",
                        style=MaterialTheme.typography.h6
                    )
                    Text(
                        text = growthData.measurementDate,
                        style = MaterialTheme.typography.subtitle1
                    )
                }
                Column(

                ){
                    Text(
                        text="Weight",
                        style = MaterialTheme.typography.h6
                    )
                    Text(
                        text = growthData.weight.toString() + "kg",
                        style = MaterialTheme.typography.subtitle1
                    )
                }
                Column(

                ){
                    Text(
                        text="Height",
                        style = MaterialTheme.typography.h6
                    )
                    Text(
                        text = growthData.height.toString() + "cm",
                        style = MaterialTheme.typography.subtitle1

                    )
                }
                Column(

                ){
                    Text(
                        text="Status",
                        style = MaterialTheme.typography.h6
                    )
                    Text(
                        text = growthData.status,
                        style = MaterialTheme.typography.subtitle1
                    )
                }
            }
        }
    }
}