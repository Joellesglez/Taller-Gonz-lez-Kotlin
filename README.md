#  📚 Registro de Inscripciones a un Taller – Kotlin App


#  🔹 Descripción
Esta es una aplicación de consola en Kotlin para gestionar inscripciones a un taller, llamada “Kotlin Taller González”.
Permite registrar participantes, calcular precios según reglas de edad, validar datos de entrada, y mostrar estadísticas resumidas de manera sencilla y segura.
La app está diseñada para ser ejecutada en IntelliJ IDEA u otro entorno compatible con Kotlin/JVM.


#  🚀 Funcionalidades principales
Gestión de inscripciones
Solicita nombre, edad y email de cada participante.
Permite elegir entre modalidades del taller (mañana o tarde).
Guarda las inscripciones en memoria usando MutableList.
Validación de entrada
Nombre no vacío.
Edad > 0 y entrada numérica segura con toIntOrNull().
Email opcional; si se deja vacío, se guarda como null.
Se obtiene automáticamente el dominio del email usando el operador Elvis ?:.
Reglas de precios
Precio base configurable (50.0 € por defecto).
Descuentos automáticos:
Menores de 18 → 50% descuento.
Mayores de 65 → 30% descuento.
Resto → precio completo.
Precio final nunca puede ser negativo (coerceAtLeast(0.0)).
Estadísticas automáticas
Número total de inscripciones.
Precio promedio, máximo y mínimo.
Número de menores de edad inscritos.
Listado completo de inscripciones con:
Inicial del nombre
Edad
Modalidad
Precio final
Dominio de email
Control de aforo
Límite configurable (aforoMax).
Bucle de inscripción se detiene automáticamente al alcanzar el máximo.
Manejo seguro de errores
Entradas inválidas se manejan con bucles y mensajes claros.
Uso de Elvis ?: y toIntOrNull() para evitar NullPointerException.
Preparada para futuras extensiones con excepciones personalizadas y menú interactivo.


#  🛠 Estructura del proyecto
RegistroTaller/
├─ src/
│  └─ Main.kt          # Archivo principal con toda la lógica
├─ README.md
└─ build.gradle.kts    # Si se crea proyecto Kotlin/JVM


#  Principales componentes en Main.kt:
Componente	Tipo	Descripción
val taller	String	Nombre del taller
val aforoMax	Int	Capacidad máxima de participantes
val precioBase	Double	Precio base de inscripción
modalidades	List<String>	Modalidades del taller (inmutable)
inscripciones	MutableList<Map<String, Any?>>	Lista dinámica con todas las inscripciones
calcularPrecio()	fun	Calcula el precio según edad y reglas de descuento
leerEdad() / leerNombre() / leerEmail()	fun	Funciones para entrada segura de usuario
#  ⚡ Cómo ejecutar
1.  Clonar o crear el proyecto en IntelliJ IDEA
2.  Crear un archivo Main.kt en src/ y copiar el código fuente.
3.  Ejecutar con Run → MainKt.
4.  Seguir las instrucciones en consola:
5.  Introducir nombre, edad, email (opcional) y modalidad.
6.  Confirmar si quieres registrar otra inscripción.
Al finalizar, verás las estadísticas y listado completo.


#  📝 Ejemplo de uso
=== Kotlin Taller González ===
Aforo máximo: 5
Precio base: 50.0 €

=== Nueva inscripción ===
Nombre: Samuel
Edad: 27
Email (opcional): samuelg@gmail.com
Modalidad (mañana/tarde): mañana
Inscripción registrada. Precio final: 25.0 €

¿Deseas registrar otra inscripción? (s/n): s
...
=== Estadísticas del Taller ===
Total inscripciones: 3
Precio promedio: 40.00 €
Precio máximo: 50.0 €
Precio mínimo: 25.0 €
Menores de edad inscritos: 0

=== Listado de Inscripciones ===
A - Samuel, 27 años, mañana, 25.0 €, dominio: gmail.com
...
Gracias por usar la app de Kotlin Taller González



#  🧩 Detalles de implementación
Constantes (val) para datos que no cambian: taller, aforo, precio base.
Variables (var) para datos dinámicos: lista de inscripciones, respuestas de usuario.
Null Safety y Elvis (?:) para manejar emails opcionales y dominios.
when vs if:
when usado para reglas de descuento según edad (varias condiciones exclusivas).
if usado para validaciones booleanas simples.


#  Colecciones:
List inmutable → opciones fijas (modalidades).
MutableList → inscripciones dinámicas.
Funciones auxiliares para lectura segura de nombre, edad y email, evitando duplicar código.
Previsión de extensiones: búsqueda de inscripciones, estadísticas por dominio, menú interactivo, manejo de excepciones personalizadas.


#  💡 Mejoras futuras
Menú interactivo para registrar, listar, buscar y eliminar inscripciones.
Guardado en archivo CSV o JSON para persistencia.
Contador por dominio de email (Map<String, Int>).
Ordenar listado por nombre y precio.
Notificaciones o resúmenes por email.


#  🏆 Conclusión
Este proyecto es un ejemplo completo de Kotlin para consola, aplicando buenas prácticas de programación:
Entrada segura del usuario ✅
Uso de constantes y variables correctamente ✅
Colecciones y transformaciones (map, filter, sorted) ✅
Validación y manejo de errores ✅
Ideal para aprender Kotlin en un contexto práctico y como base para aplicaciones más complejas de gestión de talleres, cursos o eventos.
