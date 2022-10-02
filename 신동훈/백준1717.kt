import java.io.BufferedReader
import java.io.InputStreamReader

val br = BufferedReader(InputStreamReader(System.`in`))
val sb = StringBuilder()
const val YES = "YES\n"
const val NO = "NO\n"


fun main() {

    val inputs = br.readLine().split(" ")

    // 정점의 개수
    val vertexCount = inputs[0].toInt()

    // 명령 개수
    val instructionCount = inputs[1].toInt()

    // 정점들을 담을 리스트
    val vertexes = mutableListOf<Vertex<Int>>()

    /**
     * 정점의 수만큼 정점 생성
     * [ 0 : vertexCount ]
     */
    repeat(vertexCount + 1) {
        vertexes.add(Vertex(it))
    }


    /**
     * 명령어 수만큼 작업 수행
     * [ 0 : instructionCount )
     */
    val uf = UnionFind<Int>()
    repeat(instructionCount) {
        val inputs = br.readLine().split(" ").map { it.toInt() }

        when(inputs[0]) {
            // UNION
            0 -> uf.union(vertexes[inputs[1]], vertexes[inputs[2]])

            // FIND
            1 -> {
                if (uf.find(vertexes[inputs[1]]) == uf.find(vertexes[inputs[2]])) {
                    sb.append(YES)
                }
                else {
                    sb.append(NO)
                }
            }
        }
    }
    print(sb.toString())
}

class UnionFind<T : Comparable<T>> {


    fun find(vertex: Vertex<T>): Vertex<T> {

        var current = vertex

        while (current.parent != current) { // root 노드 찾기
            current = current.parent
        }

        return current
    }

    fun union(x: Vertex<T>, y: Vertex<T>) {
        val xRoot = find(x)
        val yRoot = find(y)

        if (xRoot.rank > yRoot.rank) {
            yRoot.parent = xRoot
        }
        else {
            xRoot.parent = yRoot

            if (xRoot.rank == yRoot.rank) {
                yRoot.rank += 1
            }
        }
    }
}

class Vertex<T : Comparable<T>>(

    val value: T,

    ) {

    var parent: Vertex<T> = this

    var rank: Int = 0
}
