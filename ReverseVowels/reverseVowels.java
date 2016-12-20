public class reverseVowels{
	public static void main (String[] args){
		reverseVowels sol = new reverseVowels();
		String ans = sol.reverse("Hello");
		System.out.println(ans);
	}
	
	public String reverse(String value){
		String vowels = "aeiouAEIOU";
		char[] array = value.toCharArray();
		int start = 0;
		int end = value.length() - 1;
		while( start < end ){
			while( start < end && !vowels.contains(array[start] + "")) start++;
			while( start < end && !vowels.contains(array[end] + "")) end--;
			char temp = array[start];
			array[start] = array[end];
			array[end] = temp;
			start++;
			end--;
		}
		return new String(array);
	}
}