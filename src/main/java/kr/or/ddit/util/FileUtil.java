package kr.or.ddit.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileUtil {
	private static final Logger logger = LoggerFactory.getLogger(FileUtil.class);

	public static String getFileName(String contentDisposition) {
		String[] attrs = contentDisposition.split("; ");
		for (String attr : attrs) {
			if (attr.startsWith("filename=")) {
				// filename = "brown.jpg"
				attr = attr.replace("filename=", "");
				//
				// "brown.jpg"
				return attr.substring(1, attr.length() - 1);
			}
		}
		return "";
	}

	// third method
	public static String getFileExtension(String filename) {
		// brown
		if (filename.indexOf(".") == -1) {
			return "";
		}
		return "." + filename.substring(filename.lastIndexOf(".") + 1);
	}

//second method
	public static String getFileExtensionxxx(String filename) {
		// line.brown.png
		return filename.substring(filename.lastIndexOf(".") + 1);
	}

	// first method
	public static String getFileExtensionxx(String filename) {
		// brown.png ==> [0] = brown / [1] = png
		filename.split(".");
		return filename.split("\\.")[1];
	}

	// myself
	public static String getFileExtensionx(String filename) {
		String exfilename = filename;
		exfilename = exfilename.substring(exfilename.indexOf(".") + 1, exfilename.length());
		return exfilename;
	}

	// myself
	public static String getFileNamex(String contentDisposition) {
		String original = contentDisposition;
		int x = original.indexOf("\"");
		String filename = original.substring(original.indexOf("filename=\"") + 10, original.lastIndexOf("\""));
		System.out.println("x : " + x);
		logger.debug("y : " + filename);

		return filename;
	}
}
