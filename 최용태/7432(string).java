import java.util.*;
import java.io.*;
import java.util.stream.IntStream;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Root root = new Root();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++)
            root.push(new StringTokenizer(br.readLine(), "\\"));

        root.initWriter();
        root.printDirectoryStructure(0, root.root);
        System.out.println(root.writer);
    }
}

class Root {
    Directory root = new Directory("home");
    StringBuilder writer;

    void push(StringTokenizer t) {
        ArrayList<String> directoryNames = new ArrayList<>();
        int range = t.countTokens();

        IntStream.range(0, range).forEach(o -> directoryNames.add(t.nextToken()));

        Directory currentDirectory = root;

        for (String directoryName : directoryNames) {
            mkdir(currentDirectory, directoryName);
            currentDirectory = cd(currentDirectory, directoryName);
        }
    }

    boolean hasDirectory(Directory target, String name) {
        return target.children.containsKey(name);
    }

    Directory cd(Directory currentDirectory, String name) {
        return currentDirectory.children.get(name);
    }

    void mkdir(Directory target, String name) {
        if (!hasDirectory(target, name)) {
            target.children.put(name, new Directory(name));
            target.childrenNames.add(name);
        }
    }

    void initWriter() {
        this.writer = new StringBuilder();
    }

    void printDirectoryStructure(int depth, Directory currentDirectory) {
        if (currentDirectory != null) {
            ArrayList<String> names=currentDirectory.childrenNames;
            Collections.sort(names);

            for (String next : names) {
                IntStream.range(0, depth).forEach(o -> writer.append(" "));
                writer.append(next).append("\n");

                printDirectoryStructure(depth + 1, cd(currentDirectory, next));
            }
        }
    }

}


class Directory {
    String name;
    HashMap<String, Directory> children = new HashMap<>();
    ArrayList<String> childrenNames = new ArrayList<>();

    Directory(String s) {
        this.name = s;
    }
}