/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validate;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument ;
import javax.swing.text.AttributeSet ; 
/**
 *
 * @author NESTORPC
 */
public class JustUpperCase extends PlainDocument{
 
@Override
public void insertString (int offset , String str ,AttributeSet atrr)throws BadLocationException{

super.insertString(offset, str.toUpperCase(), atrr);

}

}
