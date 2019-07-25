abstract class PairMap{
	protected String keyArray[];
	protected String valueArray[];
	abstract String get(String key);
	abstract void put(String key, String value);
	
	abstract String delete(String key);
	
	abstract int length();
}

class Dictionary extends PairMap{
	private int size, length;
	public Dictionary(int size) {
		this.size = size;
		keyArray = new String[10];
		valueArray = new String[10];
		
		for(int i =0; i<size; i++) {
			keyArray[i] = new String();
			keyArray[i] = "null";
			valueArray[i] = new String();
			valueArray[i] = "null";
		}
	}
	public String get(String key) {
		length();
		for(int i =0; i<length; i++)
		{
			if(keyArray[i].equals(key)) return valueArray[i];
		}
		return "불러올 value 값이 없습니다.";
	}
	
	public void put(String key, String value) {
		length();
		boolean already = false;
		int index = 0;
		for(int i =0; i<length; i++)
		{
			if(keyArray[i].equals(key)) { already = true; index = i; break;}
		}
		if(!already)
		{
			if(length == size) System.out.println("사전이 꽉 차서 추가 불가!");
			else keyArray[length] = key; valueArray[length] = value;
		}
		else valueArray[index] = value;
			
	}
	
	public String delete(String key) {
		length();
		for(int i =0; i<length; i++)
		{
			if(keyArray[i].equals(key)) {
				valueArray[i] = "null";
				return valueArray[i];
			}
		}
		return "삭제할 key 값이 없습니다.";
	}
	public int length() {
		length = 0;
		for(int i =0; i<size; i++) {
			if(!keyArray[i].equals("null")) length++;
		}
		return length;
	}
}
public class DictApplication {
	public static void main(String[] args) {
		Dictionary dic = new Dictionary(10);
		dic.put("황기태", "자바");
		dic.put("이재문", "파이선");
		dic.put("이재문", "C++");
		System.out.println("이재문의 값은 " + dic.get("이재문"));
		System.out.println("황기태의 값은 " + dic.get("황기태"));
		dic.delete("황기태");
		System.out.println("황기태의 값은 " + dic.get("황기태"));
		
	}

}
