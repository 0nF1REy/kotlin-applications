// Entry point
fun main() {
    println("Hello, world!");

    // Tipo inferido
    val preco = 54.90;

    // Tipos primitivos
    val byte = 8; // 8-bit
    val short = 16; // 16-bit
    val age = 31; // 32-bit
    val long = 19203183291; // 64-bit
    val price: Double = 31.90; // 64-bit ponto flutuante
    val product: String = "iMac";

    println(product::class);

    val mediaDePreco = 22;

    val resposta = mediaDePreco.toDouble();

    println(resposta);
}