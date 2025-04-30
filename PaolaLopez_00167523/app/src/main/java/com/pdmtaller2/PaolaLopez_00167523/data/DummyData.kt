package com.pdmtaller2.PaolaLopez_00167523.data

import com.pdmtaller2.PaolaLopez_00167523.R

//DummyData para pruebas hecha con chatgpt

object DummyData {

    val dishes = listOf(
        Dish(1, "Pizza Margarita", "Pizza clásica con tomate y mozzarella", R.drawable.margarita),
        Dish(2, "Espagueti Carbonara", "Pasta con huevo, queso y panceta", R.drawable.carbonara),
        Dish(3, "Hamburguesa Clásica", "Carne de res con lechuga, tomate y queso", R.drawable.hamburguesa),
        Dish(4, "Papas Fritas", "Papas crujientes con sal", R.drawable.papasfritas),
        Dish(5, "Tacos al Pastor", "Tacos con carne adobada y piña", R.drawable.tacospastor),
        Dish(6, "Enchiladas Verdes", "Tortillas rellenas con pollo y salsa verde", R.drawable.enchiladasverdes),
        Dish(7, "Ramen", "Sopa japonesa con fideos y cerdo", R.drawable.ramen),
        Dish(8, "Sushi Variado", "Surtido de sushi fresco", R.drawable.sushi),
        Dish(9, "Ensalada César", "Lechuga con crutones y aderezo César", R.drawable.ensaladacaesar),
        )

    val restaurants = listOf(
        // Comida Italiana
        Restaurant(1, "La Trattoria", "Comida italiana tradicional", R.drawable.latrattoria, listOf("Comida Italiana"), listOf(dishes[0], dishes[1])),
        Restaurant(2, "Pasta e Basta", "Especialidades en pastas frescas", R.drawable.pastaebasta, listOf("Comida Italiana"), listOf(dishes[1], dishes[0])),
        Restaurant(3, "Osteria del Gusto", "Comida italiana auténtica", R.drawable.osteriadelgusto, listOf("Comida Italiana"), listOf(dishes[0], dishes[2])),
        Restaurant(4, "La Pizza Viva", "Las mejores pizzas de la ciudad", R.drawable.pizzaviva, listOf("Comida Italiana"), listOf(dishes[0], dishes[2])),

        // Comida Rápida
        Restaurant(5, "Burger Stop", "Hamburguesas al instante", R.drawable.burgerstop, listOf("Comida Rápida"), listOf(dishes[2], dishes[3])),
        Restaurant(6, "Fritolandia", "Delicias fritas para todos", R.drawable.fritolandia, listOf("Comida Rápida"), listOf(dishes[3], dishes[2])),
        Restaurant(7, "Fast Burger", "Las mejores hamburguesas en minutos", R.drawable.fastburger, listOf("Comida Rápida"), listOf(dishes[2], dishes[4])),
        Restaurant(8, "Fry Heaven", "Comida rápida con estilo", R.drawable.fryheaven, listOf("Comida Rápida"), listOf(dishes[4], dishes[3])),

        // Comida Mexicana
        Restaurant(9, "El Taco Feliz", "Auténticos tacos mexicanos", R.drawable.eltacofeliz, listOf("Comida Mexicana"), listOf(dishes[4], dishes[5])),
        Restaurant(10, "Sazón Azteca", "Sabor tradicional mexicano", R.drawable.sazonazteca, listOf("Comida Mexicana"), listOf(dishes[5], dishes[4])),
        Restaurant(11, "La Casa del Mole", "Mole poblano y otros sabores mexicanos", R.drawable.casadelmole, listOf("Comida Mexicana"), listOf(dishes[5], dishes[6])),
        Restaurant(12, "Tacos El Charro", "Los mejores tacos de la ciudad", R.drawable.tacoselcharro, listOf("Comida Mexicana"), listOf(dishes[4], dishes[5])),

        // Comida Asiática
        Restaurant(13, "Sakura", "Delicias japonesas auténticas", R.drawable.sakura, listOf("Comida Asiática"), listOf(dishes[6], dishes[7])),
        Restaurant(14, "Asia Express", "Comida asiática rápida", R.drawable.asiaexpress, listOf("Comida Asiática"), listOf(dishes[7], dishes[6])),
        Restaurant(15, "Wok & Sushi", "Comida asiática y sushi fresco", R.drawable.woksushi, listOf("Comida Asiática"), listOf(dishes[7], dishes[6])),
        Restaurant(16, "Bamboo Garden", "Restaurante asiático con sabores exóticos", R.drawable.bamboogarden, listOf("Comida Asiática"), listOf(dishes[7], dishes[6])),

        // Comida Saludable
        Restaurant(17, "Verde Vida", "Opciones saludables y frescas", R.drawable.verdevida, listOf("Comida Saludable"), listOf(dishes[8])),
        Restaurant(18, "Naturally", "Comida sana para el alma", R.drawable.naturally, listOf("Comida Saludable"), listOf(dishes[8])),
        Restaurant(19, "Fresh&Fit", "Ensaladas y smoothies naturales", R.drawable.freshfit, listOf("Comida Saludable"), listOf(dishes[8])),
        Restaurant(20, "Salad Bowl", "Deliciosas ensaladas frescas", R.drawable.saladbowl, listOf("Comida Saludable"), listOf(dishes[8])),
    )
}
