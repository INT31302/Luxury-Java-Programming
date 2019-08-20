import java.util.*;

class Location{
	String city;
	int lon,lat;
	public Location(String city, int lon, int lat){
		this.city = city;
		this.lon = lon;
		this.lat = lat;
	}
	public void show() {
		System.out.println(city +"\t" + lon + "\t"+lat);
	}
}
public class _6 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		HashMap<String, Location> map = new HashMap<>();
		String input, city;
		int lon, lat;
		StringTokenizer st;
		System.out.println("도시,경도,위도를 입력하세요.");
		for(int i = 0; i<4; i++) {
			System.out.print(">> ");
			input = s.nextLine();
			st = new StringTokenizer(input,", ");
			city = st.nextToken();
			lon = Integer.parseInt(st.nextToken());
			lat = Integer.parseInt(st.nextToken());
			map.put(city, new Location(city,lon,lat));
		}
		System.out.println("----------------------------------");
		Set<String> keys = map.keySet();
		Iterator<String> it = keys.iterator();
		while(it.hasNext()) {
			String key = it.next();
			Location l = map.get(key);
			l.show();
		}
		System.out.println("----------------------------------");
		while(true) {
			System.out.print("도시 이름 >> ");
			input = s.next();
			if(input.equals("그만")) {
				s.close();
				return;
			}
			if(map.containsKey(input)) {
				map.get(input).show();
			}
			else System.out.println(input+"는 없습니다.");
		}
	}
}
