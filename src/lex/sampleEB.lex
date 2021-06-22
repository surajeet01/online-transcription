import java.lang.System;
import java.io.Reader;
import java.io.PrintWriter;

class TranscriptorEB{
    private static java.io.Reader input_file;
    private String file_name;
    private String uploadFolder;
    
    TranscriptorEB(String file){
    	this.file_name=file;
    	
    	//GET THE PRESENT WORKING DIRECTORY LOCATION i.e. "/var/lib/tomcat7"
    	this.uploadFolder = Paths.get(".").toAbsolutePath().normalize().toString();
    	
    	//THE FILE THAT WILL BE CREATED AFETR TRANSCRIPTION WILL BE 
    	//SAVED INTO THE APPLICATION FOLDER
    	//THAT IS "/var/lib/tomcat7/webapps/test-app"
        this.uploadFolder = uploadFolder + "/webapps/test-app/temp";
    }
   
    
    public void transcript() throws java.io.IOException {
    	
    	//FILE NAME AFTER TRANSCRIPTION WILL BE ORIGINAL FILE NAME WITH 
    	//A PREFIX "new_"
    	String s = this.uploadFolder + "/new_" + this.file_name;        
    	
    	//UPLOADED FILE READ HERE
    	input_file=new java.io.FileReader(this.uploadFolder+"/"+file_name);
        if (input_file==null){
            return;
        }
        
        //NEW FILE CREATED IN THE LOCATION SPECIFIED BY s
        File file =new File(s);
    	if(file.exists())
    		file.delete();
    		
    	file.createNewFile();

    	FileWriter fw = new FileWriter(file,true);
    	BufferedWriter bw = new BufferedWriter(fw);
        
        YylexEB yy = new YylexEB(input_file);
        YytokenEB t;
        while ((t = yy.YylexEB()) != null){
        	bw.write(t.toString());
        }

        bw.close();
    }
}

class YytokenEB {
  private String m_text;
  YytokenEB (String text){
        m_text = new String(text);
  }

  public String toString() {
	return m_text;
  }
}

%%
WHITE_SPACE=[\r|\n|\t|\b|\f|\ |\012]
%%
<YYINITIAL> <[^<]+>  { return (new YytokenEB(yytext())); }
<YYINITIAL> WHITE_SPACE["a"] { return (new YytokenEB("\u0986")); }
<YYINITIAL> WHITE_SPACE["i"] { return (new YytokenEB("\u0987")); }
<YYINITIAL> WHITE_SPACE["u"] { return (new YytokenEB("\u0989")); }
<YYINITIAL> WHITE_SPACE["e"] { return (new YytokenEB("\u098F")); }
<YYINITIAL> WHITE_SPACE["o"] { return (new YytokenEB("\u0993")); }
<YYINITIAL> "kh" { return (new YytokenEB("\u0996")); }
<YYINITIAL> "k"  { return (new YytokenEB("\u0995")); }                    
<YYINITIAL> "gh" { return (new YytokenEB("\u0998")); }             
<YYINITIAL> "g" { return (new YytokenEB("\u0997")); }
<YYINITIAL> "ng" { return (new YytokenEB("\u0999")); }
<YYINITIAL> "n" { return (new YytokenEB("\u09A8")); }
<YYINITIAL> "chh" { return (new YytokenEB("\u099B")); }
<YYINITIAL> "ch" { return (new YytokenEB("\u099A")); }
<YYINITIAL> "jh" { return (new YytokenEB("\u099D")); }
<YYINITIAL> "j" { return (new YytokenEB("\u099C")); }
<YYINITIAL> "th" { return (new YytokenEB("\u09A5")); }
<YYINITIAL> "t" { return (new YytokenEB("\u09A4")); }
<YYINITIAL> "dh" { return (new YytokenEB("\u09A7")); }
<YYINITIAL> "d" { return (new YytokenEB("\u09A6")); }
<YYINITIAL> "ph" { return (new YytokenEB("\u09AB")); }
<YYINITIAL> "f" { return (new YytokenEB("\u09AB")); }
<YYINITIAL> "p" { return (new YytokenEB("\u09AA")); }
<YYINITIAL> "bh" { return (new YytokenEB("\u09AD")); }
<YYINITIAL> "v" { return (new YytokenEB("\u09AD")); }
<YYINITIAL> "b" { return (new YytokenEB("\u09AC")); }
<YYINITIAL> "m" { return (new YytokenEB("\u09AE")); }
<YYINITIAL> "r" { return (new YytokenEB("\u09B0")); }
<YYINITIAL> "f" { return (new YytokenEB("\u09AB")); }
<YYINITIAL> "l" { return (new YytokenEB("\u09B2")); }
<YYINITIAL> "sh" { return (new YytokenEB("\u09B6")); }
<YYINITIAL> "s" { return (new YytokenEB("\u09B8")); }
<YYINITIAL> "h" { return (new YytokenEB("\u09B9")); }
<YYINITIAL> "y" { return (new YytokenEB("\u09DF")); }
<YYINITIAL> "a" { return (new YytokenEB("\u09BE")); }
<YYINITIAL> "i" { return (new YytokenEB("\u09BF")); }
<YYINITIAL> "u" { return (new YytokenEB("\u09C1")); }
<YYINITIAL> "e" { return (new YytokenEB("\u09C7")); }
<YYINITIAL> "oi" { return (new YytokenEB("\u09C8")); }
<YYINITIAL> "ou" { return (new YytokenEB("\u09CC")); }
<YYINITIAL> "o" { return (new YytokenEB("\u09CB")); }
<YYINITIAL> {WHITE_SPACE}+ {return (new YytokenEB(yytext()));}
<YYINITIAL> . { return (new YytokenEB(yytext())); }
