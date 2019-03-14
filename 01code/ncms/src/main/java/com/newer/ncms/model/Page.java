package com.newer.ncms.model;

import java.util.List;

/**
 * 分页实体类
 * 
 * @author ZhangXin
 *
 */
public class Page<T> {
	private int totalPages;// 总页数
	private int pageSize;// 每页显示多少条数据
	private int totalrows;// 总记录数
	private int curPage;// 当前页
	private List<T> list;
	private int status;

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalrows() {
		return totalrows;
	}

	public void setTotalrows(int totalrows) {
		this.totalrows = totalrows;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Page [totalPages=" + totalPages + ", pageSize=" + pageSize + ", totalrows=" + totalrows + ", curPage="
				+ curPage + ", list=" + list + ", status=" + status + "]";
	}

	public Page(String curPage, int totalrows, int pageSize) {
		this.totalrows = totalrows;
		this.pageSize = pageSize;

		// 记录总页数
		this.totalPages = this.totalrows / this.pageSize + (this.totalrows % this.pageSize == 0 ? 0 : 1);

		this.curPage = 1;

		try {
			this.curPage = Integer.parseInt(curPage);
		} catch (Exception e) {

		}

		if (this.curPage > this.totalPages) {
			this.curPage = this.totalPages;
		}

		if (this.curPage < 1) {
			this.curPage = 1;
		}
	}

	/**
	 * .是否有上一页
	 * 
	 * @return
	 */
	public boolean isHasPrev() {
		return this.curPage > 1;
	}

	/**
	 * .是否有下一页
	 * 
	 * @return
	 */
	public boolean isHasNext() {
		return this.curPage < this.totalPages;
	}

	/**
	 * .返回上一页的页码
	 * 
	 * @return
	 */
	public int getPrev() {
		if (isHasPrev()) {
			return this.curPage - 1;
		}
		return this.curPage;
	}

	/**
	 * .返回下一页的页码
	 * 
	 * @return
	 */
	public int getNext() {
		if (isHasNext()) {
			return this.curPage + 1;
		}
		return this.curPage;
	}

}
