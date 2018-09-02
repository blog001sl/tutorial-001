package org.sl.food.task.processer;

import java.util.List;

import org.jsoup.nodes.Document;

public interface IProcesser<T> {

	public List<T> processerDocument(Document doc);
}
