package capstone.bangkit.heailyapp.ui.screens.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import capstone.bangkit.heailyapp.R
import capstone.bangkit.heailyapp.ui.components.PrimaryButton
import capstone.bangkit.heailyapp.ui.components.SecondaryButton

@Composable
fun Profile(){
    val configuration = LocalConfiguration.current
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(16.dp)
            .height(configuration.screenHeightDp.dp)
    ){
        Image(
            painter = painterResource(id = R.drawable.baseline_account_circle_24),
            contentDescription = "",
            modifier = Modifier
                .size(80.dp)
        )
        Spacer(Modifier.height(12.dp))
        Text(
            text = "userEmail@gmail.com",
            style = MaterialTheme.typography.body1
        )
        Spacer(Modifier.height(12.dp))
        SecondaryButton(
            text = "logout",
            onClick = {},
        )
    }

}