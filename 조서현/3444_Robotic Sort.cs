internal class Program
{
    class Node
    {
        public Node? l, r, p;
        public long cnt = 1, v;
        public bool flip;

        public Node(long v, Node p = null)
        {
            this.v = v; this.p = p;
        }
    }

    private static Node tree;
    private static Node[] nodes = new Node[100010];

    static void Update(Node x)
    {
        x.cnt = 1;
        if (x.l != null)
        {
            x.cnt += x.l.cnt;
        }

        if (x.r != null)
        {
            x.cnt += x.r.cnt;
        }
    }

    static void Propagate(Node x)
    {
        if (!x.flip) return;
        (x.l, x.r) = (x.r, x.l);
        if (x.l != null)
            x.l.flip = !x.l.flip;
        if (x.r != null)
            x.r.flip = !x.r.flip;
        x.flip = false;
    }

    static void Rotate(Node x)
    {
        Node p = x.p, b = null;
        if (p == null) return;
        Propagate(p); Propagate(x);
        if (x == p.l)
        {
            p.l = b = x.r;
            x.r = p;
        }
        else
        {
            p.r = b = x.l;
            x.l = p;
        }

        x.p = p.p;
        p.p = x;
        if (b != null)
            b.p = p;
        if (x.p != null)
        {
            if (p == x.p.l)
                x.p.l = x;
            else x.p.r = x;
        }
        else
            tree = x;
        Update(p); Update(x);
    }

    static void Splay(Node x)
    {
        while (x.p != null)
        {
            Node p = x.p, g = p.p;
            if (g != null)
            {
                if ((x == p.l) == (p == g.l)) Rotate(p);
                else Rotate(x);
            }
            Rotate(x);
        }
    }

    static void FindKth(long k)
    {
        var x = tree;
        Propagate(x);
        while (true)
        {
            while (x.l != null && x.l.cnt > k)
            {
                x = x.l; Propagate(x);
            }

            if (x.l != null) k -= x.l.cnt;
            if (k == 0) break;
            k--;
            x = x.r;
            Propagate(x);
        }
        Splay(x);
    }

    static void Init(int n, List<int> arr)
    {
        nodes[0] = tree = new Node(long.MinValue);
        var cur = tree;
        for (int i = 1; i <= n; ++i)
        {
            nodes[arr[i-1]] = cur.r = new Node(arr[i-1], cur);
            cur = cur.r;
        }

        nodes[n + 1] = cur.r = new Node(long.MaxValue, cur);
        for (int i = n + 1; i >= 0; --i)
            Update(nodes[i]);
        if (n == 1) return;
        Splay(nodes[n >> 1]);
    }

    static void Interval(int s, int e)
    {
        FindKth(s - 1);
        var x = tree;
        tree = x.r;
        tree.p = null;
        FindKth(e - s + 1);
        x.r = tree;
        tree.p = x;
        tree = x;
    }

    static void Flip(int s, int e)
    {
        Interval(s, e);
        var cur = tree.r.l;
        cur.flip = !cur.flip;
    }

    static void Main(string[] args)
    {
        var input = new StreamReader(new BufferedStream(Console.OpenStandardInput()));
        var output = new StreamWriter(new BufferedStream(Console.OpenStandardOutput()));

        while (true)
        {
            int n = int.Parse(input.ReadLine());
            if (n == 0) break;
            var arr = input.ReadLine().Split(" ").Select(int.Parse).ToList();
            var tmp = new List<int>(arr);
            tmp.Sort();
            var dic = new Dictionary<int, int>();
            for (int i = 0; i < n; i++)
            {
                if (!dic.ContainsKey(tmp[i]))
                    dic[tmp[i]] = i + 1;
            }

            for (int i = 0; i < n; i++)
                arr[i] = dic[arr[i]]++;
            
            Init(n, arr);
            for (int i = 1; i <= n; ++i)
            {
                Splay(nodes[i]);
                int j = (int)tree.l.cnt;
                output.Write(j); output.Write(' ');
                Flip(i, j);
                Update(tree);
            }
            output.WriteLine();
        }
        input.Close();
        output.Flush();
        output.Close();
    }
}