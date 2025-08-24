package com.github.compute

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform