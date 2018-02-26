package common;

import java.util.List;

public class Fenye<T> {
	private int totalPages;
	private List<T> subList;
	private int recPer;
	private int currentPages;
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public List<T> getSubList() {
		return subList;
	}
	public void setSubList(List<T> subList) {
		this.subList = subList;
	}
	public int getRecPer() {
		return recPer;
	}
	public void setRecPer(int recPer) {
		this.recPer = recPer;
	}
	public int getCurrentPages() {
		return currentPages;
	}
	public void setCurrentPages(int currentPages) {
		this.currentPages = currentPages;
	}
	public void init(List<T> list,int currentPages) {
		totalPages = list.size()/recPer;
		if (list.size()%recPer !=0) {
			totalPages++;
		}
		if (currentPages<totalPages) {
			subList = list.subList((currentPages-1)*recPer, currentPages*recPer);
		}else{
			subList = list.subList((currentPages-1)*recPer, list.size());
		}
	}

}
