package org.sl.tutorial.picCrawl.core;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.sl.tutorial.picCrawl.util.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SaveToDatabaseProcesserImpl implements IProcesser {

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

		String path = FileUtils.saveToLocalFile(src);
	}

	private static final Logger logger = LoggerFactory.getLogger(SaveToDatabaseProcesserImpl.class);
}
