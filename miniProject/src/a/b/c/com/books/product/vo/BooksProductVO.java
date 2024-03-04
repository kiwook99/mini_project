package a.b.c.com.books.product.vo;

public class BooksProductVO {
	
		private String pbnum;
		private String pbname;
		private String pbgenre;
		private String pbcompany;
		private String pbfile;
		private String pbcnt;
		private String pbprice;
		private String pbdesc;
		private String updatedate;
		private String deleteyn;
		private String insertdate;
		
		//search 변수
		private String keyword;			// 검색어
		private String searchFilter;	// 검색조건
		
		private String pageSize;
		private String groupSize;
		private String curPage;
		private String totalCount;
		
		public BooksProductVO() {
			
		}
		
		public BooksProductVO(String pbnum, String pbname, String pbgenre, String pbcompany,
				String pbfile, String pbcnt, String pbprice, String pbdesc, String updatedate,
				String deleteyn, String insertdate) {
			
			this.pbnum=pbnum;
			this.pbname=pbname;
			this.pbgenre=pbgenre;
			this.pbcompany=pbcompany;
			this.pbfile=pbfile;
			this.pbcnt=pbcnt;
			this.pbprice=pbprice;
			this.pbdesc=pbdesc;
			this.updatedate=updatedate;
			this.deleteyn=deleteyn;
			this.insertdate=insertdate;
			
		}
		
		public BooksProductVO(String pbnum, String pbname, String pbgenre, String pbcompany,
				String pbfile, String pbcnt, String pbprice, String pbdesc, String updatedate,
				String deleteyn, String insertdate, String keyword, String searchFilter) {
			
			this.pbnum=pbnum;
			this.pbname=pbname;
			this.pbgenre=pbgenre;
			this.pbcompany=pbcompany;
			this.pbfile=pbfile;
			this.pbcnt=pbcnt;
			this.pbprice=pbprice;
			this.pbdesc=pbdesc;
			this.updatedate=updatedate;
			this.deleteyn=deleteyn;
			this.insertdate=insertdate;
			this.keyword=keyword;
			this.searchFilter=searchFilter;
		}
		
		public BooksProductVO(String pbnum, String pbname, String pbgenre, String pbcompany,
				String pbfile, String pbcnt, String pbprice, String pbdesc, String updatedate,
				String deleteyn, String insertdate, String pageSize, String groupSize, String curPage, String totalCount) {
			
			this.pbnum=pbnum;
			this.pbname=pbname;
			this.pbgenre=pbgenre;
			this.pbcompany=pbcompany;
			this.pbfile=pbfile;
			this.pbcnt=pbcnt;
			this.pbprice=pbprice;
			this.pbdesc=pbdesc;
			this.updatedate=updatedate;
			this.deleteyn=deleteyn;
			this.insertdate=insertdate;
			this.pageSize=pageSize;
			this.groupSize=groupSize;
			this.curPage=curPage;
			this.totalCount=totalCount;
		}

		public String getKeyword() {
			return keyword;
		}

		public void setKeyword(String keyword) {
			this.keyword = keyword;
		}

		public String getSearchFilter() {
			return searchFilter;
		}

		public void setSearchFilter(String searchFilter) {
			this.searchFilter = searchFilter;
		}
		
		public String getPbnum() {
			return pbnum;
		}

		public void setPbnum(String pbnum) {
			this.pbnum = pbnum;
		}

		public String getPbname() {
			return pbname;
		}

		public void setPbname(String pbname) {
			this.pbname = pbname;
		}

		public String getPbgenre() {
			return pbgenre;
		}

		public void setPbgenre(String pbgenre) {
			this.pbgenre = pbgenre;
		}

		public String getPbcompany() {
			return pbcompany;
		}

		public void setPbcompany(String pbcompany) {
			this.pbcompany = pbcompany;
		}

		public String getPbfile() {
			return pbfile;
		}

		public void setPbfile(String pbfile) {
			this.pbfile = pbfile;
		}

		public String getPbcnt() {
			return pbcnt;
		}

		public void setPbcnt(String pbcnt) {
			this.pbcnt = pbcnt;
		}

		public String getPbprice() {
			return pbprice;
		}

		public void setPbprice(String pbprice) {
			this.pbprice = pbprice;
		}

		public String getPbdesc() {
			return pbdesc;
		}

		public void setPbdesc(String pbdesc) {
			this.pbdesc = pbdesc;
		}

		public String getUpdatedate() {
			return updatedate;
		}

		public void setUpdatedate(String updatedate) {
			this.updatedate = updatedate;
		}

		public String getDeleteyn() {
			return deleteyn;
		}

		public void setDeleteyn(String deleteyn) {
			this.deleteyn = deleteyn;
		}

		public String getInsertdate() {
			return insertdate;
		}

		public void setInsertdate(String insertdate) {
			this.insertdate = insertdate;
		}

		public String getPageSize() {
			return pageSize;
		}

		public void setPageSize(String pageSize) {
			this.pageSize = pageSize;
		}

		public String getGroupSize() {
			return groupSize;
		}

		public void setGroupSize(String groupSize) {
			this.groupSize = groupSize;
		}

		public String getCurPage() {
			return curPage;
		}

		public void setCurPage(String curPage) {
			this.curPage = curPage;
		}

		public String getTotalCount() {
			return totalCount;
		}

		public void setTotalCount(String totalCount) {
			this.totalCount = totalCount;
		}
		
}

	
