import java.util.*;
import java.io.*;
import java.util.stream.IntStream;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer s=new StringTokenizer(br.readLine()," ");
        Root root = new Root();
        root.init();

        int D = Integer.parseInt(s.nextToken());
        int F = Integer.parseInt(s.nextToken());

        for (int i = 0; i < D+F; i++)
            root.push(new StringTokenizer(br.readLine(), " "));

        int M=Integer.parseInt(br.readLine());

        for(int i=0;i<M;i++){
           Directory targetDirectory = root.cd(root.decodingPass(br.readLine()));
           HashSet<String> species=new HashSet<>();

           int countedFiles=root.getSolution(species,targetDirectory);

           root.writer.append(species.size()).append(" ").
                   append(countedFiles).append("\n");
        }

        System.out.println(root.writer);
    }
}

class Root {
    Directory main = new Directory("main");
    HashMap<String,Directory> directoryList=new HashMap<>();
    StringBuilder writer;

    void init(){
        directoryList.put(main.name,main);
        initWriter();
    }
    void push(StringTokenizer t) {
        String base=t.nextToken();
        String child=t.nextToken();
        int mode=Integer.parseInt(t.nextToken());
        Directory parent;

        if(!directoryList.containsKey(base))
            directoryList.put(base,new Directory(base));

        parent=directoryList.get(base);

        mkdirOrCat(parent, child, mode); // create
    }

    boolean hasDirectoryOrFile(Directory target, String name,int mode) {
        if(mode==1)
            return target.childrenDirectories.containsKey(name);
        else
            return target.filesInDirectory.containsKey(name);
    }

    Directory cd(String name) {
        return directoryList.get(name);
    }

    void mkdirOrCat(Directory target, String name, int mode) {
        if (mode==1 && !hasDirectoryOrFile(target, name, mode)) {
            Directory addr=directoryList.containsKey(name) ? cd(name) : new Directory(name);

            target.childrenDirectories.put(addr.name, addr);
            target.directoryNames.add(name);
            directoryList.put(name,addr);
        }else if(mode==0 && !hasDirectoryOrFile(target, name,mode)){
            target.filesInDirectory.put(name, name);
        }
    }

    void initWriter() {
        this.writer = new StringBuilder();
    }

    String decodingPass(String pass){
        String[] args=pass.split("/");
        return args[args.length-1];
    }
    int getSolution(HashSet<String> detectedFiles, Directory currentDirectory) {
        int count=0;
        if(currentDirectory!=null){
            ArrayList<String> directoryList=currentDirectory.directoryNames;

            for (String next : directoryList)
                count += getSolution(detectedFiles, cd(next));

            detectedFiles.addAll(currentDirectory.filesInDirectory.values());
            count+=currentDirectory.filesInDirectory.size();
        }

        return count;
    }

}

class Directory {
    String name;
    ArrayList<String> directoryNames=new ArrayList<>();
    HashMap<String, Directory> childrenDirectories = new HashMap<>();
    HashMap<String, String> filesInDirectory = new HashMap<>();
    Directory(String s) {
        this.name = s;
    }
}