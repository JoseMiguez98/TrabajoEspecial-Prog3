import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVWritter {
	File file;
	BufferedWriter bw;

	public CSVWritter(String _path) {
		this.file = new File(_path);
		this.bw = null;
	}


	public void escribirSalida(List<Libro> _l) {
		try {

			if (!file.exists()) {
				file.createNewFile();
			}
			
			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			
			for(Libro libro : _l) {
				bw.write(libro.getTitulo());
				bw.newLine();
			}
			
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
			} catch (Exception ex) {
				System.out.println("Error cerrando el BufferedWriter" + ex);
			}
		}
	}
}