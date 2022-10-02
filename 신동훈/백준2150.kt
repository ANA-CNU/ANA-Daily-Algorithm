import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Collections

val br = BufferedReader(InputStreamReader(System.`in`))
val sb = StringBuilder()


fun main() {

    val inputs = br.readLine().split(" ").map { it.toInt() }

    val vertexCount = inputs[0]
    val edgeCount = inputs[1]

    val graph = Graph(vertexCount)
    val reverseGraph = Graph(vertexCount)


    // 그래프 세팅
    repeat(edgeCount) {

        val edges = br.readLine().split(" ").map { it.toInt() }

        graph.add(edges[0]-1, edges[1]-1)

        reverseGraph.add(edges[1]-1, edges[0]-1)
    }



    // 리버스에서 DFS 수행 -> 스택 리턴 받기
    val reverseGraphStack = reverseGraph.dfs()


    val sccList = mutableListOf<StrongConnectedComponents>()

    // 스택에 TOP의 원소를 가지고 원래 그래프에서 DFS 수행 -> SCC 하나 추가
    while (reverseGraphStack.isNotEmpty()) {


        val sink = reverseGraphStack.removeLast()

        if (sccList.any { it.contains(sink) }) {
            continue
        }

        val scc = ArrayDeque<Vertex>()

        graph.dfs(sink.value, stack = scc)

        sccList.add(StrongConnectedComponents(scc.toMutableList()))
    }

    // SCC가 담긴 List 반환 -> 총 개수와 각각 원소 ~~~
    sccList.sort()
    println(sccList.size)
    sccList.forEach {
        println(it.toString())
    }
}

class Graph(
    count: Int,
) {
    private val graph: MutableList<MutableList<Vertex>> = mutableListOf()
    private val vertexList: MutableList<Vertex> = mutableListOf()

    init {
        repeat(count) {
            graph.add(mutableListOf())
            vertexList.add(Vertex(it)) // [0 ~ count-1]
        }
    }

    fun add(start: Int, end: Int) {
        graph[start].add(vertexList[end])
    }

    fun dfs(): ArrayDeque<Vertex> {

        val stack = ArrayDeque<Vertex>()
        vertexList.forEach {
            if(!it.isVisited) dfs(it.value, stack)
        }
        return stack
    }

    fun dfs(
        rootIdx: Int,
        stack: ArrayDeque<Vertex>,
    ) {
        var root = vertexList[rootIdx]
        root.isVisited = true

        graph[root.value].forEach {adjacent ->
            if (!adjacent.isVisited) {
                dfs(adjacent.value, stack)
            }
        }

        stack.add(root)
    }
}


class Vertex (
    val value: Int,
) : Comparable<Vertex> {
    var isVisited: Boolean = false
    override fun compareTo(other: Vertex): Int {
       return this.value - other.value
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Vertex) return false

        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        return value
    }

}

class StrongConnectedComponents (
    val scc: MutableList<Vertex>,
) : Comparable<StrongConnectedComponents> {


    private var smallestValue: Int = Int.MAX_VALUE

    init {
        scc.sort()
        smallestValue = scc[0].value
    }


    override fun compareTo(other: StrongConnectedComponents): Int {
        return this.smallestValue - other.smallestValue
    }

    fun contains(sink: Vertex): Boolean {
       return scc.contains(sink)
    }

    override fun toString(): String {
        val sb = StringBuilder()

        scc.forEach { sb.append("${it.value + 1} ") }
        sb.append("-1")
        return sb.toString()
    }

}