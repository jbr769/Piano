package com.example.piano

import android.media.MediaPlayer
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout


@Composable
@Preview
fun Piano(){
    val context = LocalContext.current
    ConstraintLayout(Modifier.fillMaxSize() .background(color = Color.Gray)){
        val (box1, box2, box3, box4, box5, box6, box7,image) = createRefs()

        fun playSound(soundResource: Int){
            val mediaPlayer = MediaPlayer.create(context, soundResource)
            mediaPlayer.start()
            mediaPlayer.setOnCompletionListener {
                it.release()
            }
        }
        Box(Modifier
            .size(200.dp)
            .graphicsLayer(rotationZ = 90f)
            .constrainAs(image) {
                top.linkTo(box7.bottom, margin = 40.dp)
                start.linkTo(box7.start)
                end.linkTo(box7.end)
            }){
            Image(
                painter = painterResource(id = R.drawable.marcapiano),
                contentDescription = "Imagen del piano",
                contentScale = ContentScale.Crop
            )
        }


        Box(Modifier
            .size(110.dp)
            .background(color = Color.White)
            .padding(8.dp)
            .clickable {
                playSound(R.raw.doo)
            }
            .constrainAs(box1){
                start.linkTo(parent.start, margin = 30.dp)
                top.linkTo(parent.top, margin = 150.dp)

            })
        Box(Modifier
            .size(110.dp)
            .background(color = Color.White)
            .padding(8.dp)
            .clickable {
                playSound(R.raw.re)
            }
            .constrainAs(box2){
                start.linkTo(parent.start, margin = 30.dp)
                top.linkTo(box1.bottom, margin = 30.dp)
            })
        Box(Modifier
            .size(110.dp)
            .background(color = Color.White)
            .padding(8.dp)
            .clickable {
                playSound(R.raw.mi)
            }
            .constrainAs(box3){
                start.linkTo(parent.start, margin = 30.dp)
                top.linkTo(box2.bottom, margin = 30.dp)
            })
        Box(Modifier
            .size(110.dp)
            .background(color = Color.White)
            .padding(8.dp)
            .clickable {
                playSound(R.raw.fa)
            }
            .constrainAs(box4){
                start.linkTo(parent.start, margin = 30.dp)
                top.linkTo(box3.bottom, margin = 30.dp)
            })
        Box(Modifier
            .size(110.dp)
            .background(color = Color.Black)
            .padding(8.dp)
            .clickable {
                playSound(R.raw.sol)
            }
            .constrainAs(box5){
                start.linkTo(box1.end, margin = 30.dp)
                top.linkTo(box1.top)
                bottom.linkTo(box2.bottom)
            })
        Box(Modifier
            .size(110.dp)
            .background(color = Color.Black)
            .padding(8.dp)
            .clickable {
                playSound(R.raw.la)
            }
            .constrainAs(box6){
                start.linkTo(box1.end, margin = 30.dp)
                top.linkTo(box2.top)
                bottom.linkTo(box3.bottom)
            })
        Box(Modifier
            .size(110.dp)
            .background(color = Color.Black)
            .padding(8.dp)
            .clickable {
                playSound(R.raw.si)
            }
            .constrainAs(box7){
                start.linkTo(box2.end, margin = 30.dp)
                top.linkTo(box3.top)
                bottom.linkTo(box4.bottom)
            })
    }
}

