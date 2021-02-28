package com.rtusiime.memez.model


import kotlin.random.Random

class MemeCombinator (var caption: Int = Random.nextInt(1,8) , var image: Int = Random.nextInt(1,8)){
    var viewNumber = 0


   fun  getPair(): Pair<Int, Int> {
       caption = Random.nextInt(1,8)
       image = Random.nextInt(1,8)
       return Pair(caption, image)
   }
}