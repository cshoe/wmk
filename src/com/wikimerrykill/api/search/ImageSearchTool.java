package com.wikimerrykill.api.search;

import java.util.ArrayList;

import com.google.gwt.core.client.JsArray;
import com.google.gwt.search.client.ImageResult;
import com.google.gwt.search.client.ImageSearch;
import com.google.gwt.search.client.ImageSizeValue;
import com.google.gwt.search.client.Result;
import com.google.gwt.search.client.ResultSetSize;
import com.google.gwt.search.client.SafeSearchValue;
import com.google.gwt.search.client.SearchUtils;

public class ImageSearchTool {
	public boolean isInitialized = false;
	private ImageSearch is;
	private String searchSite;
	private String searchKey;
	
	public ImageSearchTool() {
		
	}
	
	public void searchImages(String site, String key) {
		searchSite = site;
		searchKey = key;
		
		if (!isInitialized) {
			SearchUtils.loadSearchApi(new Runnable() {
				public void run() {
					isInitialized = true;
					doSearchImages();
				}
			});
		} else {
			doSearchImages();
		}
	}
	
	private void doSearchImages() {
		is = new ImageSearch();
		
		if (searchSite != null) {
			is.setSiteRestriction(searchSite);
		}
		
		is.setSafeSearch(SafeSearchValue.STRICT);
		is.setResultSetSize(ResultSetSize.SMALL);
		is.setImageSize(ImageSizeValue.MEDIUM);
		
		is.execute(searchKey);
	}
	
	public ArrayList<ImageResult> getResults() {
		if (is != null) {
			JsArray<? extends Result> rs = is.getResults();
			ArrayList<ImageResult> rList = new ArrayList<ImageResult>();
			for (int i = 0; i < rs.length(); i++) {
				Result r = rs.get(i);
				ImageResult ir = ImageResult.isImageResult(r);  //returns null if not image result
				if (ir != null) {
					rList.add((ImageResult)r);
				}
			}
			return rList;
		} else {
			//no search done yet.
			return null;
		}
	}
}
