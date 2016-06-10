
package ludoreloded;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.print.attribute.HashAttributeSet;
import util.ConectionUtillities;

/**
 *
 * @author uesr
 */
public class Server {
    
    public ServerSocket servSocket;
    HashMap<String,Information> clientList;
    
    public Server(int port){
        
        clientList=new HashMap<String, Information>();
        
        try {
            servSocket=new ServerSocket(port);
            
            while(true){
                //printHashMap();
                Socket clientSocket=servSocket.accept();
                ConectionUtillities connection=new ConectionUtillities(clientSocket);
                new Thread(new CreateClientConnection(clientList,connection)).start();                
            }
            
             
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        
    }
    
    public void printHashMap(){
        
        Set set = clientList.entrySet();
      
        Iterator i = set.iterator();      
        System.out.println("Current User--");
        while(i.hasNext()) {
           Map.Entry me = (Map.Entry)i.next();
           System.out.println(me.getKey() + " : ");                   
        }
    
        
    }
    
    
    public static void main(String[] args) {
        new Server(6789);
    }
}
