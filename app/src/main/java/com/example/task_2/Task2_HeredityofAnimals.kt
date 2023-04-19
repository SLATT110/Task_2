package com.example.task_2


open class Animal(val name: String, var age: Int, var isSleeping: Boolean = false) {
    fun sleep() {
        isSleeping = true
        println("$name is sleeping")
    }
    fun isOld() = age > 20
}
class Dog(name: String, age: Int, var breed: String, var bark:Boolean) : Animal(name, age) {
    fun bark() {
        if (!isSleeping) {
            println("$name is barking")
        }
    }
}
class Cat(name: String, age: Int, var color: String, var scratch: Boolean) : Animal(name, age) {
    fun scratch() {
        if (!isSleeping) {
            println("$name is scratching")
        }
    }
}
fun printAnimalDetails(animals: List<Animal>) {
    animals.forEach { animal ->
        when (animal) {
            is Dog -> println("Name: ${animal.name}, Breed: ${animal.breed}")
            is Cat -> println("Name: ${animal.name}, Color: ${animal.color}")
            else -> println("Name: ${animal.name}")
        }
        animal.sleep()
    }
}
fun main() {
    val dog1 = Dog("Tony", 5, "Golden Retriever",true)
    val cat1 = Cat("Pamook", 13, "Tabby", true)
    val animals = listOf<Animal>(dog1, cat1)
    printAnimalDetails(animals)
    animals.forEach { animal ->
        val oldStatus = if (animal.isOld()) "old" else "not old"
        println("${animal.name} is $oldStatus.")
        println(dog1.bark())
    }
}



