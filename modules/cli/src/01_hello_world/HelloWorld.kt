// Entry point
fun main() {

    // --- Exemplo de interpolação de strings ---
    val name = "Mary"
    val age = 20

    // Concatenando strings
    println(name + " is " + age + " years old")

    // Usando interpolação
    println("$name is $age years old")

    println("Hello, world!")

    // --- Tipos e inferência ---
    val preco = 54.90 // Tipo inferido como Double

    // Tipos primitivos
    val byteValue: Byte = 8        // 8-bit
    val shortValue: Short = 16     // 16-bit
    val ageInt: Int = 31           // 32-bit
    val longValue: Long = 19203183291L // 64-bit (L no final indica Long)
    val price: Double = 31.90      // 64-bit ponto flutuante
    val product: String = "iMac"   // String

    println(product::class)

    // --- Conversão de tipos ---
    val mediaDePreco = 22
    val resposta = mediaDePreco.toDouble()

    println(resposta)
}
