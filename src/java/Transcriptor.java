package testPackage;

class Transcriptor{
	private String fileName;
	private String inputLang;
	
	Transcriptor(String f,String i){
		fileName = f;
		inputLang = i;
	};
	
	public void transcript(){
		if(inputLang.equals("Bengali")){
			System.out.println(inputLang);
			System.out.println(fileName);
		
			TranscriptorBE t = new TranscriptorBE(fileName);  
	        try{
	        	//trancript the file, take a look on Transcriptor object for further details 
	    		t.transcript();
	    	}catch(Exception e){
	    		//throw new ServletException(e);
	    	}
		}else{
			System.out.println(inputLang);
			System.out.println(fileName);
			TranscriptorEB t = new TranscriptorEB(fileName);  
	        try{
	        	//trancript the file, take a look on Transcriptor object for further details 
	    		t.transcript();
	    	}catch(Exception e){
	    		//throw new ServletException(e);
	    	}
		}
	}
}