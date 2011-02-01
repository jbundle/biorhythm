package org.jbundle.biorhythm.util;

/**
 * Copyright (c) 1996 jbundle.org. All Rights Reserved.
 *  Copy freely, but don't sell this program or remove this copyright notice.
 *      Don_Corley@msn.com
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * BioConvert - This is a utility to convert Unicode to regular text.
 * I can't figure out how to compile a unicode (UTF-16) file, so this program
 * converts the UTF-16 to UTF-8 by changing the Unicode characters to \ (ie., \u1232)
 */
public class BioConvert extends Object {

    /**
     * This LAME program converts Unicode text to regular text with \
     */
    public static void main (String[] args)
    {
        try {
        String string = "//jws/bio/com/juggie/bio/BioResource_ru.unicode.java";
        if ((args != null) && (args.length > 0))
            string = (String)args[0];
        else
        {
            System.out.println("The first argument must be a unicode file to convert to .java");
            System.exit(0);
        }
        FileInputStream fileIn = new FileInputStream(string);
        byte[] cbuf = new byte[32768];
        int off = 0;
        int len = 32768;
        int iResult = fileIn.read(cbuf, off, len);
        
        String strOut = "";
        boolean bInQuote = false;
        boolean bHigh = true;
        char charHigh = 0;
        iResult = iResult / 2 * 2;
        for (int i = 2; i < iResult; i++)
        {
            if (bHigh)
            {
                charHigh = (char)cbuf[i];

                if (cbuf[i+1] == 0)
                {
                    if (charHigh == '\"')
                        bInQuote = !bInQuote;
                    strOut += charHigh;
                }
                else
                {   // Unicode char
                    if (bInQuote)
                    {
                        String strHex = "0123456789ABCDEF";
                        strOut += "\\u";
                        strOut += strHex.charAt((cbuf[i+1] & 0xF0) >> 4);
                        strOut += strHex.charAt(cbuf[i+1] & 0xF);
                        strOut += strHex.charAt((cbuf[i] & 0xF0) >> 4);
                        strOut += strHex.charAt(cbuf[i] & 0xF);
                    }
                    else
                    {
                        System.out.println("Error - unicode outside quotes");
                    }
                }
            }
            bHigh = !bHigh;
        }
        
        int iIndex = string.indexOf(".unicode");
        if (iIndex != -1)
            string = string.substring(0, iIndex) + string.substring(iIndex + 8, string.length());
        if (args != null) if (args.length > 1)
            string = (String)args[1];
        FileOutputStream fileOut = new FileOutputStream(string);
        OutputStreamWriter dataOut = new OutputStreamWriter(fileOut);
        dataOut.write(strOut, off, strOut.length());
        dataOut.close();
        fileOut.close();
        } catch (IOException ex)    {
            ex.printStackTrace();
        }
    }

}
