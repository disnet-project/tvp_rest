package edu.upm.midas.service;

import edu.upm.midas.constants.Constants;
import edu.upm.midas.model.ValidationFinding;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class FindingsManager {

	/**
	 * M�todo para escribir los findings en un fichero de texto.
	 * @param findings Recibe los findings.
	 * @param f Recibe el fichero.
	 * @throws Exception Puede lanzar excepci�n.
	 */
	public void write(List<ValidationFinding> findings, String f)
			throws Exception {
		BufferedWriter bW = new BufferedWriter(new FileWriter(f));
		for (int i = 0; i < findings.size(); i++) {
			bW.write(findings.get(i).toWrite());
			bW.newLine();
		}
		bW.close();
	}

	/**
	 * M�todo para juntar todos los ficheros en uno solo.
	 * @param folder Recibe el directorio donde est�n todos los ficheros.
	 * @param file Recibe el fichero donde guardar los datos.
	 * @throws Exception Puede lanzar excepci�n.
	 */
	public void mergeAll(String folder, String file) throws Exception {
		System.out.println("Merging all findings-files in a single one..");
		System.out.println("Source folder: " + folder);
		System.out.println("Destiny file: " + file);
		List<ValidationFinding> fds = readAllFindingsFiles(folder);
		BufferedWriter bW = new BufferedWriter(new FileWriter(file));
		for (int i = 0; i < fds.size(); i++) {
			bW.write(fds.get(i).toWrite());
			bW.newLine();
		}
		bW.close();
		System.out.println("Process finished! Total findings: " + fds.size());
	}

	/**
	 * M�todo para cargar todos los findings dado un directorio.
	 * @param folder Recibe el directorio.
	 * @return Devuelve la lista de findings.
	 * @throws Exception Puede lanzar excepci�n.
	 */
	private List<ValidationFinding> readAllFindingsFiles(String folder)
			throws Exception {
		List<ValidationFinding> findings = new ArrayList<>();
		File fold = new File(folder);
		for (int i = 0; i < fold.listFiles().length; i++) {
			File f = fold.listFiles()[i];
			if (f.isFile()) {
				int readed = 0;
				System.out.print("\tReading file '" + f.getAbsoluteFile().getName() + "' .. ");
				BufferedReader bL = new BufferedReader(new FileReader(f));
				while (bL.ready()) {
					String rd = bL.readLine();
					String parts[] = rd.split("!");
					if (parts.length == 7) {
						String name = parts[0];
						String mainCode = parts[1];
						String cuis[] = parts[2].split("@");
						String uri = parts[3];
						String synonyms[] = parts[4].split("@");
						String codes[] = parts[5].split("@");
						String source = parts[6];
						ValidationFinding fd = new ValidationFinding(name);
						fd.setCode(mainCode);
						fd.addCuis(getListFromArray(cuis));
						fd.setURI(uri);
						fd.setSynonyms(getListFromArray(synonyms));
						fd.setCodes(getListFromArray(codes));
						fd.setSource(source);
						readed++;
						findings.add(fd);
					} else {
						System.err.println("Error in line (file: "
								+ f.getAbsoluteFile().getName() + "): " + rd
								+ " [Parts: " + parts.length + "]");
					}
				}
				bL.close();
				System.out.println("Done! Readed " + readed + " findings.");
			}
		}
		return findings;
	}

	/**
	 * M�todo para meter un array en una lista.
	 * @param array Recibe un array.
	 * @return Devuelve la lista.
	 */
	private List<String> getListFromArray(String[] array) {
		List<String> list = new ArrayList<>();
		for (int i = 0; i < array.length; i++) {
			list.add(array[i]);
		}
		return list;
	}

	/** MUY IMPORTANTE
	 * M�todo para cargar todos los findings de un fichero �nico.
	 * @param f Recibe el nombre del fichero.
	 * @return Puede lanzar una excepci�n.
	 * @throws Exception Puede lanzar excepci�n.
	 */
	public List<ValidationFinding> loadAllFindings() throws Exception {
		List<ValidationFinding> findings = new ArrayList<>();
		int readed = 0;
		BufferedReader bL = new BufferedReader( new InputStreamReader(getClass().getResourceAsStream( Constants.VALIDATION_FILE )) );
		while (bL.ready()) {
			String rd = bL.readLine();
			String parts[] = rd.split("!");
			if (parts.length == 7) {
				String name = parts[0];
				String mainCode = parts[1];
				String cuis[] = parts[2].split("@");
				String uri = parts[3];
				String synonyms[] = parts[4].split("@");
				String codes[] = parts[5].split("@");
				String source = parts[6];
				ValidationFinding fd = new ValidationFinding(name);
				fd.setCode(mainCode);
				fd.addCuis(getListFromArray(cuis));
				fd.setURI(uri);
				fd.setSynonyms(getListFromArray(synonyms));
				fd.setCodes(getListFromArray(codes));
				fd.setSource(source);
				readed++;
				findings.add(fd);
			} else {
//				System.err.println("Error in line (file: "
//						+ new File(f).getAbsoluteFile().getName() + "): " + rd
//						+ " [Parts: " + parts.length + "]");
			}
		}
		bL.close();
//		System.out.println("Done! Readed " + readed + " findings.");
		return findings;
	}
}
