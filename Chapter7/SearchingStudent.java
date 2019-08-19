import java.util.*;

class Student{
	String name, department, id, avg;
	public Student(String name, String department, String id, String avg) {
		this.name = name;
		this.department = department;
		this.id = id;
		this.avg = avg;
	}
	public void show() {
		System.out.println("이름 :" + name +"\n학과:"+department+"\n학번:"+id+"\n학점평균"+avg);
		System.out.println("--------------------------------------");
	}
	public String getName() {
		return name;
	}
	
	public String toString() {
		return (name+", " + department+", "+id + ", " + avg);
	}
}
public class SearchingStudent {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input;
		StringTokenizer st;
		ArrayList<Student> al = new ArrayList<>();
		System.out.println("학생 이름, 학과, 학번, 학점 평균 입력하세요");
		for(int i = 0; i < 4; i++) {
			System.out.print(">> ");
			input = s.nextLine();
			st = new StringTokenizer(input, ", ");
			al.add((new Student(st.nextToken(), st.nextToken(), st.nextToken(),st.nextToken())));
		}
		Iterator<Student> it =al.iterator();
		System.out.println("--------------------------------------");
		while(it.hasNext())
		{
			it.next().show();
		}
		while(true){
			System.out.print("학생 이름 >> ");
			input = s.nextLine();
			if(input.equals("그만")) {
				s.close();
				return;
			}
			for(int i = 0; i < al.size(); i++)
			{
				Student sd = al.get(i);
				if(input.equals(sd.getName())) System.out.println(sd);
			}
		}
	}
}
