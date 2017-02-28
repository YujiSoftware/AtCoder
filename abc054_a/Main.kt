import java.util.*

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)

    var A = sc.nextInt()
    var B = sc.nextInt()

    if (A == 1) {
        A = 14
    }
    if (B == 1) {
        B = 14
    }
    if (A > B) {
        println("Alice")
    } else if (A < B) {
        println("Bob")
    } else {
        println("Draw")
    }
}
