package sei;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class EXE_Leitura {
	
	private static PrintWriter LOG = null;

	public static void main(String[] args) throws Exception {
		LOG = new PrintWriter("C:/tmp/log.txt");
		List<String> todasLinhas = linhasFromArquivo();
//		List<String> todasLinhas = linhasFromInternet();
		int tamanhoTotal = todasLinhas.size();
		for (String linha : todasLinhas) {
			System.out.println(tamanhoTotal-- + "->" + linha);
			leitura(linha);
		}
	}

	protected static List<String> linhasFromInternet() {
		ArrayList<String> todasLinhas = new ArrayList<String>();
		todasLinhas.add("linha da URL");
		return todasLinhas;
	}

	public static List<String> linhasFromArquivo() throws Exception {
		ArrayList<String> todasLinhas = new ArrayList<String>();
		BufferedReader reader = new BufferedReader(new FileReader("c:/tmp/processosei _ Dontpad.html"));
		String linha = reader.readLine();
		while (linha != null) {
			todasLinhas.add(linha);
			linha = reader.readLine();
		}

		reader.close();
		return todasLinhas;
	}

	public static void leitura(String url) {
		LOG.println("##########################################################");
		LOG.println("start - " + url);
		try {
			System.out.println(url);
			URL oracle = new URL(url);
			BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));

			String inputLine = in.readLine();
			while (inputLine != null) {
				System.out.println(inputLine);
				LOG.println(inputLine);
				inputLine = in.readLine();
				
			}
			in.close();
		} catch (Exception erro) {
			erro.printStackTrace(LOG);
		}
		LOG.println("end - " + url);
		LOG.println("##########################################################");
		LOG.flush();

	}

}
