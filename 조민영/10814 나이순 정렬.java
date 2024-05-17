import java.io.*;
import java.util.*;

class Student implements Comparable<Student>{
	int age, num;
	String name;

	public Student(int a, String b, int c){
		this.age = a;
		this.name = b;
		this.num = c;
	}

	@Override
	public int compareTo(Student student){
		if ( this.age == student.age )
			return this.num - student.num;
		return this.age - student.age;
	}
}
public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		Student[] students = new Student[n];

		for ( int i = 0 ; i < n ; i++ ){
			StringTokenizer str = new StringTokenizer(br.readLine());
			students[i] = new Student(Integer.parseInt(str.nextToken()), str.nextToken(), i+1);
		}

		Arrays.sort(students);

		for ( int i = 0 ; i < n ; i++ )
			System.out.println(students[i].age + " " + students[i].name);
    }
}