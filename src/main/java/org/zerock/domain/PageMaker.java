package org.zerock.domain;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PageMaker {
	private int totalCount;	// sql의 결과로 나온 데이터의 전체 개수
	private int startPage;	// 계산을 통해서 ( (endPage - displayPageNum) + 1 )
	private int endPage;	// 계산을 통해서( (int)( Math.ceil(cri.getPage() / (double)displayPageNum) * displayPageNum );  ) ceil올림값
	private boolean prev;	// 계산을 통해서(startPage == 1 ? false:true;)
	private boolean next;	// 계산을 통해서(endPage * cri.getPerPageNum() >= totalCount ? false:true;)
	private int displayPageNum = 10;// 화면에 보여지는 페이지 번호의 숫자를 의미하는 변수
	private Criteria cri;
	
	public void setCri(Criteria cri) {
		this.cri = cri;
	}
	
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		
		calcData();
	}
	
	private void calcData() {
		endPage = (int) ( Math.ceil( cri.getPage() / (double)displayPageNum ) * displayPageNum );
		//								1					10					10					1 * 10 		10
		startPage = (endPage - displayPageNum) + 1;
		int tempEndPage = (int) ( Math.ceil(totalCount / (double) cri.getPerPageNum() ) );
		//									122						10						12.2	13
		//										83					10		              	8.3		9
		if(endPage > tempEndPage) {
			endPage = tempEndPage;
		}
		
		prev = (startPage == 1) ? false:true;
		
		next = (endPage * cri.getPerPageNum() >= totalCount) ? false : true;
		
	}
	
	
	public String makeQuery(int page) {
		UriComponents uriComponents =
				UriComponentsBuilder.newInstance()
				.queryParam("page",page)
				.queryParam("perPageNum", cri.getPerPageNum())
				.build();
		
		return uriComponents.toUriString();
		
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public Criteria getCri() {
		return cri;
	}

	@Override
	public String toString() {
		return "PageMaker [totalCount=" + totalCount + ", startPage=" + startPage + ", endPage=" + endPage + ", prev="
				+ prev + ", next=" + next + ", displayPageNum=" + displayPageNum + ", cri=" + cri + "]";
	}
	
}
