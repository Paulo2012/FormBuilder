package form_builder;

import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

public class XJtable extends JPanel
{
	
	JTable tabla;
   public XJtable(String[] columnas,int alto, int ancho,int cantidad_filas)
   {
	   
	   this.init(columnas,alto,ancho,cantidad_filas);
   }
   
   
   public JTable get_componente()
   {
		return tabla;	
			
	}
    
   
   
   public void init(String[] columnas,int alto, int ancho,int cantidad_filas){
	   DefaultTableModel dtm = new DefaultTableModel(columnas,cantidad_filas );
	   tabla = new JTable(dtm);
	   
	   
	   
	   
	   JScrollPane scrollPane = new JScrollPane(tabla);
	   scrollPane.setVerticalScrollBarPolicy(
	   JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
       scrollPane.setPreferredSize(new Dimension(alto, ancho));
       add(scrollPane);
       
     
	         
   }
   
   
   
   
}
