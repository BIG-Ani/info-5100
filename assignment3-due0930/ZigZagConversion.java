class ZigZagConversion{

	public String convert(String s, int numRows) {
        	if(s == null || s.length() == 0 || numRows <= 0)
           	 return s;
        
        	StringBuilder[] zigMaps = new StringBuilder[numRows];
       		 for(int i = 0; i < numRows; i++)
            		zigMaps[i] = new StringBuilder();
        
        	int i = 0;
        	while(i < s.length()){
            		for(int ind = 0; ind < numRows && i < s.length(); ind++)
                		zigMaps[ind].append(s.charAt(i++));
            
            		for(int ind = numRows - 2; ind >= 1 && i < s.length(); ind--)
                		zigMaps[ind].append(s.charAt(i++));
        	}
        
        	for(i = 1; i < numRows; i++){
           		zigMaps[0].append(zigMaps[i]);
        	}
        
        	return zigMaps[0].toString();
   	}

	public static void main(String[] args){
		ZigZagConversion zigConvert = new ZigZagConversion();

		System.out.println(zigConvert.convert("PAYPALISHIRING", 3));
	}

}