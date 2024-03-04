package a.b.c.com.books.cart.vo;

public class BooksCartVO {
	
	private String cbnum;
	private String pbnum;
	private String pbname;
	private String pbfile;
	private String pbcnt;
	private String pbprice;
	private String pbpricesum;	
	private String kmnum;
	private String deleteyn;
	private String insertdate;
	private String updatedate;
	
	private String cbnumarr[];
	
	// 생성자 
	public BooksCartVO() {
		
	}

	public BooksCartVO(String cbnum, String pbnum, String pbname, String pbfile, String pbcnt, String pbprice,
			String pbpricesum,String kmnum, String deleteyn, String insertdate, String updatedate) {
		
		this.cbnum = cbnum;
		this.pbnum = pbnum;
		this.pbname = pbname;
		this.pbfile = pbfile;
		this.pbcnt = pbcnt;
		this.pbprice = pbprice;
		this.pbpricesum = pbpricesum;
		this.kmnum=kmnum;
		this.deleteyn = deleteyn;
		this.insertdate = insertdate;
		this.updatedate = updatedate;
	}

	public BooksCartVO(String cbnum, String pbnum, String pbname, String pbfile, String pbcnt, String pbprice,
			String pbpricesum,String kmnum, String deleteyn, String insertdate, String updatedate,
			String[] cbnumarr) {

		this.cbnum = cbnum;
		this.pbnum = pbnum;
		this.pbname = pbname;
		this.pbfile = pbfile;
		this.pbcnt = pbcnt;
		this.pbprice = pbprice;
		this.pbpricesum = pbpricesum;
		this.kmnum=kmnum;
		this.deleteyn = deleteyn;
		this.insertdate = insertdate;
		this.updatedate = updatedate;
		this.cbnumarr = cbnumarr;
	}

	public String getCbnum() {
		return cbnum;
	}

	public void setCbnum(String cbnum) {
		this.cbnum = cbnum;
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

	public String getPbpricesum() {
		return pbpricesum;
	}

	public void setPbpricesum(String pbpricesum) {
		this.pbpricesum = pbpricesum;
	}

	public String getKmnum() {
		return kmnum;
	}

	public void setKmnum(String kmnum) {
		this.kmnum = kmnum;
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

	public String getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}

	public String[] getCbnumarr() {
		return cbnumarr;
	}

	public void setCbnumarr(String[] cbnumarr) {
		this.cbnumarr = cbnumarr;
	}

}
