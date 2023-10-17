package com.example.assignment3.components

import java.io.Serializable

/**
 * Data class used to store the type of death of the person and the image related to the death.
 * In order to stay family friendly, another file will generate a list of causes that are completely absurd.
 * @param name  The name of the death
 * @param image The id of the image, since the painterResource takes in an id of type int
 */
data class Cause(val name: String, val image: Int) : Serializable
