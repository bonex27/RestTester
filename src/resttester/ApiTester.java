/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resttester;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author informatica
 */


public class ApiTester {
    
    
    private  String HttpConnect(String args,String methods) {

	  try {

		URL url = new URL(args);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod(methods);
		conn.setRequestProperty("Accept", "application/json");

		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(
			(conn.getInputStream())));

		String output;
		System.out.println("Eseguito\n");
		while ((output = br.readLine()) != null) {
			return output;
		}

		conn.disconnect();

	  } catch (MalformedURLException e) {

		e.printStackTrace();

	  } catch (IOException e) {

		e.printStackTrace();

	  }
          return "Error";

	}


    public String getEmploye(){
        return  this.HttpConnect("http://localhost:8080/api/tutorial/1.0/employees","GET");
    }
    
    public String PostEmploye(String data) throws IOException{
        
        return  this.postConnect("http://localhost:8080/api/tutorial/1.0/employees",data,"POST");
    }
    private String postConnect(String urlApi,String input,String Methods) throws IOException
    {
        URL url = new URL(urlApi);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
           
             conn.setRequestMethod(Methods);
            conn.setRequestProperty("Content-Type", "application/json");

            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();

            if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
                    throw new RuntimeException("Failed : HTTP error code : "
                            + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                            (conn.getInputStream())));

            String output;
            System.out.println("Eseguito!\n");
            while ((output = br.readLine()) != null) {
                    System.out.println(output);
            }

            conn.disconnect();
        return null;

	  } 

    public String DelEmploye(String Data)
    {
        return  this.HttpConnect("http://localhost:8080/api/tutorial/1.0/employees/"+Data,"DELETE");
    }
    public String GetEmployeId(String Data)
    {
        return  this.HttpConnect("http://localhost:8080/api/tutorial/1.0/employees/"+Data,"GET");
    }
    public String PutEmploye(String nPatch,String Data) throws IOException
    {
        return  this.postConnect("http://localhost:8080/api/tutorial/1.0/employees/"+nPatch,Data,"PUT");
    }
    
}
