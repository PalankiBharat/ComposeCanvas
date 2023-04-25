package com.example.composecanvas

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties
import com.maxkeppeker.sheets.core.models.base.Header
import com.maxkeppeker.sheets.core.models.base.IconSource
import com.maxkeppeker.sheets.core.models.base.SelectionButton
import com.maxkeppeker.sheets.core.models.base.rememberUseCaseState
import com.maxkeppeler.sheets.date_time.DateTimeDialog
import com.maxkeppeler.sheets.date_time.models.DateTimeConfig
import com.maxkeppeler.sheets.date_time.models.DateTimeSelection
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.FormatStyle
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DateTimePickerDialogComposable(modifier: Modifier = Modifier) {
    val selectedDateTime = remember {
        mutableStateOf<LocalDate?>(null)
    }

    DateTimeDialog(
        state = rememberUseCaseState(visible = true),
        selection = DateTimeSelection.Date(
            selectedDate = LocalDate.now(),
            dateFormatStyle = FormatStyle.FULL,
        ) { newDateTime ->
            selectedDateTime.value = newDateTime
        }
    )
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showSystemUi = true)
@Composable
fun MyTextViewPreview() {
    DateTimePickerDialogComposable()
}

/*

)*/
