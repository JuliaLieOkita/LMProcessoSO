package view;

import controller.ProcessosController;
import javax.swing.JOptionPane;

public class Main {
	
	public static void main(String[] args) {
		
		ProcessosController processosController = new ProcessosController();
		
		int opc = 9;
		
		do {
			opc = Integer.parseInt(JOptionPane.showInputDialog("1 - Processos Ativos\n2 - Matar Processo (PID)\n3 - Matar Processo (Nome)\n9 - Encerrar Programa"));
			
			switch (opc) {
			case 1: processosController.listarProcesso(processosController.so());
				break;
			case 2: processosController.killPid(processosController.so(), Integer.parseInt(JOptionPane.showInputDialog("Digite o PID para matar o processo: ")));
				break;
			case 3: processosController.killName(processosController.so(), JOptionPane.showInputDialog("Digite o nome para matar o processo:  "));
				break;
			}
		} while (opc != 9);

	}
}