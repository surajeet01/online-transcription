import java.lang.System;
import java.io.Reader;
import java.io.PrintWriter;

class TranscriptorBE{
    private static java.io.Reader input_file;
    private String file_name;
    private String uploadFolder;
    
    TranscriptorBE(String file){
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
        
        YylexBE yy = new YylexBE(input_file);
        YytokenBE t;
        while ((t = yy.YylexBE()) != null){
        	bw.write(t.toString());
        }

        bw.close();
    }
}

class YytokenBE {
  private String m_text;
  YytokenBE (String text){
        m_text = new String(text);
  }

  public String toString() {
	return m_text;
  }
}

%%
WHITE_SPACE=[\r|\n|\t|\b|\f|\ |\012]
%%
<YYINITIAL> {WHITE_SPACE}+ {return (new YytokenBE(yytext()));}
<YYINITIAL> "\u0995" { return (new YytokenBE("k"));}
<YYINITIAL> "\u0996" { return (new YytokenBE("kh"));}                    
<YYINITIAL> "\u0997" { return (new YytokenBE("g")); }             
<YYINITIAL> "\u0998" { return (new YytokenBE("gh")); }
<YYINITIAL> "\u0999" { return (new YytokenBE("ng")); }
<YYINITIAL> "\u099A" { return (new YytokenBE("ch")); }
<YYINITIAL> "\u099B" { return (new YytokenBE("chh")); }
<YYINITIAL> "\u099C" { return (new YytokenBE("j")); }
<YYINITIAL> "\u099D" { return (new YytokenBE("jh")); }
<YYINITIAL> "\u099E" { return (new YytokenBE("ng")); }
<YYINITIAL> "\u099F" { return (new YytokenBE("t")); }
<YYINITIAL> "\u09A0" { return (new YytokenBE("th")); }
<YYINITIAL> "\u09A1" { return (new YytokenBE("d")); }
<YYINITIAL> "\u09A2" { return (new YytokenBE("dh")); }
<YYINITIAL> "\u09A3" { return (new YytokenBE("n")); }
<YYINITIAL> "\u09A4" { return (new YytokenBE("t")); }
<YYINITIAL> "\u09A5" { return (new YytokenBE("th")); }
<YYINITIAL> "\u09A6" { return (new YytokenBE("d")); }
<YYINITIAL> "\u09A7" { return (new YytokenBE("dh")); }
<YYINITIAL> "\u09A8" { return (new YytokenBE("n")); }
<YYINITIAL> "\u09AA" { return (new YytokenBE("p")); }
<YYINITIAL> "\u09AB" { return (new YytokenBE("ph")); }
<YYINITIAL> "\u09AC" { return (new YytokenBE("b")); }
<YYINITIAL> "\u09AD" { return (new YytokenBE("v")); }
<YYINITIAL> "\u09AE" { return (new YytokenBE("m")); }
<YYINITIAL> "\u09AF" { return (new YytokenBE("j")); }
<YYINITIAL> "\u09B0" { return (new YytokenBE("r")); }
<YYINITIAL> "\u09B2" { return (new YytokenBE("l")); }
<YYINITIAL> "\u09B6" { return (new YytokenBE("sh")); }
<YYINITIAL> "\u09B7" { return (new YytokenBE("sh")); }
<YYINITIAL> "\u09B8" { return (new YytokenBE("s")); }
<YYINITIAL> "\u09B9" { return (new YytokenBE("h")); }
<YYINITIAL> "\u09DC" { return (new YytokenBE("r")); }
<YYINITIAL> "\u09DD" { return (new YytokenBE("r")); }
<YYINITIAL> "\u09DF" { return (new YytokenBE("y")); }
<YYINITIAL> "\u09CE" { return (new YytokenBE("t")); }
<YYINITIAL> "\u0982" { return (new YytokenBE("ng")); }
<YYINITIAL> "\u0983" { return (new YytokenBE(":")); }
<YYINITIAL> "\u0981" { return (new YytokenBE("n")); }
<YYINITIAL> "\u0981" { return (new YytokenBE("n")); }
<YYINITIAL> "\u09BE" { return (new YytokenBE("aa")); }
<YYINITIAL> "\u09BF" { return (new YytokenBE("i")); }
<YYINITIAL> "\u09C0" { return (new YytokenBE("i")); }
<YYINITIAL> "\u09C1" { return (new YytokenBE("u")); }
<YYINITIAL> "\u09C2" { return (new YytokenBE("u")); }
<YYINITIAL> "\u09C7" { return (new YytokenBE("e")); }
<YYINITIAL> "\u09C8" { return (new YytokenBE("oi")); }
<YYINITIAL> "\u09CB" { return (new YytokenBE("o")); }
<YYINITIAL> "\u09CC" { return (new YytokenBE("ou")); }
<YYINITIAL> "\u0985" { return (new YytokenBE("a")); }
<YYINITIAL> "\u0986" { return (new YytokenBE("A")); }
<YYINITIAL> "\u0987" { return (new YytokenBE("i")); }
<YYINITIAL> "\u0988" { return (new YytokenBE("i")); }
<YYINITIAL> "\u0989" { return (new YytokenBE("u")); }
<YYINITIAL> "\u098A" { return (new YytokenBE("u")); }
<YYINITIAL> "\u098F" { return (new YytokenBE("e")); }
<YYINITIAL> "\u0990" { return (new YytokenBE("oi")); }
<YYINITIAL> "\u0993" { return (new YytokenBE("o")); }
<YYINITIAL> "\u0994" { return (new YytokenBE("ou")); }
<YYINITIAL> . { return (new YytokenBE(yytext())); }
