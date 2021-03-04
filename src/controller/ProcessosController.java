package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ProcessosController {
	
	public ProcessosController() {
		super();
	}
	
	public String so() {
		String so = System.getProperty("os.name");
		return so;
	}
	
	public void listarProcesso(String nomeSO) {		
		if (nomeSO.contains("Windows")) {
			try {
				Process p = Runtime.getRuntime().exec("TASKLIST /FO TABLE");
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				
				while (linha != null) {
					System.out.println(linha);
					linha = buffer.readLine();
				}
				
				buffer.close();
				leitor.close();
				fluxo.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else {
			try {
				Process p = Runtime.getRuntime().exec("ps -ef");
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				
				while (linha != null) {
					System.out.println(linha);
					linha = buffer.readLine();
				}
				
				buffer.close();
				leitor.close();
				fluxo.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}		
	}
	
	public void killPid(String nomeSO, int pid) {
		StringBuffer buffer = new StringBuffer();
		
		if (nomeSO.contains("Windows")) {
			try {
				buffer.append("TASKKILL /PID ");
				buffer.append(pid);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			try {
				Runtime.getRuntime().exec(buffer.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} else {
			try {
				buffer.append("kill -9 ");
				buffer.append(pid);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			try {
				Runtime.getRuntime().exec(buffer.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public void killName(String nomeSO, String nome) {
		StringBuffer buffer = new StringBuffer();
		
		if (nomeSO.contains("Windows")) {
			try {
				buffer.append("TASKKILL /IM ");
				buffer.append(nome);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				Runtime.getRuntime().exec(buffer.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} else {
			try {
				buffer.append("pkill -f ");
				buffer.append(nome);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				Runtime.getRuntime().exec(buffer.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
			
}