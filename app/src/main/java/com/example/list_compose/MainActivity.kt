package com.example.list_compose

import android.graphics.Paint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalCoilApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val colourList = addItems()
            LazyRow {
                itemsIndexed(
                    colourList
                ) { index, _ ->
                    if (index < 3) {
                        Row(
                            modifier = Modifier
                                .wrapContentWidth()
                                .wrapContentSize(Alignment.Center)
                                .padding(end = 10.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .width(100.dp)
                                    .height(100.dp)
                                    .border(5.dp, color = Color.Black)
                                    .padding(10.dp)

                            ) {
                                val painter = rememberImagePainter(
                                    data = colourList[index],
                                    builder = {
                                        placeholder(R.drawable.ic_launcher_background)
                                        crossfade(1000)
                                    })
                                val painterState = painter.state
                                Image(painter = painter, contentDescription = "swatch image")
                                if (painterState is ImagePainter.State.Loading) {
                                    CircularProgressIndicator()
                                }
                            }
                        }
                    }
                }
                if (colourList.size > 3) {
                    item {
                        Text(
                            text = "+" + (colourList.size - 3).toString(),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .width(29.dp)
                                .padding(top = 40.dp)
                        )
                    }
                }
                /* item {
                     Box(
                         modifier = Modifier
                             .width(50.dp)
                             .height(50.dp)
                             .padding(10.dp)
                             .clip(CircleShape)
                             .background(Color.Red)

                     ) {
                         Row(
                             modifier = Modifier
                                 .fillMaxWidth()
                                 .padding(5.dp),
                             verticalAlignment = Alignment.CenterVertically,
                         ) {
                             Text(text = (colourList.size-3).toString())
                         }
                     }
                 }*/
            }
        }
    }

    private fun addItems(): ArrayList<String> {
        val myList = ArrayList<String>()
/*        myList.add("https://asset1.marksandspencer.com/is/image/mands/SD_07_T23_3110M_D6_X_EC_88")
        myList.add("https://asset1.marksandspencer.com/is/image/mands/SD_07_T23_3110M_Y0_X_EC_88")
        myList.add("https://asset1.marksandspencer.com/is/image/mands/SD_07_T23_3110M_AU_X_EC_88")
        myList.add("https://asset1.marksandspencer.com/is/image/mands/SD_07_T23_3110M_AS_X_EC_88")
        myList.add("https://asset1.marksandspencer.com/is/image/mands/SD_07_T23_3110M_S0_X_EC_88")
        myList.add("https://asset1.marksandspencer.com/is/image/mands/SD_07_T23_3110M_PX_X_EC_88")
        myList.add("https://asset1.marksandspencer.com/is/image/mands/SD_07_T23_3110M_D0_X_EC_88")
        myList.add("https://asset1.marksandspencer.com/is/image/mands/SD_07_T23_3110M_BV_X_EC_88")

        myList.add("https://asset1.marksandspencer.com/is/image/mands/SD_07_T23_3110M_IK_X_EC_88")
        myList.add("https://asset1.marksandspencer.com/is/image/mands/SD_07_T23_3110M_PC_X_EC_88")
        myList.add("https://asset1.marksandspencer.com/is/image/mands/SD_07_T23_3110M_MS_X_EC_88")
        */return myList
    }

    @ExperimentalMaterialApi
    @Composable
    @Preview
    fun ColourCellPreview() {

    }
}

