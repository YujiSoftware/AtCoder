import java.util.*

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val N = sc.nextLong()
    val M = sc.nextLong()

    if (N > M / 2) {
        println(Math.min(N, M / 2))
    } else {
        println(N + (M - N * 2) / 4)
    }
}
