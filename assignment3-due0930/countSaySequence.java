class countSaySequence{

	public String countAndSay(int n){
		if(n == 1)
            		return "1";
        	else if(n == 2)
	            return "11";
        	else{
	            String base = "11";
            
        	    for(int i = 0; i < n - 2; i++){
                	int count = 0;
                
	                int l = 0, r = 0, len = base.length();
        	        String temp = "";
                	while(l < len){
                        
	                    while(r < len && base.charAt(l) == base.charAt(r)){
        	                count++;
                	        r++;
	                     }
                    
        	            temp += String.valueOf(count) + base.charAt(l);
                	    l = r;
	                    count = 0;
        	        }
                	
			base = temp;
           	    }
            	
		     return base;
        	}
	}
	
	public static void main(String[] args){

		countSaySequence countAndSaySequence = new countSaySequence();

		System.out.println(countAndSaySequence. countAndSay(5));
	}

}