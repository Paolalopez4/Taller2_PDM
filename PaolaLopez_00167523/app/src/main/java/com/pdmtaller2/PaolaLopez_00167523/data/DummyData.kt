package com.pdmtaller2.PaolaLopez_00167523.data

object DummyData {
    val dishes = listOf(
        Dish(1, "Margherita Pizza", "Classic tomato and mozzarella pizza", "https://example.com/pizza.jpg"),
        Dish(2, "Spaghetti Carbonara", "Pasta with eggs, cheese, pancetta, and black pepper", "https://example.com/spaghetti.jpg"),
        Dish(3, "Caesar Salad", "Romaine lettuce, croutons, parmesan cheese, and Caesar dressing", "https://example.com/salad.jpg"),
        Dish(4, "Cheeseburger", "Beef patty with cheese, lettuce, tomato, and special sauce", "https://example.com/cheeseburger.jpg"),
        Dish(5, "French Fries", "Crispy deep-fried potato sticks", "https://example.com/fries.jpg"),
        Dish(6, "Chocolate Cake", "Rich chocolate cake with frosting", "https://example.com/cake.jpg"),
        Dish(7, "Sushi Platter", "Assorted fresh sushi rolls", "https://example.com/sushi.jpg"),
        Dish(8, "Ramen", "Japanese noodle soup with various toppings", "https://example.com/ramen.jpg"),
        Dish(9, "Tacos al Pastor", "Marinated pork tacos with pineapple", "https://example.com/tacos.jpg")
    )

    val restaurants = listOf(
        Restaurant(
            1,
            "Italian Delight",
            "Authentic Italian cuisine in a cozy setting",
            "https://example.com/italian.jpg",
            listOf("Italian", "Pizza", "Pasta"),
            listOf(dishes[0], dishes[1])
        ),
        Restaurant(
            2,
            "Burger Joint",
            "The best burgers in town!",
            "https://example.com/burger.jpg",
            listOf("Burgers", "Fast Food"),
            listOf(dishes[3], dishes[4])
        ),
        Restaurant(
            3,
            "Sweet Surrender",
            "Treat yourself to delicious desserts and cakes",
            "https://example.com/dessert.jpg",
            listOf("Desserts", "Cakes"),
            listOf(dishes[5])
        ),
        Restaurant(
            4,
            "Tokyo Eats",
            "Authentic Japanese cuisine",
            "https://example.com/japanese.jpg",
            listOf("Japanese", "Sushi", "Ramen"),
            listOf(dishes[6], dishes[7])
        ),
        Restaurant(
            5,
            "Mexico Lindo",
            "The most delicious mexican food",
            "https://example.com/mexican.jpg",
            listOf("Mexican", "Tacos"),
            listOf(dishes[8])
        ),
        Restaurant(
            6,
            "Salad Bar",
            "Fresh salads to satisfy your healthy cravings",
            "https://example.com/salad_bar.jpg",
            listOf("Salad", "Healthy"),
            listOf(dishes[2])
        )
    )
}