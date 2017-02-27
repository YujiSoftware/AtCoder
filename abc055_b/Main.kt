import java.util.*

fun main(args: Array<String>) {
    val MOD = 1000000007

    val sc = Scanner(System.`in`)
    val N = sc.nextLong()

    var power = 1L
    for (i in 2..N) {
        power = power % MOD * i % MOD
    }

    println(power)
}
