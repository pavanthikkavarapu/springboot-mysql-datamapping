package com.example.basicapp.model;

public class AuditSummaryReport {
	
	private CoverPage coverPage;
	
	private AuditSummaryPage auditSummaryPage;
	
	
	private ExceptionDetailCover exceptionDetailCover;
	
	private ReVerificationCover ReVerificationCover;
	private ReVerficationDetail ReVerficationDetail;
	
	
	public ReVerficationDetail getReVerficationDetail() {
		return ReVerficationDetail;
	}

	public void setReVerficationDetail(ReVerficationDetail reVerficationDetail) {
		ReVerficationDetail = reVerficationDetail;
	}

	public ReVerificationCover getReVerificationCover() {
		return ReVerificationCover;
	}

	public void setReVerificationCover(ReVerificationCover reVerificationCover) {
		ReVerificationCover = reVerificationCover;
	}

	public ExceptionDetailCover getExceptionDetailCover() {
		return exceptionDetailCover;
	}

	public void setExceptionDetailCover(ExceptionDetailCover exceptionDetailCover) {
		this.exceptionDetailCover = exceptionDetailCover;
	}
	
	
	public CoverPage getCoverPage() {
		return coverPage;
	}

	public void setCoverPage(CoverPage coverPage) {
		this.coverPage = coverPage;
	}

	public AuditSummaryPage getAuditSummaryPage() {
		return auditSummaryPage;
	}

	public void setAuditSummaryPage(AuditSummaryPage auditSummaryPage) {
		this.auditSummaryPage = auditSummaryPage;
	}
	private Exceptions exceptions;

	public Exceptions getExceptions() {
		return exceptions;
	}

	public void setExceptions(Exceptions exceptions) {
		this.exceptions = exceptions;
	}

}
