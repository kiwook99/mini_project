package a.b.c.com.books.mem.vo;

public class BooksMemVO {
	
	private String mbnum;
	private String mbname;
	private String mbtel;
	private String mbid;
	private String mbpw;
	private String mbaddr;
	private String deleteyn;
	private String insertdate;
	
	// search 변수
	private String keyword;			// 검색어
	private String searchFilter;	// 검색조건
	private String startDate;		// 검색기간 시작일
	private String endDate;			// 검색기간 종료일
	
	// 페이징 이동 필드
	private String pageSize;
	private String groupSize;
	private String curPage;
	private String totalCount;
		
	// 생성자
	public BooksMemVO() {
		
	}
	
	public BooksMemVO(String mbnum, String mbname, String mbtel, String mbid, String mbpw, String mbaddr, String deleteyn,
			String insertdate) {
		
		this.mbnum = mbnum;
		this.mbname = mbname;
		this.mbtel = mbtel;
		this.mbid = mbid;
		this.mbpw = mbpw;
		this.mbaddr = mbaddr;
		this.deleteyn = deleteyn;
		this.insertdate = insertdate;

	}
	
	
	public BooksMemVO(String mbnum, String mbname, String mbtel, String mbid, String mbpw, String mbaddr, String deleteyn,
			String insertdate, String keyword, String searchFilter, String startDate,
			String endDate) {
		
		this.mbnum = mbnum;
		this.mbname = mbname;
		this.mbtel = mbtel;
		this.mbid = mbid;
		this.mbpw = mbpw;
		this.mbaddr = mbaddr;
		this.deleteyn = deleteyn;
		this.insertdate = insertdate;
		this.keyword = keyword;
		this.searchFilter = searchFilter;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	
	public BooksMemVO(String mbnum, String mbname, String mbtel, String mbid, String mbpw, String mbaddr, String deleteyn,
			String insertdate, String keyword, String searchFilter, String startDate, String endDate,
			String pageSize, String groupSize, String curPage, String totalCount) {
		
		this.mbnum = mbnum;
		this.mbname = mbname;
		this.mbtel = mbtel;
		this.mbid = mbid;
		this.mbpw = mbpw;
		this.mbaddr = mbaddr;
		this.deleteyn = deleteyn;
		this.insertdate = insertdate;
		this.keyword = keyword;
		this.searchFilter = searchFilter;
		this.startDate = startDate;
		this.endDate = endDate;
		this.pageSize = pageSize;
		this.groupSize = groupSize;
		this.curPage = curPage;
		this.totalCount = totalCount;
	}

	public String getMbnum() {
		return mbnum;
	}

	public void setMbnum(String mbnum) {
		this.mbnum = mbnum;
	}

	public String getMbname() {
		return mbname;
	}

	public void setMbname(String mbname) {
		this.mbname = mbname;
	}

	public String getMbtel() {
		return mbtel;
	}

	public void setMbtel(String mbtel) {
		this.mbtel = mbtel;
	}

	public String getMbid() {
		return mbid;
	}

	public void setMbid(String mbid) {
		this.mbid = mbid;
	}

	public String getMbpw() {
		return mbpw;
	}

	public void setMbpw(String mbpw) {
		this.mbpw = mbpw;
	}

	public String getMbaddr() {
		return mbaddr;
	}

	public void setMbaddr(String mbaddr) {
		this.mbaddr = mbaddr;
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

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
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
