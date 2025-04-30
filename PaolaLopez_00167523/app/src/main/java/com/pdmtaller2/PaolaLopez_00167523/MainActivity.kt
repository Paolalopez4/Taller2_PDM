package com.pdmtaller2.PaolaLopez_00167523

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.pdmtaller2.PaolaLopez_00167523.ui.navigation.Navigation
import com.pdmtaller2.PaolaLopez_00167523.ui.theme.PaolaLopez_00167523Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PaolaLopez_00167523Theme {
                Navigation()
            }
        }
    }
}
