package capstone.bangkit.heaily.ui.screen.growth

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import capstone.bangkit.heailyapp.ui.components.Input
import capstone.bangkit.heailyapp.ui.components.PrimaryButton
import capstone.bangkit.heailyapp.ui.components.SectionText
import capstone.bangkit.heailyapp.ui.theme.HeailyAppTheme

@Composable
fun AddChildScreen() {
    AddChildForm()
}

@Composable
fun AddChildForm() {
    val radioOptions = listOf("Laki-laki", "Perempuan")
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back",
            modifier = Modifier
                .padding(16.dp)
                .clickable { }
        )

        Spacer(Modifier.padding(20.dp))

        Text(
            text="Tambah Data Anak",
            style=MaterialTheme.typography.h3
        )

        Input(
            icon = null,
            placeholder = "Masukkan nama anak",
            label = "Nama Anak",
            value = "",
            onValueChange = {},
        )
        // Tanggal lahir pake date picker
        Input(
            icon = null,
            placeholder = "Masukkan tanggal lahir anak",
            label = "Tanggal Lahir",
            value = "",
            onValueChange = {},
        )
        Text(
            text = "Jenis Kelamin",
            fontSize = 12.sp,
            color = Color(0xFF1D1617),
            modifier = Modifier.padding(horizontal = 20.dp)
        )
        Spacer(Modifier.padding(0.dp, 8.dp,  0.dp, 0.dp))
        radioOptions.forEach { text ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
//                    .selectable(
//                        selected = (text == selectedOption),
//                        onClick = {
//                            onOptionSelected(text)
//                        }
//                    )
            ) {
                RadioButton(
                    selected = false,
                    onClick = {}
//                    selected = (text == selectedOption),
//                    onClick = { onOptionSelected(text) }
                )
                Text(
                    text = text,
                    style = MaterialTheme.typography.body2.merge(),
                )
            }
        }


        // Radio Button Jenis Kelamin

        Spacer(Modifier.height(32.dp))
        SectionText(title = "Data Kelahiran")
        Spacer(Modifier.height(12.dp))

        Input(
            icon = null,
            placeholder = "3.5",
            label = "Berat Badan (kg)",
            onValueChange = {},
            value = ""
        )
        Input(
            icon = null,
            placeholder = "47",
            label = "Tinggi Badan (cm)",
            onValueChange = {},
            value = ""
        )
        Input(
            icon = null,
            placeholder = "40",
            label = "Lingkar Kepala (cm)",
            onValueChange = {},
            value = ""
        )

        Spacer(Modifier.height(32.dp))
        SectionText(title = "Data Pertumbuhan Terbaru")
        Spacer(Modifier.height(12.dp))

        Input(
            icon = null,
            placeholder = "Pilih Tanggal",
            label = "Tanggal Pengukuran",
            onValueChange = {},
            value = "",
        )
        Input(
            icon = null,
            placeholder = "3.5",
            label = "Berat Badan (kg)",
            onValueChange = {},
            value = ""
        )
        Input(
            icon = null,
            placeholder = "47",
            label = "Tinggi Badan (cm)",
            onValueChange = {},
            value = ""
        )
        Input(
            icon = null,
            placeholder = "40",
            label = "Lingkar Kepala (cm)",
            onValueChange = {},
            value = ""
        )

        Spacer(Modifier.height(32.dp))
        SectionText(title = "Data Tambahan")
        Spacer(Modifier.height(12.dp))

        Input(
            icon = null,
            placeholder = "Jeruk, Kacang, Apel,",
            label = "Daftar Alergi",
            onValueChange = {},
            value = ""
        )

        Spacer(Modifier.height(32.dp))
        PrimaryButton(
            text = "Tambah Data Anak",
            onClick = {},
            modifier = Modifier.padding(horizontal = 20.dp)
        )
        Spacer(Modifier.height(20.dp))

    }
}

@Composable
@Preview(showBackground = true)
fun AddChildScreenPreview(){
    HeailyAppTheme() {
        AddChildScreen()
    }
}