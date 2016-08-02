package cn.wlmb.css.socket;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

public class WebSocketTools {
	//private static CopyOnWriteArraySet<CustomerWebSocket> webSocketSet = new CopyOnWriteArraySet<CustomerWebSocket>();
	//储存客户交换信息的map
	private static HashMap<String, ConnectCustomerWebSocket> connectCustomerMap = new HashMap<>();
	//储存客服交换信息的map
	private static HashMap<String, ConnectServerWebSocket> connectServerMap = new HashMap<>();
	

	public static HashMap<String, ConnectCustomerWebSocket> getConnectCustomerMap() {
		return connectCustomerMap;
	}

	public static void setConnectCustomerMap(String id, ConnectCustomerWebSocket socket) {
		connectCustomerMap.put(id, socket);
	}

	public static HashMap<String, ConnectServerWebSocket> getConnectServerMap() {
		return connectServerMap;
	}

	public static void setConnectServerMap(String id, ConnectServerWebSocket socket) {
		connectServerMap.put(id, socket);
	}
	
	public static boolean saveFileFromBytes(byte[] b, String outputFile)  
    {  
      BufferedOutputStream stream = null;  
      File file = null;  
      try  
      {  
        file = new File(outputFile);  
        FileOutputStream fstream = new FileOutputStream(file);  
        stream = new BufferedOutputStream(fstream);  
        stream.write(b);  
      }  
      catch (Exception e)  
      {  
        e.printStackTrace();
        return false;
      }  
      finally  
      {  
        if (stream != null)  
        {  
          try  
          {  
            stream.close();  
          }  
          catch (IOException e1)  
          {  
            e1.printStackTrace();  
          }  
        }  
      }  
      return true;  
    }

}
