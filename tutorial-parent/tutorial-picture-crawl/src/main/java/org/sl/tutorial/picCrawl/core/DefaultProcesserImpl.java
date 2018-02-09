package org.sl.tutorial.picCrawl.core;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("defaultProcesser")
public class DefaultProcesserImpl implements IProcesser {

	@Override
	public void processElements(Elements el) {

		logger.info("{}", el);

		Element e = el.get(0);
		String srcAttr = e.attr("src");
		String src = null;
		if (srcAttr.startsWith("//")) {
			src = String.format("http:%s", srcAttr);
		} else {
			src = e.absUrl("src");
		}

		URL urlSource;
		InputStream in = null;
		OutputStream out = null;
		try {
			urlSource = new URL(src);
			URLConnection urlConnection = urlSource.openConnection();
			String imageName = src.substring(src.lastIndexOf("/") + 1, src.length());
			logger.info("img url is {}.", src);
			in = urlConnection.getInputStream();
			out = new FileOutputStream(new File("C:\\tmp\\", imageName));
			byte[] buf = new byte[1024];
			int len = 0;
			while ((len = in.read(buf)) != -1) {
				out.write(buf, 0, len);
			}
		} catch (IOException ex) {
			logger.error("src attr is {}, and src address is {}", srcAttr, src);
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
	}

	private static final Logger logger = LoggerFactory.getLogger(DefaultProcesserImpl.class);

}
