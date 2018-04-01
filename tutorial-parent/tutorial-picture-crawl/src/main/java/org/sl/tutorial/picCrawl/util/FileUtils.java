package org.sl.tutorial.picCrawl.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileUtils {

	public static String saveToLocalFile(String src) {
		String path = null;
		URL urlSource;
		InputStream in = null;
		OutputStream out = null;
		try {
			urlSource = new URL(src);
			URLConnection urlConnection = urlSource.openConnection();
			String imageName = src.substring(src.lastIndexOf("/") + 1, src.length());
			in = urlConnection.getInputStream();
			path = String.format("C:\\tmp\\", imageName);
			out = new FileOutputStream(new File(path));
			byte[] buf = new byte[1024];
			int len = 0;
			while ((len = in.read(buf)) != -1) {
				out.write(buf, 0, len);
			}
		} catch (IOException ex) {
			logger.error("cannot save file from {}!", src);
			logger.error(ex.getMessage(), ex);
		} finally {
			try {
				in.close();
			} catch (Exception e1) {
			}
			try {
				out.close();
			} catch (Exception e1) {
			}
		}
		return path;
	}

	private static final Logger logger = LoggerFactory.getLogger(FileUtils.class);
}
