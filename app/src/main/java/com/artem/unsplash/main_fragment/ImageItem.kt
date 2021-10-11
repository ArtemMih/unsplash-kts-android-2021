package com.artem.unsplash.main_fragment

import java.util.*

data class ImageItem(
    val uuid: UUID,
    val image: String,
    val author: String,
    val avatar: String
)