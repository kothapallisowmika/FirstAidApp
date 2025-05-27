package com.example.firstaidapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstaidapp.ui.theme.FirstAidAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstAidAppTheme {
                FirstAidApp()
            }
        }
    }
}

@Composable
fun FirstAidApp() {
    val instruction = remember { mutableStateOf("Select an emergency to see first-aid steps.") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp, top = 48.dp, bottom = 16.dp) // <-- pushed down here
    ) {
        Text(
            text = "First Aid Guide",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Button(
            onClick = {
                instruction.value = "🔥 Burn Injury:\n\n" +
                        "- Cool the burn under water for 10–15 minutes\n" +
                        "- Don’t apply ice or creams\n" +
                        "- Cover with a clean cloth\n" +
                        "- Get medical help if needed"
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        ) {
            Text("Burn Injury")
        }

        Button(
            onClick = {
                instruction.value = "🩸 Cut or Wound:\n\n" +
                        "- Apply pressure to stop bleeding\n" +
                        "- Wash the area gently\n" +
                        "- Use antiseptic and bandage\n" +
                        "- See a doctor if it's deep"
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        ) {
            Text("Cut or Wound")
        }

        Button(
            onClick = {
                instruction.value = "😵 Fainting:\n\n" +
                        "- Lay the person flat and raise legs\n" +
                        "- Loosen tight clothes\n" +
                        "- Check breathing\n" +
                        "- Seek medical help if necessary"
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            Text("Fainting")
        }

        Text(
            text = instruction.value,
            fontSize = 16.sp,
            modifier = Modifier.padding(top = 16.dp)
        )
    }
}
