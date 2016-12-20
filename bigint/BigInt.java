class BigInt{
	String number;

	public static void main(string[] args){
		number = 123;
		BigInt sol = new BigInt();
		Stirng answer = sol.addBigInt(7);
		System.out.println(answer);
	}

	public BigInt(String number){ 
		this.number = number;
	}
	public String addBigInt(String toAdd){
		int len1  = number.length();
		int len2 = toAdd.length();
		while( len1 >= 0 && len2 >= 0 )
			int carry = 0;
			int number1 = Integer.parseInt(number.charAt(len1));
			int number2 = Integer.parseInt(toAdd.charAt(len2));
			res = (number1 + number2 + carry) % 10;
			carry = (number1 + number2 + carry) / 10;
			len1--;
			len2--;
	} 
}