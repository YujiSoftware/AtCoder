import java.util.Scanner

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val N = sc.nextInt()
    val K = sc.nextInt()
    val a = Array(N) { 0 }
    for (i in a.indices) {
        a[i] = sc.nextInt()
    }

    var sum: Long = 0
    var tmp: Long = 0
    for (i in a.indices) {
        tmp += a[i]
        if (i >= K - 1) {
            sum += tmp
            tmp -= a[i - K + 1]
        }
    }

    println(sum)
}
