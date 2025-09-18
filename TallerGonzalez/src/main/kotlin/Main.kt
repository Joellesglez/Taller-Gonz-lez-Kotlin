fun main() {
    // =========================
    // 1) Datos base y constantes
    // =========================

    val taller = "Kotlin Taller González"     // nombre del taller, nunca cambiará -> val
    val aforoMax = 5                         // aforo máximo del taller -> val
    val precioBase = 50.0                     // precio base por inscripción -> val (Double para permitir decimales)

    println("=== $taller ===")
    println("Aforo máximo: $aforoMax")
    println("Precio base: $precioBase €\n")

    // Checkpoint: val usado porque no necesitamos reasignar, usaríamos var solo si esperáramos cambiar el valor.

    // =========================
    // 2) Entrada segura del usuario
    // =========================

    // Función para leer edad segura
    fun leerEdad(): Int {
        while (true) {
            print("Edad: ")
            val input = readLine()
            val edad = input?.toIntOrNull()
            if (edad != null && edad > 0) return edad
            println("Por favor, introduce un número válido mayor que 0.")
        }
    }

    // Función para leer nombre seguro
    fun leerNombre(): String {
        while (true) {
            print("Nombre: ")
            val nombre = readLine()
            if (!nombre.isNullOrBlank()) return nombre
            println("El nombre no puede estar vacío.")
        }
    }

    // Función para leer email opcional
    fun leerEmail(): String? {
        print("Email (opcional): ")
        val email = readLine()
        return if (email.isNullOrBlank()) null else email
    }

    // =========================
    // 3) Reglas de precio
    // =========================
    fun calcularPrecio(edad: Int): Double {
        val descuento = when {
            edad < 18 -> 0.5           // 50% descuento para menores
            edad >= 65 -> 0.3          // 30% descuento para mayores
            else -> 0.0
        }
        return (precioBase * (1 - descuento)).coerceAtLeast(0.0) // precio no negativo
    }

    // =========================
    // 4) Colecciones
    // =========================
    val modalidades = listOf("mañana", "tarde")       // lista inmutable
    println("Modalidades disponibles: $modalidades\n")

    val inscripciones = mutableListOf<Map<String, Any?>>()  // mutableList para agregar inscripciones

    // Bucle de alta
    while (inscripciones.size < aforoMax) {
        println("=== Nuevo registro ===")
        val nombre = leerNombre()
        val edad = leerEdad()
        val email = leerEmail()
        val dominio = email?.substringAfter("@") ?: "sin-dominio"

        print("Modalidad (${modalidades.joinToString("/")}): ")
        val modalidad = readLine()
        if (modalidad !in modalidades) {
            println("Modalidad inválida. Inténtalo de nuevo.\n")
            continue
        }

        val precioFinal = calcularPrecio(edad)

        val inscripcion = mapOf(
            "nombre" to nombre,
            "edad" to edad,
            "email" to email,
            "dominio" to dominio,
            "modalidad" to modalidad,
            "precio" to precioFinal
        )

        inscripciones.add(inscripcion)
        println("Inscripción realizada. Precio final: $precioFinal €\n")

        if (inscripciones.size == aforoMax) {
            println("Se ha alcanzado el aforo máximo.\n")
            break
        }

        print("¿Deseas registrar otra inscripción? (s/n): ")
        val resp = readLine()
        if (resp?.lowercase() != "s") break
    }

    // =========================
    // 5) Estadísticas
    // =========================
    val precios = inscripciones.map { it["precio"] as Double }
    val promedio = if (precios.isNotEmpty()) precios.average() else 0.0
    val maxPrecio = precios.maxOrNull() ?: 0.0
    val minPrecio = precios.minOrNull() ?: 0.0
    val menoresEdad = inscripciones.filter { (it["edad"] as Int) < 18 }

    println("\n=== Estadísticas del Taller ===")
    println("Total inscripciones: ${inscripciones.size}")
    println("Precio promedio: ${"%.2f".format(promedio)} €")
    println("Precio máximo: $maxPrecio €")
    println("Precio mínimo: $minPrecio €")
    println("Menores de edad inscritos: ${menoresEdad.size}")

    // =========================
    // 7) Listado final
    // =========================
    println("\n=== Listado de Inscripciones ===")
    for (insc in inscripciones) {
        val nombre = insc["nombre"] as String
        val inicial = nombre.firstOrNull() ?: '?'
        val edad = insc["edad"]
        val modalidad = insc["modalidad"]
        val precio = insc["precio"]
        val dominio = insc["dominio"]
        println("$inicial - $nombre, $edad años, $modalidad, ${precio} €, dominio: $dominio")
    }

    println("\nGracias nuestra app. Te deseamos feliz día por parte de $taller")
}
