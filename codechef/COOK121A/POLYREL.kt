import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter

val bf = BufferedReader(InputStreamReader(System.`in`))
val writer = PrintWriter(System.out)
fun i(): Int { return bf.readLine().toInt() }
fun ni(): IntArray { return bf.readLine().trim().split(" ").map { it.toInt() }.toIntArray()}


fun update(d : IntArray,i : Int) {
    var index = i.inc();
    val n = d.size;
    while(index<n){
        
    }

}

fun main() {
    var t = i()
    while(t-->0){
        var n = i()
        var count = 0L
        var i = n; while(i-->0) bf.readLine()
        while(n>2){
            count+=n
            n/=2
        }
        writer.println(count)
    }

    writer.flush()
    writer.close()
}
