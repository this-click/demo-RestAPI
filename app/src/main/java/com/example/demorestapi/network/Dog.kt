package com.example.demorestapi.network

/**
 * Defines a Dog with name, weight and the amount of food to give at each meal.
 * These properties are used by Moshi to match the names of values in the JSON
 * returned by the Rest API, built with Java and SpringBoot and hosted on an AWS EC2 instance.
 */
data class Dog(
    val name: String,
    val weight: Double,
    val foodAmount: Double
)
