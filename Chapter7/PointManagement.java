import java.util.*;

public class PointManagement {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		HashMap<String, Integer> map = new HashMap<>();
		String name;
		int point;
		System.out.println("** 포인트 관리 프로그램입니다 **");
		while(true) {
			System.out.print("이름과 포인트 입력 >> ");
			name = s.next();
			if(name.equals("그만")) {
				s.close();
				return;
			}
			point = s.nextInt();
			if(map.size()>0) {
				if(map.containsKey(name))
				{
					map.put(name, point + map.get(name));
				}
				else map.put(name, point);
			}
			else map.put(name, point);
			
			Set<String> keys = map.keySet();
			Iterator<String> it = keys.iterator();
			while(it.hasNext()) {
				String key = it.next();
				int value = map.get(key);
				System.out.print("("+key+","+value+")");
			}
			System.out.println();
		}
	}
}
