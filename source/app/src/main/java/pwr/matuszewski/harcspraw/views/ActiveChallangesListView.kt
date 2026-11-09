package pwr.matuszewski.harcspraw.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.foundation.text.input.setTextAndPlaceCursorAtEnd
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuAnchorType
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pwr.matuszewski.harcspraw.R
import pwr.matuszewski.harcspraw.ui.theme.HarcSprawTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ActiveChallangesView() {
    val options: List<String> = listOf("a", "b", "c", "d", "e")
    var expanded by remember { mutableStateOf(false) }
    val textFieldState = rememberTextFieldState(options[0])

    Column(Modifier.fillMaxSize().padding(top = 40.dp)) {
        Text("Aktywne próby", style = MaterialTheme.typography.headlineLarge)
        Row(Modifier.fillMaxWidth()) {
            Text("2 próby w toku")

            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = { expanded = it },
                Modifier.fillMaxWidth().height(64.dp)
            ) {
                TextField(
                    // The `menuAnchor` modifier must be passed to the text field to handle
                    // expanding/collapsing the menu on click. A read-only text field has
                    // the anchor type `PrimaryNotEditable`.
                    modifier = Modifier.menuAnchor(ExposedDropdownMenuAnchorType.PrimaryNotEditable),
                    state = textFieldState,
                    readOnly = true,
                    lineLimits = TextFieldLineLimits.SingleLine,
                    label = { Text("Label") },
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                    colors = ExposedDropdownMenuDefaults.textFieldColors(),
                )
                ExposedDropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                options.forEach { option ->
                    DropdownMenuItem(
                        text = { Text(option) },
                        onClick = {
                            textFieldState.setTextAndPlaceCursorAtEnd(option)
                            expanded = false
                        },
                        contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,
                    )
                }
            }
            }
        }

        LazyColumn(
            Modifier.fillMaxSize().padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            items(10) {
                ActiveChallengeListItem(
                    name = "Skaut",
                    level = 3,
                    completedTasks = 3,
                    tasks = 5,
                    timeLeft = 21
                )
            }
        }
    }
}

@Composable
fun ActiveChallengeListItem(name: String, level: Int, completedTasks: Int, tasks: Int, timeLeft: Int) {
    Card(
        Modifier.fillMaxWidth().wrapContentHeight().clip(CardDefaults.shape)
    ) {
        Column(Modifier.fillMaxWidth().wrapContentHeight().padding(10.dp)) {
            Row(
                Modifier.fillMaxWidth()
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.sim_spr_h_skaut),
                    tint = null,
                    contentDescription = null,
                    modifier = Modifier.size(80.dp)
                )
                Column() {
                    Text(name, style = MaterialTheme.typography.headlineMedium)
                    Row() {
                        //TODO("Change Box to level icon")
                        Box(Modifier.size(25.dp).clip(CircleShape).background(Color.Green))
                        Text("Poziom $level", style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }
            Text("Zadania: $completedTasks/$tasks")
            LinearProgressIndicator(progress = { completedTasks.toFloat() / tasks.toFloat() }, modifier = Modifier.fillMaxWidth().height(10.dp))
            ElevatedCard() {
                Row(Modifier.padding(3.dp)) {
                    Icon(
                        painter = painterResource(id = R.drawable.clock),
                        tint = Color.Gray,
                        contentDescription = "yes"
                    )
                    Text("Pozostało $timeLeft dni")
                }
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xffffffff)
@Composable
fun ActiveChallengeListSingleItemPreview() {
    HarcSprawTheme {
        Box(modifier = Modifier.padding(10.dp)) {
            ActiveChallengeListItem(
                name = "Skaut",
                level = 3,
                completedTasks = 3,
                tasks = 5,
                timeLeft = 21
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xffffffff)
@Composable
fun ActiveChallengeListPreview() {
    HarcSprawTheme {
        Column(
            modifier = Modifier.padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            ActiveChallengeListItem(
                name = "Skaut",
                level = 3,
                completedTasks = 3,
                tasks = 5,
                timeLeft = 21
            )
            ActiveChallengeListItem(
                    name = "Skaut",
            level = 3,
            completedTasks = 3,
            tasks = 5,
            timeLeft = 21
            )
            ActiveChallengeListItem(
                name = "Skaut",
                level = 3,
                completedTasks = 3,
                tasks = 5,
                timeLeft = 21
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ActiveChallangesViewPreview() {
    HarcSprawTheme {
        ActiveChallangesView()

    }
}