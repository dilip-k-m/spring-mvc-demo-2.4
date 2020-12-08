package com.dilip.movie.model;

import java.util.List;

public class CatalogItemList {

	private List<CatalogItem> catalogs;

	public CatalogItemList(List<CatalogItem> catalogs) {
		super();
		this.catalogs = catalogs;
	}

	public List<CatalogItem> getCatalogs() {
		return catalogs;
	}

	public void setCatalogs(List<CatalogItem> catalogs) {
		this.catalogs = catalogs;
	}

	@Override
	public String toString() {
		return "CatalogItemList [catalogs=" + catalogs + "]";
	}

}
