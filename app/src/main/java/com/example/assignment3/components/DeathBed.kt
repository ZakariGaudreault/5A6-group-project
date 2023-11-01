package com.example.assignment3.components

import java.io.Serializable

/**
 * Data class used to store one potential victim.
 * @param firstName The first name of the victim
 * @param lastName The last name of the victim
 * @param causeOfDeath The cause of death of the victim
 */
data class DeathBed(val firstName: String, val lastName: String, val causeOfDeath: Cause) :
    Serializable {
    val fullName: String = "$firstName $lastName"
    val id: String = "$firstName$lastName"
}