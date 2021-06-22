package testPackage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Paths;
import java.lang.System;

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


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 5/6/15 3:40 PM from the specification file
 * <tt>sampleEB.lex</tt>
 */
class YylexEB {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\10\0\2\1\1\1\1\0\2\1\22\0\1\1\33\0\1\2\1\0"+
    "\1\3\2\0\1\14\1\0\1\15\1\0\1\10\2\0\1\5\1\6"+
    "\6\0\1\13\2\0\1\12\1\7\2\0\1\4\7\0\1\11\1\0"+
    "\1\16\1\35\1\27\1\32\1\21\1\34\1\25\1\24\1\17\1\30"+
    "\1\23\1\41\1\37\1\26\1\22\1\33\1\0\1\40\1\42\1\31"+
    "\1\20\1\36\2\0\1\43\2\0\1\1\uff83\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\4\1\1\2\1\3\1\4\1\5\1\6\1\7"+
    "\1\10\1\11\1\12\1\1\1\13\1\14\1\15\1\16"+
    "\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26"+
    "\2\0\1\27\1\30\1\31\1\32\1\33\1\34\1\35"+
    "\1\36\1\37\1\40\1\1\1\0\1\41\10\0\1\42"+
    "\1\43\1\44\1\45\1\46";

  private static int [] zzUnpackAction() {
    int [] result = new int[55];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\44\0\110\0\154\0\220\0\44\0\44\0\44"+
    "\0\44\0\264\0\330\0\44\0\374\0\u0120\0\u0144\0\u0168"+
    "\0\u018c\0\u01b0\0\u01d4\0\44\0\u01f8\0\44\0\44\0\44"+
    "\0\44\0\u021c\0\44\0\u0240\0\u0264\0\44\0\44\0\44"+
    "\0\44\0\44\0\u0288\0\44\0\44\0\44\0\44\0\u0240"+
    "\0\u02ac\0\44\0\u02d0\0\u02f4\0\u0318\0\u033c\0\u0360\0\u0384"+
    "\0\u03a8\0\u03cc\0\44\0\44\0\44\0\44\0\44";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[55];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\2\1\5\11\2\1\6\1\7"+
    "\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17"+
    "\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27"+
    "\1\30\1\31\1\32\1\33\45\0\1\3\42\0\2\34"+
    "\1\0\41\34\5\0\1\35\55\0\1\36\1\37\47\0"+
    "\1\40\43\0\1\41\44\0\1\42\42\0\1\43\43\0"+
    "\1\44\43\0\1\45\43\0\1\46\43\0\1\24\43\0"+
    "\1\26\43\0\1\47\17\0\2\34\1\0\1\50\40\34"+
    "\6\0\1\51\61\0\1\52\26\0\1\53\44\0\1\54"+
    "\44\0\1\55\44\0\1\56\44\0\1\57\44\0\1\60"+
    "\44\0\1\61\36\0\1\62\51\0\1\63\1\64\1\65"+
    "\1\66\1\67\21\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[1008];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\3\1\4\11\2\1\1\11\7\1\1\11"+
    "\1\1\4\11\1\1\1\11\2\0\5\11\1\1\4\11"+
    "\1\1\1\0\1\11\10\0\5\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[55];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  YylexEB(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  YylexEB(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 114) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public YytokenEB YylexEB() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 16: 
          { return (new YytokenEB("\u09AC"));
          }
        case 39: break;
        case 10: 
          { return (new YytokenEB("\u09A8"));
          }
        case 40: break;
        case 24: 
          { return (new YytokenEB("\u09CC"));
          }
        case 41: break;
        case 23: 
          { return (new YytokenEB("\u09C8"));
          }
        case 42: break;
        case 32: 
          { return (new YytokenEB("\u09B6"));
          }
        case 43: break;
        case 36: 
          { return (new YytokenEB("\u0989"));
          }
        case 44: break;
        case 12: 
          { return (new YytokenEB("\u09A4"));
          }
        case 45: break;
        case 33: 
          { return (new YytokenEB("\u099B"));
          }
        case 46: break;
        case 9: 
          { return (new YytokenEB("\u0997"));
          }
        case 47: break;
        case 20: 
          { return (new YytokenEB("\u09B2"));
          }
        case 48: break;
        case 38: 
          { return (new YytokenEB("\u0993"));
          }
        case 49: break;
        case 8: 
          { return (new YytokenEB("\u09B9"));
          }
        case 50: break;
        case 15: 
          { return (new YytokenEB("\u09AB"));
          }
        case 51: break;
        case 31: 
          { return (new YytokenEB("\u09A7"));
          }
        case 52: break;
        case 6: 
          { return (new YytokenEB("\u09CB"));
          }
        case 53: break;
        case 5: 
          { return (new YytokenEB("\u09C7"));
          }
        case 54: break;
        case 28: 
          { return (new YytokenEB("\u099A"));
          }
        case 55: break;
        case 25: 
          { return (new YytokenEB("\u0996"));
          }
        case 56: break;
        case 18: 
          { return (new YytokenEB("\u09AE"));
          }
        case 57: break;
        case 1: 
          { return (new YytokenEB(yytext()));
          }
        case 58: break;
        case 21: 
          { return (new YytokenEB("\u09B8"));
          }
        case 59: break;
        case 37: 
          { return (new YytokenEB("\u098F"));
          }
        case 60: break;
        case 14: 
          { return (new YytokenEB("\u09AA"));
          }
        case 61: break;
        case 13: 
          { return (new YytokenEB("\u09A6"));
          }
        case 62: break;
        case 29: 
          { return (new YytokenEB("\u099D"));
          }
        case 63: break;
        case 27: 
          { return (new YytokenEB("\u0999"));
          }
        case 64: break;
        case 35: 
          { return (new YytokenEB("\u0987"));
          }
        case 65: break;
        case 3: 
          { return (new YytokenEB("\u09BF"));
          }
        case 66: break;
        case 7: 
          { return (new YytokenEB("\u0995"));
          }
        case 67: break;
        case 19: 
          { return (new YytokenEB("\u09B0"));
          }
        case 68: break;
        case 22: 
          { return (new YytokenEB("\u09DF"));
          }
        case 69: break;
        case 17: 
          { return (new YytokenEB("\u09AD"));
          }
        case 70: break;
        case 30: 
          { return (new YytokenEB("\u09A5"));
          }
        case 71: break;
        case 11: 
          { return (new YytokenEB("\u099C"));
          }
        case 72: break;
        case 26: 
          { return (new YytokenEB("\u0998"));
          }
        case 73: break;
        case 34: 
          { return (new YytokenEB("\u0986"));
          }
        case 74: break;
        case 4: 
          { return (new YytokenEB("\u09C1"));
          }
        case 75: break;
        case 2: 
          { return (new YytokenEB("\u09BE"));
          }
        case 76: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            return null;
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }
}
