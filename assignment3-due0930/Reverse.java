class Reverse{

	public String reverseWords(String str){
		if(str == null || str.length() == 0)
			return str;
	
		String[] strArr = str.split(" ");
		
		String res = "";
		for(int i = strArr.length - 1; i >= 0; i--){
			if(i == 0){
				res += strArr[i];
			}else{
				res += strArr[i] + " ";
			}
		}
		
		return res;
	}

	public static void main(String[] args){
		Reverse reverse = new Reverse();
		System.out.println(reverse.reverseWords("the sky is blue"));
	} 

}